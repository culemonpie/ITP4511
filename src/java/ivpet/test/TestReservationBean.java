/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.test;

import ivpet.db.AssignmentDB;
import ivpet.bean.*;
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
        System.out.println("==Delete Table==");
        db.dropTable();
        System.out.println("==Create Table==");
        db.createTable();

        int user_id = db.addUser("lwlse", "it114105", 0);
        UserBean user = db.getUser(1);

        System.out.println("User id:" + user.getId() + " / Name: " + user.getUsername());

//        ReservationRequestBean reservation = new ReservationRequestBean();
//        reservation.setId(1);
        EquipmentBean equipment1 = new EquipmentBean();
        equipment1.setname("HDMI");
        equipment1.setDescription("HDMI Cable");
        equipment1.setstatus(1);

        EquipmentBean equipment2 = new EquipmentBean();
        equipment2.setname("Bandage");
        equipment2.setDescription("Fat");
        equipment2.setstatus(1);

        int reservation_id = db.addReservationRequest(user_id, 0);
        ReservationRequestBean reservation = db.getReservationRequest(reservation_id);

        ArrayList<EquipmentBean> equipments = new ArrayList();
        equipments.add(equipment1);
        equipments.add(equipment2);

        reservation.setEquipments(equipments);
        reservation.setsubmitted_by(user_id);

        db.editReservationRequestRecord(reservation);

//        String n = db.getUser(reservation.getId()).getUsername();
        String msg = String.format("\n==Reservation Bean==\nid: %s\nSubmitted By: %s\nItems: (todo)",
                reservation.getId(),
                db.getUser(reservation.getId()).getUsername()
        );
        System.out.println(msg);

//        reservation_id = 1;
    }
}
