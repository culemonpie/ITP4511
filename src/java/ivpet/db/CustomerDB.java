/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpet.db;

/**
 *
 * @author ngkac
 */
import ivpet.bean.CustomerBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class CustomerDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public CustomerDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }

    public void createCustTable() {
        Statement stmnt = null;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE USERTABLE ("
                    + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "usename VARCHAR(255), password VARCHAR(255), type INTEGER)";
            stmt.execute(sql);
            String sql2 ="CREATE TABLE RESERVATIONREQUEST ("
                    + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "EQUIPMENT_ID VARCHAR(255), submitted_by INTEGER, approved_by INTEGER,type INTEGER,FOREIGN KEY (submitted_by) REFERENCES USERTABLE(id),FOREIGN KEY (approved_by) REFERENCES USERTABLE(id))";
            stmt.execute(sql2);
            String sql3 ="CREATE TABLE EQUIPMENT ("
                    + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
                    + "NAME VARCHAR(255), Status INTEGER, is_listed Boolean,Description VARCHAR(255),Tag VARCHAR(255))";
            stmt.execute(sql3);
            String sql4 ="CREATE TABLE BORROWRECORDS ("
                    + "id int not null primary key,"
                    + " Status INTEGER,checkout_date date,due_date date,return_date date,is_overdue Boolean,FOREIGN KEY (id) REFERENCES RESERVATIONREQUEST(id))";
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
    public boolean addRecord(int id, String email_address, String password, int type) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO USERTABLE VALUES(?,?,?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.setString(2, email_address);
            pstmt.setString(3, password);
            pstmt.setInt(4, type);
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

//    public CustomerBean queryCustbyID(String id) {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        CustomerBean cb = null;
//
//        try {
//            con = getConnection();
//            String sql = "SELECT * FROM CUSTOMER WHERE CUSTID=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, id);
//            ResultSet rs = null;
//            pstmt.executeQuery();
//            rs = pstmt.getResultSet();
//            if (rs.next()) {
//                cb = new CustomerBean();
//                cb.setAge(rs.getInt("Age"));
//                cb.setCustId(rs.getString("CustId"));
//                cb.setName(rs.getString("name"));
//                cb.setTel(rs.getString("tel"));
//            }
//            pstmt.close();
//            con.close();
//        } catch (SQLException ex) {
//            while (ex != null) {
//                ex.printStackTrace();
//                ex = ex.getNextException();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return cb;
//    }

}
