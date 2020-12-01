/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.db;

import ivpet.bean.BorrowRecordBean;
import ivpet.bean.EquipmentBean;
import ivpet.bean.ReservationRequestBean;
/**
 *
 * @author ngkac
 */
import ivpet.bean.UserBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import ivpet.*;

public class AssignmentDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public AssignmentDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }

    public void createTable() {
        Statement stmnt = null;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE USERTABLE (" + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "username VARCHAR(255), password VARCHAR(255), type INTEGER)";
            stmt.execute(sql);
            String sql2 = "CREATE TABLE RESERVATIONREQUEST ("
                    + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "EQUIPMENT_ID VARCHAR(255), submitted_by INTEGER, type INTEGER,FOREIGN KEY (submitted_by) REFERENCES USERTABLE(id))";
            stmt.execute(sql2);
            String sql3 = "CREATE TABLE EQUIPMENT (" + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "NAME VARCHAR(255), Status INTEGER, is_listed Boolean,Description VARCHAR(255),Tag VARCHAR(255))";
            stmt.execute(sql3);
            String sql4 = "CREATE TABLE BORROWRECORDS (" + "id int not null primary key,"
                    + " Status INTEGER,checkout_date date,due_date date,return_date date,is_overdue Boolean,approved_by INTEGER,FOREIGN KEY (id) REFERENCES RESERVATIONREQUEST(id),FOREIGN KEY (approved_by) REFERENCES USERTABLE(id))";
            stmt.execute(sql4);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addUser(String email_address, String password, int type) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO USERTABLE(username,password,type) VALUES(?,?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, email_address);
            pstmt.setString(2, password);
            pstmt.setInt(3, type);
            int rowCount = pstmt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            return isSuccess;
        }
        return isSuccess;
    }

    public boolean addBorrowRecord(int id, int Status, String checkout_date, String due_date, Boolean is_overdue,
            int approved_by) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO BORROWRECORDS(id,Status,checkout_date,due_date,approved_by) VALUES(?,?,?,?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setInt(2, Status);
            pstmt.setString(3, checkout_date);
            pstmt.setString(4, due_date);
            pstmt.setInt(5, approved_by);
            int rowCount = pstmt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            return isSuccess;
        }
        return isSuccess;
    }

    public boolean addequipment(String name, int Status, String Description, String Tag) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO EQUIPMENT(name,Status,is_listed,Description,Tag) VALUES(?,?,'FALSE',?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setInt(2, Status);
            pstmt.setString(3, Description);
            pstmt.setString(4, Tag);
            int rowCount = pstmt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            return isSuccess;
        }
        return isSuccess;
    }

    public boolean addReservationRequest(String equipment_id, int submitted_by, int type) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO RESERVATIONREQUEST(EQUIPMENT_ID,submitted_by,type) VALUES(?,?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, equipment_id);
            pstmt.setInt(2, submitted_by);
            pstmt.setInt(3, type);
            int rowCount = pstmt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            return isSuccess;
        }
        return isSuccess;
    }

    public ArrayList<UserBean> listAllUser() {
        Connection con = null;
        PreparedStatement pstmt = null;
        UserBean cb = null;
        ArrayList<UserBean> arrayList_cb = new ArrayList<UserBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM USERTABLE ";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new UserBean();
                cb.setId(rs.getInt("id"));
                cb.setusername(rs.getString("username"));
                cb.setpassword(rs.getString("password"));
                cb.settype(rs.getInt("type"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<EquipmentBean> listAllEquipment() {
        Connection con = null;
        PreparedStatement pstmt = null;
        EquipmentBean cb = null;
        ArrayList<EquipmentBean> arrayList_cb = new ArrayList<EquipmentBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM Equipment ";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new EquipmentBean();
                cb.setid(rs.getInt("id"));
                cb.setDescription(rs.getString("Description"));
                cb.setTag(rs.getString("Tag"));
                cb.setis_listed(rs.getBoolean("is_listed"));
                cb.setname(rs.getString("name"));
                cb.setstatus(rs.getInt("status"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<ReservationRequestBean> listAllReservationRequest() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ReservationRequestBean cb = null;
        ArrayList<ReservationRequestBean> arrayList_cb = new ArrayList<ReservationRequestBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM ReservationRequest ";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new ReservationRequestBean();
                cb.setId(rs.getInt("id"));
                cb.setsubmitted_by(rs.getInt("submitted_by"));
                cb.setequipment_id(rs.getString("equipment_id"));
                cb.settype(rs.getInt("type"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<BorrowRecordBean> listAllBorrowRecord() {
        Connection con = null;
        PreparedStatement pstmt = null;
        BorrowRecordBean cb = null;
        ArrayList<BorrowRecordBean> arrayList_cb = new ArrayList<BorrowRecordBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM BorrowRecordS ";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new BorrowRecordBean();
                cb.setId(rs.getInt("id"));
                cb.setStatus(rs.getInt("Status"));
                cb.setCheckout_date(rs.getString("CHECKOUT_DATE"));
                cb.setDue_date(rs.getString("Due_date"));
                cb.setReturn_date(rs.getString("Return_date"));
                cb.setIs_overdue(rs.getBoolean("Is_overdue"));
                cb.setApproved_by(rs.getInt("Approved_by"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<BorrowRecordBean> QueryBorrowRecordById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        BorrowRecordBean cb = null;
        ArrayList<BorrowRecordBean> arrayList_cb = new ArrayList<BorrowRecordBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM BorrowRecordS WHERE id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new BorrowRecordBean();
                cb.setId(rs.getInt("id"));
                cb.setStatus(rs.getInt("Status"));
                cb.setCheckout_date(rs.getString("CHECKOUT_DATE"));
                cb.setDue_date(rs.getString("Due_date"));
                cb.setReturn_date(rs.getString("Return_date"));
                cb.setIs_overdue(rs.getBoolean("Is_overdue"));
                cb.setApproved_by(rs.getInt("Approved_by"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<ReservationRequestBean> QueryReservationRequestById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ReservationRequestBean cb = null;
        ArrayList<ReservationRequestBean> arrayList_cb = new ArrayList<ReservationRequestBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM ReservationRequest WHERE id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new ReservationRequestBean();
                cb.setId(rs.getInt("id"));
                cb.setsubmitted_by(rs.getInt("submitted_by"));
                cb.setequipment_id(rs.getString("equipment_id"));
                cb.settype(rs.getInt("type"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<EquipmentBean> QueryEquipmentByid(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        EquipmentBean cb = null;
        ArrayList<EquipmentBean> arrayList_cb = new ArrayList<EquipmentBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM Equipment ";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new EquipmentBean();
                cb.setid(rs.getInt("id"));
                cb.setDescription(rs.getString("Description"));
                cb.setTag(rs.getString("Tag"));
                cb.setis_listed(rs.getBoolean("is_listed"));
                cb.setname(rs.getString("name"));
                cb.setstatus(rs.getInt("status"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public ArrayList<UserBean> QueryAllUserById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        UserBean cb = null;
        ArrayList<UserBean> arrayList_cb = new ArrayList<UserBean>();
        try {
            con = getConnection();
            String sql = "SELECT * FROM USERTABLE WHERE id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = null;
            pstmt.executeQuery();
            rs = pstmt.getResultSet();
            while (rs.next()) {
                cb = new UserBean();
                cb.setId(rs.getInt("id"));
                cb.setusername(rs.getString("username"));
                cb.setpassword(rs.getString("password"));
                cb.settype(rs.getInt("type"));
                arrayList_cb.add(cb);
            }
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayList_cb;
    }

    public void editUserRecord(UserBean cb) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            String SQL = "Update USERTABLE set USERNAME = ?, PASSWORD = ?, TYPE = ? where id =?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cb.getusername());
            pstmt.setString(2, cb.getpassword());
            pstmt.setInt(3, cb.gettype());
            pstmt.setInt(4, cb.getId());
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editEquipmentRecord(EquipmentBean cb) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            String SQL = "Update EQUIPMENT set NAME = ?, status = ?, is_listed = ?, Description = ?, Tag = ? where id =?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cb.getname());
            pstmt.setInt(2, cb.getstatus());
            pstmt.setBoolean(3, cb.getis_listed());
            pstmt.setString(4, cb.getDescription());
            pstmt.setString(5, cb.getTag());
            pstmt.setInt(6, cb.getid());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editReservationRequestRecord(ReservationRequestBean cb) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            String SQL = "Update ReservationRequest set equipment_id = ?, type = ?, submitted_by = ? where id =?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cb.getequipment_id());
            pstmt.setInt(2, cb.gettype());
            pstmt.setInt(3, cb.getsubmitted_by());
            pstmt.setInt(4, cb.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editBorrowRecord(BorrowRecordBean cb) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            String SQL = "Update BorrowRecordS set Checkout_date = ?, Approved_by = ?, Status = ?, Is_overdue = ?, Due_date = ?, Return_date = ? where id =?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cb.getCheckout_date());
            pstmt.setInt(2, cb.getApproved_by());
            pstmt.setInt(3, cb.getStatus());
            pstmt.setBoolean(4, cb.getIs_overdue());
            pstmt.setString(5, cb.getDue_date());
            pstmt.setString(6, cb.getReturn_date());
            pstmt.setInt(7, cb.getId());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
