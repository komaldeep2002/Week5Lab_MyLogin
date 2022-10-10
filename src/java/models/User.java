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
import java.io.Serializable;

/**
 *
 * @author user
 */
public class User implements Serializable {

    private String username;
    private String password;

    public User() {
        username = "";
        password = "";
    }

    public User(String username, Object object) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}