package ivpet.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRecordBean implements Serializable {
    private int id;
    private int status;
    private String checkout_date;
    private String due_date;
    private String return_date;
    private boolean is_overdue;
    private int approved_by;

    public BorrowRecordBean() {
    }

    public BorrowRecordBean(int id, int status, String checkout_date, String due_date, String return_date,
            boolean is_overdue, int approved_by) {
        this.approved_by = approved_by;
        this.checkout_date = checkout_date;
        this.due_date = due_date;
        this.id = id;
        this.is_overdue = is_overdue;
        this.return_date = return_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(int approved_by) {
        this.approved_by = approved_by;
    }

    public boolean getIs_overdue() {
        return is_overdue;
    }

    public void setIs_overdue(boolean is_overdue) {
        this.is_overdue = is_overdue;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        this.checkout_date = checkout_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getStatusType() {
        LocalDate d = LocalDate.parse(due_date);
        LocalDate n = LocalDate.now();
        
        if(n.isAfter(d)){
            if(return_date==null){
            return "is overdue";}
        }
        if(status==0){
        return "on lease";
        }else if(status==1){
        return "completed ";
        }
        return "";
    }
}
