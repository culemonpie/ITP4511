/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.test;

import ivpet.db.AssignmentDB;
import ivpet.bean.*;

/**
 *
 * @author hsk
 */
public class TestReservationBean {
    public static void main(String[] args) {
        ReservationRequestBean reservation = new ReservationRequestBean();
        reservation.setId(1);
        
        EquipmentBean equipment1 = new EquipmentBean();
        equipment1.setname("HDMI");
        equipment1.setDescription("XXX");
        equipment1.setstatus(1);
    }
}
