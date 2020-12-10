/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.bean;

/**
 *
 * @author ngkac
 */
public class ReservationEquipmentBean {
    private int Rid;
    private int Eid;
        public ReservationEquipmentBean() {
    }

    public ReservationEquipmentBean(int Rid,int Eid) {
        this.Rid = Rid;
        this.Eid = Eid;
    }
    public int getRid(){
    return Rid;
    }
        public int geEid(){
    return Eid;
    }
        public void setRid(int x){
        Rid=x;
        }
        public void setEid(int x){
        Eid=x;
        }
}
