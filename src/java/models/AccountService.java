/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Komaldeep Kaur Virk
 */
public class AccountService {
    
    public User login(String username, String password) {
        if (username.equals("abe") && password.equals("password") || username.equals("barb") && password.equals("password")) {
            User user = new User(username, password);
            user.setPassword(null);
            return user;
        } else {
            return null;
        }

    }
    
}
