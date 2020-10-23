package com.example.boxouwe3.data;

import android.database.sqlite.SQLiteDatabase;

import com.example.boxouwe3.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;
    private LoginDataSource dataSource;
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    //instance returnen
    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }
    //boolean voor of er ingelogd is
    public boolean isLoggedIn() {
        return user != null;
    }

    //logout method
    public void logout() {
        user = null;
        dataSource.logout();
    }

    //De ingelogde user is de huidige user
    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
    }

    //achterhalen van het resultaat van de login
    public Result<LoggedInUser> login(String username, String password) {
        // handle login
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }
}