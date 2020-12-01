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
import ivpet.bean.UserBean;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import ivpet.*;

public class AssignmentDB {

    /**
     * 4511EA APP AWSDAWSD123
     */
    private String url = "";
    private String username = "";
    private String password = "";

    public AssignmentDB() {
        url = "jdbc:derby://localhost:1527/4511EA";
        username = "APP";
        password = "AWSDAWSD123";
    }

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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String SQL = "INSERT INTO USERTABLE(username,password,type) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email_address);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, type);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            preparedStatement.close();
            connection.close();
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

    public ArrayList<UserBean> listUsers() {
        ArrayList<UserBean> users = new ArrayList();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            //2. get the prepared statement
            String sql = "SELECT * FROM USERTABLE";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = null;
            UserBean userBean = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            //3. update the placeholder with id
//            preparedStatement.setString(1, tel);
            //4. execute the query and assign to the result;
            while (rs.next()) {
                // If the record exist set the record detail to the customer bean
                userBean = new UserBean();
                userBean.setUsername(rs.getString("Username"));
                userBean.setPassword(rs.getString("Password"));
                userBean.setType(Integer.parseInt(rs.getString("type")));
                users.add(userBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        }
        return users;
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

    public boolean addEquipment(String name, int status, String description, String tag) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;
        try {
            con = getConnection();
            String SQL = "INSERT INTO EQUIPMENT(name,status,is_listed,description,tag) VALUES(?,?,'TRUE',?,?)";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setInt(2, status);
            pstmt.setString(3, description);
            pstmt.setString(4, tag);
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

}
