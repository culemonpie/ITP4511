
import ivpet.bean.UserBean;
import ivpet.db.AssignmentDB;
import java.util.ArrayList;

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

    public static void main(String[] args) {
//        String url = "jdbc:derby://localhost:1527/4511EA";
//        String username = "APP";
//        String password = "AWSDAWSD123";
//        AssignmentDB db = new AssignmentDB(url, username, password);
//        db.createTable();
//        db.addEQUIPMENT("HDMI Cable", 0, "A cable that connects computer to a projector.", "Video accessories");

        AssignmentDB db = new AssignmentDB();
        ArrayList<UserBean> users = db.listUsers();
        for (UserBean user : users){
            System.out.println(user.getUsername());
        }
//        db.addUser("adayuen@exampl.com", "jojocat", 3);
    }
}
