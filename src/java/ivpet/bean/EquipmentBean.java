package ivpet.bean;

import java.io.Serializable;

public class EquipmentBean implements Serializable {

    private int id;
    private String name;
    private int status;
    private boolean is_listed;
    private String Description;
    private String Tag;

    public EquipmentBean() {
    }

    public EquipmentBean(int id, String name, int status, boolean is_listed, String Description, String Tag) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.Description = Description;
        this.is_listed = is_listed;
        this.Tag = Tag;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getstatus() {
        return status;
    }

    public String getStatusVerbose() {
        String verbose = "";
        switch (status) {
            case 0:
                verbose = "Available";
                break;
            case 1:
                verbose = "Occupied";
                break;
            case 2:
                verbose = "Under repair";
                break;
            case 3:
                verbose = "Removed";
                break;
        }
        return verbose;
    }

    public boolean getis_listed() {
        return is_listed;
    }

    public String getDescription() {
        return Description;
    }

    public String getTag() {
        return Tag;
    }

    public void setid(int v) {
        id = v;
    }

    public void setname(String v) {
        name = v;
    }

    public void setstatus(int v) {
        status = v;
    }

    public void setDescription(String v) {
        Description = v;
    }

    public void setis_listed(Boolean v) {
        is_listed = v;
    }

    public void setTag(String v) {
        Tag = v;
    }

}
