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
//        db.addEquipment("HDMI Cable", 0, "A cable that connects computer to a projector.", "Video accessories");
//        db.addEquipment("Bandage", 0, "For first aid", "Medical");

        AssignmentDB db = new AssignmentDB();
        
        //  list users
        System.out.println("== List Users == ");
        ArrayList<UserBean> users = db.listUsers();
        for (UserBean user : users) {
            System.out.println(user.getUsername());
        }
        
        System.out.println("== List Inventory ==");
        
        
        ArrayList<EquipmentBean> equipments = db.listAllEquipment();
        for (EquipmentBean equipment : equipments){
            System.out.println(equipment.getname() + ": " + equipment.getDescription() );
        }
    }
}
