/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.test;

import ivpet.db.AssignmentDB;

/**
 *
 * @author op7
 */
public class TestDB {

	public static void main(String[] args) {
		String url = "jdbc:derby://localhost:1527/4511EA";
		String username = "APP";
		String password = "AWSDAWSD123";
AssignmentDB db = new AssignmentDB();
db.addBorrowRecord(2, 0, "2020-12-10", "2020-12-10", Boolean.TRUE, 1);
	}
}
