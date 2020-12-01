import ivpet.bean.BorrowRecordBean;
import ivpet.bean.EquipmentBean;
import ivpet.bean.ReservationRequestBean;
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
        for (UserBean user : users) {
            System.out.println(user.getUsername());
        }
//        db.addUser("adayuen@exampl.com", "jojocat", 3);
        UserBean cb = new UserBean("BB", "CC", 2);
//        EquipmentBean eb = new EquipmentBean(2, "test", 1, true, "Dec", "TAG");
//        ReservationRequestBean rb = new ReservationRequestBean(1, "123", 1, 1);
        BorrowRecordBean bb = new BorrowRecordBean(1, 1, "2020-10-10", "2020-10-10", "2020-10-10", true, 1);
        db.editBorrowRecord(bb);
    }
}
