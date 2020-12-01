
import ivpet.bean.BorrowRecordBean;
import ivpet.bean.EquipmentBean;
import ivpet.bean.ReservationRequestBean;
import ivpet.bean.UserBean;
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
  public static void main(String[] args) {
    String url = "jdbc:derby://localhost:1527/4511";
    String username = "APP";
    String password = "APP";
    AssignmentDB Db = new AssignmentDB(url, username, password);
    UserBean cb = new UserBean(1, "BB", "CC", 2);
    EquipmentBean eb = new EquipmentBean(2, "test", 1, true, "Dec", "TAG");
    ReservationRequestBean rb = new ReservationRequestBean(1, "123", 1, 1);
    BorrowRecordBean bb = new BorrowRecordBean(1, 1, "2020-10-10", "2020-10-10", "2020-10-10", true, 1);
    Db.editBorrowRecord(bb);
  }

}
