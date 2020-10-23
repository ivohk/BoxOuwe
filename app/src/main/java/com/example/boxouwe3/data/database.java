package com.example.boxouwe3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "mydatabase.db";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION); }

// Creëren van de database
    @Override
    public void onCreate(SQLiteDatabase mydatabase) {
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Inloggegevens ( gebruiker_id INTEGER(10) NOT NULL PRIMARY KEY AUTOINCREMENT , voornaam VARCHAR(40) NOT NULL , achternaam VARCHAR(40) NOT NULL , email VARCHAR NOT NULL UNIQUE , wachtwoord VARCHAR NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Administrator ( admin_id INTEGER PRIMARY KEY NOT NULL REFERENCES Inloggegevens(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Gebruiker     ( gebruiker_id INTEGER(10) NOT NULL PRIMARY KEY REFERENCES Inloggegevens(gebruiker_id) , leeftijd INTEGER(3) NOT NULL , verified INTEGER(1) NOT NULL , geblokkeerd INTEGER(1) NOT NULL , verjaardag DATE NOT NULL , derde_partij VARCHAR , postcode VARCHAR(6) NOT NULL , huisnummer VARCHAR(6) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Adres         ( postcode INTEGER(6) NOT NULL PRIMARY KEY REFERENCES Gebruiker(postcode) , straatnaam VARCHAR(80) NOT NULL , plaats VARCHAR(60) NOT NULL , land VARCHAR(40) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Hobbys        ( gebruiker_id INTEGER(10) NOT NULL PRIMARY KEY , schaken INTEGER(1) NOT NULL , wandelen INTEGER(1) NOT NULL , kaarten INTEGER(1) NOT NULL , puzzelen INTEGER(1) NOT NULL , bakken INTEGER(1) NOT NULL , koken INTEGER(1) NOT NULL , tuinieren INTEGER(1) NOT NULL , musea_bezoeken INTEGER(1) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.VOG           ( upload_id INTEGER(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker_id INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , image BLOB NOT NULL , behandeld INTEGER(1) NOT NULL , goedgekeurd INTEGER(1) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Chat          ( chat_id INTEGER(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker1 INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , gebruiker2 NOT NULL REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Bericht       ( bericht_id INTEGER(20) NOT NULL PRIMARY KEY AUTOINCREMENT , chat_id INTEGER(20) NOT NULL REFERENCES Chat(chat_id) , verstuurder INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , bericht TEXT NOT NULL , datum DATETIME(0) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Recensie      ( recensie_id INTEGER(10) NOT NULL PRIMARY KEY AUTOINCREMENT , schrijver INTEGER(10) NOT NULL , gerecenseerde INTEGER(10) NOT NULL , recensie TEXT NOT NULL , sterren CHAR NOT NULL CHECK (0 > sterren <= 5) , datum DATETIME(0) NOT NULL , verwijderd INTEGER(1) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Gerapporteerd ( report_id INTEGER(20) NOT NULL PRIMARY KEY AUTOINCREMENT , recensie_id INTEGER(10) NOT NULL REFERENCES Recensie(recensie_id) , rapporteerder_id INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Activiteit    ( activiteit_id INTEGER(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker_id INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , soort_activiteit TEXT NOT NULL CHECK ( soort_activiteit IN ('schaken' , 'wandelen', 'kaarten' , 'puzzelen' , 'bakken' , 'koken' , 'tuinieren' , 'musea bezoeken') ) , begintijd DATETIME(0) NOT NULL , eindtijd DATETIME(0) NOT NULL , locatie TEXT NOT NULL , opmerkingen TEXT , acceptor_id INTEGER(10) REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Reactie       ( reactie_id INTEGER(22) NOT NULL PRIMARY KEY AUTOINCREMENT , activiteit_id INTEGER(20) NOT NULL REFERENCES Activiteit(activiteit_id) , gebruiker_id INTEGER(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , reactie TEXT NOT NULL , datum DATETIME(0) NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydatabase, int i, int i1) {
        // SQL queries voor aanmaken van profiel
        String voornaam = "Jan";            //
        String achternaam = "Jansen";       // Variabelen worden natuurlijk niet hier bepaald, maar ter demonstratie van de queries worden hier waarden geïnitieerd.
        String email = "test@example.nl";   //
        String wachtwoord = "w8woord";      //
        String pushCredentials = "INSERT INTO Inloggegevens (voornaam, achternaam, email, wachtwoord) VALUES ('"+voornaam+"', '"+achternaam+"' , '"+email+"' ,'"+wachtwoord+"')";
        mydatabase.execSQL(pushCredentials);
        // Enzovoorts

        Integer gebruiker_id = 1;

        // Deze query weergeeft de namen van de kolommen in de tabel hobby's. Hierdoor kunnen nieuwe hobby's worden toegevoegd en hoeft geen code worden aangepast.
        String showHobbys = "SELECT COL_NAME(OBJECT_ID('mydatabase.Hobbys'), 1) AS `Hobby's`;";
        mydatabase.execSQL(showHobbys);

        // De query voor invullen van hobby's zal er als volgt uit komen te zien:
        String pushHobbys = "INSERT INTO Hobbys VALUES ('"+gebruiker_id+"', 0 , 1 , 0 , 0 , 1, 0)";
        mydatabase.execSQL(pushHobbys);

        // SQL queries voor opvragen van informatie


        // Query voor 1) kijken of email (en dus gebruiker) in systeem voorkomt, 2) gebruiker niet geblokkeerd is, 3) wachtwoord juist is bij email, 4) gebruiker_id opvragen.
        String checkUserExists = "SELECT gebruiker_id, wachtwoord, geblokkeerd FROM Inloggegevens INNER JOIN Gebruiker ON Inloggegevens.gebruiker_id = Gebruiker.gebruiker_id WHERE email = '"+email+"'";
        mydatabase.execSQL(checkUserExists);

        // Query voor weergeven van profiel

        String selectProfiel = "SELECT i.voornaam, i.achternaam, g.leeftijd, g.profielfoto, g.verified, AVG(re.sterren) FROM Inloggegevens AS i, Gebruiker AS g, Recensie AS re WHERE i.gebruiker_id = g.gebruiker_id = re.gerecenseerde = '"+gebruiker_id+"'";
        String selectHobbys = "SELECT * FROM Hobbys WHERE gebruiker_id = '"+gebruiker_id+"'";
        mydatabase.execSQL(selectProfiel);
        mydatabase.execSQL(selectHobbys);

        // Aanmaken activiteit
        String actAanmaken = "INSERT INTO Activiteiten (gebruiker_id, soort_activiteit, begintijd, eindtijd, locatie, opmerkingen) VALUES ('"+gebruiker_id+"', 'schaken', '2020-10-23 14:06:33', '2020-10-23 18:06:33', 'TU Delft, Delft', 'Kom via de achterdeur.')";
        mydatabase.execSQL(actAanmaken);
    }

}
