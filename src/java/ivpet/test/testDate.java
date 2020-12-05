/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.test;

import java.time.LocalDate;

/**
 *
 * @author hsk
 */
public class testDate {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate due_date = today.plusDays(14);
        System.out.println(today);
        System.out.println(due_date);
    }
}
