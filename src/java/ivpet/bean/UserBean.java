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
    private int type;

    public UserBean() {
    }

    public UserBean(int id, String username, String password, int type) {
        this.id = id;
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

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public int gettype() {
        return type;
    }

    public void setusername(String v) {
        username = v;
    }

    public void setpassword(String v) {
        password = v;
    }

    public void settype(int v) {
        type = v;
    }

    public String toString() {
        return "username:" + getusername() + "\npassword:" + getpassword() + "\ntype:" + gettype();
    }
}
