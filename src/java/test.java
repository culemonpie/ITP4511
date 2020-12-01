
import ivpet.db.CustomerDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngkac
 */
public class test {
          public static void main(String[] args){
        String url="jdbc:derby://localhost:1527/4511";
        String username="APP";
        String password="APP";
        CustomerDB custDb = new CustomerDB(url,username,password);
        custDb.createCustTable();
    }
}
