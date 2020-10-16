package com.example.boxouwe3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "mydatabase.db";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase mydatabase) {
//        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Inloggegevens ( `gebruiker_id` INT NOT NULL AUTO_INCREMENT , `voornaam` VARCHAR(40) NOT NULL , `achternaam` VARCHAR(40) NOT NULL , `email` VARCHAR NOT NULL , `wachtwoord` VARCHAR NOT NULL , PRIMARY KEY (`gebruiker_id`), UNIQUE (`email`)) ENGINE = InnoDB;");
//        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Administrator ( `admin_id` INT NOT NULL , PRIMARY KEY (`admin_id`)) , FOREIGN KEY (`admin_id`) REFERENCES `Inloggegevens`(`gebruiker_id`) ENGINE = InnoDB;");
//        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Gebruiker ( `gebruiker_id` INT(10) NOT NULL , `leeftijd` INT(3) NOT NULL , `inlogmethode` ENUM('email','google','facebook','instagram') NOT NULL , `verified` BOOLEAN NOT NULL , `geblokkeerd` BOOLEAN NOT NULL , `verjaardag` DATE NOT NULL , `derde_partij` VARCHAR NULL , `postcode` VARCHAR(6) NOT NULL , `huisnummer` VARCHAR(6) NOT NULL , PRIMARY KEY (`gebruiker_id`)) ENGINE = InnoDB;");
//        mydatabase.execSQL("ALTER TABLE `Administrator` ADD INDEX(`admin_id`);");
//        mydatabase.execSQL("ALTER TABLE `Gebruiker` ADD INDEX(`gebruiker_id`);");
//        mydatabase.execSQL("ALTER TABLE `Administrator` ADD FOREIGN KEY (`admin_id`) REFERENCES `Inloggegevens`(`gebruiker_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
//        mydatabase.execSQL("ALTER TABLE `Gebruiker` ADD FOREIGN KEY (`gebruiker_id`) REFERENCES `Inloggegevens`(`gebruiker_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;");
        mydatabase.execSQL("");

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Inloggegevens ( gebruiker_id INT(10) NOT NULL PRIMARY KEY AUTOINCREMENT , voornaam VARCHAR(40) NOT NULL , achternaam VARCHAR(40) NOT NULL , email VARCHAR NOT NULL UNIQUE , wachtwoord VARCHAR NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Administrator ( admin_id INT PRIMARY KEY NOT NULL REFERENCES Inloggegevens(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Gebruiker     ( gebruiker_id INT(10) NOT NULL PRIMARY KEY REFERENCES Inloggegevens(gebruiker_id) , leeftijd INT(3) NOT NULL , verified BOOLEAN NOT NULL , geblokkeerd BOOLEAN NOT NULL , verjaardag DATE NOT NULL , derde_partij VARCHAR , postcode VARCHAR(6) NOT NULL , huisnummer VARCHAR(6) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Adres         ( postcode INT(6) NOT NULL PRIMARY KEY REFERENCES Gebruiker(postcode) , straatnaam VARCHAR(80) NOT NULL , plaats VARCHAR(60) NOT NULL , land VARCHAR(40) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Hobbys        ( gebruiker_id INT(10) NOT NULL PRIMARY KEY , schaken BOOLEAN NOT NULL , wandelen BOOLEAN NOT NULL , kaarten BOOLEAN NOT NULL , puzzelen BOOLEAN NOT NULL , bakken BOOLEAN NOT NULL , koken BOOLEAN NOT NULL , tuinieren BOOLEAN NOT NULL , musea_bezoeken BOOLEAN NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.VOG           ( upload_id INT(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker_id INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , image BLOB NOT NULL , behandeld BOOLEAN NOT NULL , goedgekeurd BOOLEAN NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Chat          ( chat_id INT(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker1 INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , gebruiker2 NOT NULL REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Bericht       ( bericht_id INT(20) NOT NULL PRIMARY KEY AUTOINCREMENT , chat_id INT(20) NOT NULL REFERENCES Chat(chat_id) , verstuurder INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , bericht TEXT NOT NULL , datum DATETIME(0) NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Recensie      ( recensie_id INT(10) NOT NULL PRIMARY KEY AUTOINCREMENT , schrijver INT(10) NOT NULL , gerecenseerde INT(10) NOT NULL , recensie TEXT NOT NULL , sterren CHAR NOT NULL CHECK (0 > sterren <= 5) , datum DATETIME(0) NOT NULL , verwijderd BOOLEAN NOT NULL )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Gerapporteerd ( report_id INT(20) NOT NULL PRIMARY KEY AUTOINCREMENT , recensie_id INT(10) NOT NULL REFERENCES Recensie(recensie_id) , rapporteerder_id INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Activiteit    ( activiteit_id INT(20) NOT NULL PRIMARY KEY AUTOINCREMENT , gebruiker_id INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , soort_activiteit TEXT NOT NULL CHECK ( soort_activiteit IN ('schaken' , 'wandelen', 'kaarten' , 'puzzelen' , 'bakken' , 'koken' , 'tuinieren' , 'musea bezoeken') , begintijd DATETIME(0) NOT NULL , eindtijd DATETIME(0) NOT NULL , locatie TEXT NOT NULL , opmerkingen TEXT NOT NULL , acceptor_id INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) )");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS mydatabase.Reactie       ( reactie_id INT(22) NOT NULL PRIMARY KEY AUTOINCREMENT , activiteit_id INT(20) NOT NULL REFERENCES Activiteit(activiteit_id) , gebruiker_id INT(10) NOT NULL REFERENCES Gebruiker(gebruiker_id) , reactie TEXT NOT NULL , datum DATETIME(0) NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    public void createDb {
//
//
//    }
}
