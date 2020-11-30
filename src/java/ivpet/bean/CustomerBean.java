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


public class CustomerBean implements Serializable {

    private String id;
    private String email_address;
    private String password;
    private int type;

    public CustomerBean() {
    }

    public CustomerBean(String id,String email_address,String password,int type) {
        this.id=id;
        this.email_address= email_address;
        this.password=password;
        this.type=type;
    }

    public String getid() {
        return id;
    }

    public String getemail_address() {
        return email_address;
    }

    public String getpassword() {
        return password;
    }

    public int gettype() {
        return type;
    }

    public void setid(String v) {
        id = v;
    }

    public void setemail_address(String v) {
        email_address = v;
    }

    public void setpassword(String v) {
        password = v;
    }

    public void settype(int v) {
        type = v;
    }

    public String toString() {
        return "ID:" + getid() + "\nemail_address:" + getemail_address() + "\npassword:" + getpassword() + "\ntype:" + gettype();
    }
}

