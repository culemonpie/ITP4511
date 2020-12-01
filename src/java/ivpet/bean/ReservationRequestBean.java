/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.bean;

import java.io.Serializable;

/**
 *
 * @author ngkac
 */
public class ReservationRequestBean implements Serializable {
    private String equipment_id;
    private int submitted_by;
    private int approved_by;
    private int type;

    public ReservationRequestBean() {
    }

    public ReservationRequestBean(String equipment_id, int submitted_by, int approved_by, int type) {
        this.equipment_id = equipment_id;
        this.submitted_by = submitted_by;
        this.approved_by = approved_by;
        this.type = type;
    }

    public String getequipment_id() {
        return equipment_id;
    }

    public int getsubmitted_by() {
        return submitted_by;
    }

    public int getapproved_by() {
        return approved_by;
    }

    public int gettype() {
        return type;
    }

    public void setequipment_id(String v) {
        equipment_id = v;
    }

    public void setsubmitted_by(int v) {
        submitted_by = v;
    }

    public void setapproved_by(int v) {
        approved_by = v;
    }

    public void settype(int v) {
        type = v;
    }

}
