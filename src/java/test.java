
import ivpet.db.AssignmentDB;

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
        AssignmentDB Db = new AssignmentDB(url,username,password);
Db.addEQUIPMENT("BB", 0, "IS BB");
    }
}
