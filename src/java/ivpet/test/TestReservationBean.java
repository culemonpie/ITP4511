/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.test;

import ivpet.db.AssignmentDB;
import ivpet.bean.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author hsk
 */
public class TestReservationBean {

    public static void main(String[] args) {

        String url = "jdbc:derby://localhost:1527/4511EA_TEST";
        String username = "ivpet";
        String password = "admin";

        AssignmentDB db = new AssignmentDB(url, username, password);
        try {
            System.out.println("==Delete Table==");
//            db.dropTable();
        } catch (Exception e) {

        }
        System.out.println("==Create Table==");
        db.createTable();

        int user_id = db.addUser("lwlse", "it114105", 0);
        int admin_id = db.addUser("admin", "administrator", 0);
        UserBean user = db.getUser(1);

        System.out.println("User id:" + user.getId() + " / Name: " + user.getUsername());

//        ReservationRequestBean reservation = new ReservationRequestBean();
//        reservation.setId(1);
        //Todo: return integer from that
        int equipment_id1 = db.addEquipment("HDMI", 1, "HDMI Cable", "Video accessories");
        int equipment_id2 = db.addEquipment("Bandage", 1, "Bandage used for first aid", "I don't feel so good");

        EquipmentBean equipment1 = db.getEquipment(equipment_id1);
        EquipmentBean equipment2 = db.getEquipment(equipment_id2);

        int reservation_id = db.addReservationRequest(user_id, 0);
        ReservationRequestBean reservation = db.getReservationRequest(reservation_id);

        ArrayList<EquipmentBean> equipments = new ArrayList();
        equipments.add(equipment1);
        equipments.add(equipment2);

        reservation.setEquipments(equipments);
        reservation.setsubmitted_by(user_id);

        db.editReservationRequestRecord(reservation);
        db.setEquipmentByReservation(reservation.getId(), equipments);

        String msg = String.format("\n==Reservation Bean==\nid: %s\nStatus:%s\nSubmitted By: %s\nItems:",
                reservation.getId(),
                reservation.getTypeVerbose(),
                db.getUser(reservation.getId()).getUsername()
        );

        for (EquipmentBean e : db.getEquipmentsByReservation(reservation.getId())) {
            System.out.println("x");
            msg += String.format("\n\t%s: %s", e.getname(), e.getDescription());
        }

        System.out.println(msg);

        System.out.println("ApproveRequest");

        /*
            1. Edit reservation.approved_by = request.session.user
            2. Change all equipments of that reservation to be occupied (status 1)
            3. Create borrow record (status 0, checkout_date = today, returned_date = T+14
            4. Prompt message success
         */
        //1, but that has already been obtained
        String id = reservation.getId() + "";
        reservation = db.getReservationRequest(reservation.getId()); //In production, this should be obtained from request get
        reservation.settype(1);
        
        //2
        for (EquipmentBean equipment : db.getEquipmentsByReservation(reservation.getId())) { //change jor
            equipment.setstatus(1);//occupied
            db.editEquipmentRecord(equipment);
        }

        //3
        LocalDate today = LocalDate.now();
        LocalDate due_date = today.plusDays(14);
        db.addBorrowRecord(reservation.getId(), 0, today.toString(), due_date.toString(), false, admin_id);
        //todo: obtain the instance of BorrowRecordBean
        BorrowRecordBean borrowRecord = db.getBorrowRecord(1);
        
        //print result

        msg = String.format("\n==Reservation Bean==\nid: %s\nStatus:%s\nSubmitted By: %s\nItems:",
                reservation.getId(),
                reservation.getTypeVerbose(),
                db.getUser(reservation.getId()).getUsername()
        );

        for (EquipmentBean e : db.getEquipmentsByReservation(reservation.getId())) {
            msg += String.format("\n\t%s: %s", e.getname(), e.getDescription());
        }

        msg += "";

        System.out.println(msg);
    }
}
