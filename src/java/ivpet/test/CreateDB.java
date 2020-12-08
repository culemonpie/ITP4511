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
public class CreateDB {

    public static void main(String[] args) {


        AssignmentDB db = new AssignmentDB();
        db.createTable();
        System.out.println("==Success==");
    }
}
