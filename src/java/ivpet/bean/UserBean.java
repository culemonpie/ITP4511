/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.bean;

/**
 *
 * @author ngkac
 */
import java.io.Serializable;

public class UserBean implements Serializable {

    private int id;
    private String username;
    private String password;
    private boolean isActive;
    private int type;

    public UserBean() {

    }

    public UserBean(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getType() {
        return type;
    }

    public String getRole() {
        String role = "";

        switch (type) {
            case 1:
                role = "Student";
                break;
            case 2:
                role = "Technician";
                break;
            case 3:
                role = "Senior Technician";
                break;
        }

        return role;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
