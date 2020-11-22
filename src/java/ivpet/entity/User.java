/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.entity;

import java.io.Serializable;

/**
 *
 * @author op7
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int id;

    public User() {
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

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }



}
