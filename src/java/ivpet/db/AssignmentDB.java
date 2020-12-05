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
        Statement statement = null;
        try {
            Connection con = getConnection();
            statement = con.createStatement();
//            String sql = "CREATE TABLE USERTABLE (" + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
//                    + "username VARCHAR(255), password VARCHAR(255), type INTEGER)";
//            statement.execute(sql);
//            
//            String sql2 = "CREATE TABLE RESERVATIONREQUEST ("
//                    + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
//                    + "submitted_by INTEGER, type INTEGER,FOREIGN KEY (submitted_by) REFERENCES USERTABLE(id))";
//            statement.execute(sql2);
//            String sql3 = "CREATE TABLE EQUIPMENT (" + "id int GENERATED ALWAYS AS IDENTITY not null primary key,"
//                    + "NAME VARCHAR(255), Status INTEGER, is_listed Boolean,Description VARCHAR(255),Tag VARCHAR(255))";
//            statement.execute(sql3);
//
//            String sql4 = "CREATE TABLE BORROWRECORDS (" + "id int not null primary key,"
//                    + " Status INTEGER,checkout_date date,due_date date,return_date date,is_overdue Boolean,approved_by INTEGER,FOREIGN KEY (id) REFERENCES RESERVATIONREQUEST(id),FOREIGN KEY (approved_by) REFERENCES USERTABLE(id))";
//            statement.execute(sql4);

            String sql5 = "CREATE TABLE ReservationEquipment (\n"
                    + "	reservation_id INT NOT NULL,\n"
                    + "	equipment_id INT NOT NULL,\n"
                    + "FOREIGN KEY (reservation_id) REFERENCES RESERVATIONREQUEST(id),"
                    + "FOREIGN KEY (equipment_id) REFERENCES Equipment(id)"
                    + ")";
            statement.execute(sql5);

            statement.close();
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

    public void dropTable() {
        Statement statement = null;
        try {
            Connection con = getConnection();
            statement = con.createStatement();
            String sql = "DROP TABLE BORROWRECORDS";
            statement.execute(sql);

            sql = "DROP TABLE EQUIPMENT";
            statement.execute(sql);

            sql = "DROP TABLE RESERVATIONREQUEST";
            statement.execute(sql);

            sql = "DROP TABLE USERTABLE";
            statement.execute(sql);

            sql = "DROP TABLE RESERVATIONEQUIPMENT";
            statement.execute(sql);

            statement.close();
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

    public int addUser(String username, String password, int type) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            connection = getConnection();
            String SQL = "INSERT INTO USERTABLE(username,password,type) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, type);
            int rows = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                result = (int) rs.getLong(1);
                System.out.println(String.format("Username: %s, id: %s", username, result));
            } else {
                throw new SQLException("Failed");
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
        return result;
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
                userBean.setId(Integer.parseInt(rs.getString("id")));
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

    public int addEquipment(String name, int status, String description, String tag) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            connection = getConnection();
            String sql = "INSERT INTO EQUIPMENT(name,status,is_listed,description,tag) VALUES(?,?,'TRUE',?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, status);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, tag);
            int rowCount = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                result = (int) rs.getLong(1);
            } else {
                throw new SQLException("Failed");
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
        return result;
    }

    public int addReservationRequest(int submitted_by, int type) {
        Connection con = null;
        int result = 0;
        PreparedStatement preparedStatement = null;
        try {
            con = getConnection();
            String SQL = "INSERT INTO RESERVATIONREQUEST(submitted_by,type) VALUES(?,?)";
            preparedStatement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, equipment_id);
            preparedStatement.setInt(1, submitted_by);
            preparedStatement.setInt(2, type);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = (int) generatedKeys.getLong(1);
            } else {
                throw new SQLException("Failed");
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        }
        return result;
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
                cb.setUsername(rs.getString("username"));
                cb.setPassword(rs.getString("password"));
                cb.setType(rs.getInt("type"));
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
        String sql = "SELECT * FROM Equipment ";
        return listAllEquipment_inner(sql);
    }

    public ArrayList<EquipmentBean> listAllEquipment_inner(String sql) {
        Connection con = null;
        PreparedStatement pstmt = null;
        EquipmentBean cb = null;
        ArrayList<EquipmentBean> arrayList_cb = new ArrayList<EquipmentBean>();
        try {
            con = getConnection();
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

    public EquipmentBean getEquipment(int id) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        EquipmentBean equipment = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM Equipment WHERE id = ?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                equipment = new EquipmentBean();
                equipment.setid(rs.getInt("id"));
                equipment.setDescription(rs.getString("Description"));
                equipment.setTag(rs.getString("Tag"));
                equipment.setis_listed(rs.getBoolean("is_listed"));
                equipment.setname(rs.getString("name"));
                equipment.setstatus(rs.getInt("status"));
                break;
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return equipment;
    }

    public ArrayList<ReservationRequestBean> listAllReservationRequestByUser(int id) {
        //screw SQL injection
        String sql = "SELECT * FROM ReservationRequest where id = " + id;
        return listAllReservationRequest_inner(sql);
    }

    public ArrayList<ReservationRequestBean> listAllReservationRequest() {
        String sql = "SELECT * FROM ReservationRequest";
        return listAllReservationRequest_inner(sql);
    }

    public ArrayList<ReservationRequestBean> listAllReservationRequest_inner(String sql) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ReservationRequestBean cb = null;
        ArrayList<ReservationRequestBean> arrayList_cb = new ArrayList<ReservationRequestBean>();
        try {
            con = getConnection();
            preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                ReservationRequestBean reservation = getReservationRequest(rs.getInt("id"));
                System.out.println("Line 405:" + reservation);
//                cb = new ReservationRequestBean();
//                cb.setId(rs.getInt("id"));
//                cb.setsubmitted_by(rs.getInt("submitted_by"));
////                cb.setequipment_id(rs.getString("equipment_id")); mLn
//                //todo: Return a list of equipments
//                cb.settype(rs.getInt("type"));
                arrayList_cb.add(reservation);
            }
            preparedStatement.close();
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
//                cb.setequipment_id(rs.getString("equipment_id"));
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
                cb.setUsername(rs.getString("username"));
                cb.setPassword(rs.getString("password"));
                cb.setType(rs.getInt("type"));
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

    public UserBean getUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        UserBean cb = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM USERTABLE WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                cb = new UserBean();
                cb.setId(rs.getInt("id"));
                cb.setUsername(rs.getString("username"));
                cb.setPassword(rs.getString("password"));
                cb.setType(rs.getInt("type"));
                break;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return cb;
    }

    public ReservationRequestBean getReservationRequest(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ReservationRequestBean reservation = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM ReservationRequest WHERE id=?";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            ResultSet rs = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            System.out.println("Line 648");
            if (rs.next()) {
                System.out.println("Line 650");
                reservation = new ReservationRequestBean();
                System.out.println("Line 652" + reservation == null);
                reservation.setId(id);
                reservation.setsubmitted_by(rs.getInt("submitted_by"));
                //approved_by???
//                cb.setequipment_id(rs.getString("equipment_id")); not used
                reservation.settype(rs.getInt("type"));
//                reservation.setEqxuipments(equipments);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Line 670" + reservation == null);

        return reservation;
    }

    public ArrayList<EquipmentBean> getEquipmentsByReservation(int id) {
        ArrayList<EquipmentBean> equipments = new ArrayList();
        String sql = "SELECT * FROM ReservationEquipment where reservation_id = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = null;
            UserBean userBean = null;
            preparedStatement.executeQuery();
            rs = preparedStatement.getResultSet();
            while (rs.next()) {
                EquipmentBean equipment = getEquipment(rs.getInt("equipment_id"));
                equipments.add(equipment);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return equipments;
    }

    public void setEquipmentByReservation(int reservation_id, ArrayList<EquipmentBean> equipments) {
        /**
         * doesn't check for duplicate submission for equipment_id in equipments
         * insert into reservationequipment (reservation_id, equipment_id)
         *
         */

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();

            for (EquipmentBean equipment : equipments) {
                String sql = "insert into reservationequipment(reservation_id, equipment_id) values(?, ?)";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, reservation_id);
                preparedStatement.setInt(2, equipment.getid());
                int row = preparedStatement.executeUpdate();
                if (row == 0) {
                    System.out.println("Failed");
                }
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
        }
    }

    public void editUserRecord(UserBean cb) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            String SQL = "Update USERTABLE set USERNAME = ?, PASSWORD = ?, TYPE = ? where id =?";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cb.getUsername());
            pstmt.setString(2, cb.getPassword());
            pstmt.setInt(3, cb.getType());
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
//            String SQL = "Update ReservationRequest set equipment_id = ?, type = ?, submitted_by = ? where id =?";
            String SQL = "Update ReservationRequest set type = ?, submitted_by = ? where id =?";
            pstmt = con.prepareStatement(SQL);
//            pstmt.setString(1, cb.getequipment_id());
            pstmt.setInt(1, cb.gettype());
            pstmt.setInt(2, cb.getsubmitted_by());
            pstmt.setInt(3, cb.getId());
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

    public public void editBorrowRecord(BorrowRecordBean cb) {
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
