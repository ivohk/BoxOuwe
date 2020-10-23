package com.example.boxouwe3.data;

import com.example.boxouwe3.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class die de authenticatie van de login bepaalt
 */
public class LoginDataSource {
    //method om het resultaat van de login te achterhalen
    public Result<LoggedInUser> login(String username, String password) {
        //try/catch voor de validatie van de gegevens
        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            username);
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }
    public void logout() {
    }
}