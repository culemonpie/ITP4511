<!DOCTYPE html>

<%@ page import="java.util.Date,java.text.SimpleDateFormat,ivpet.db.AssignmentDB, ivpet.bean.*, java.util.ArrayList" %>
<%
    /**
     * Code: 7.1
     *
     */
    String title = "List overdue records";

    Date dNow = new Date();
    SimpleDateFormat year = new SimpleDateFormat("yyyy-MM-dd");
    String today = year.format(dNow);

    AssignmentDB db = new AssignmentDB();


%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-12">

                <h2><%=title%></h2>

                <br />
                Below is the list of borrow records:
                <br>
                <table class="table table-extra-condensed table-hover">
                    <tr>
                        <th>Equipment</th>
                        <th>User</th>
                        <th>Due date</th>
                    </tr>

                    <% for (BorrowRecordBean b: db.listAllBorrowRecord()) { 
                    ReservationRequestBean r = db.getReservationRequest(b.getId());
                    ArrayList<EquipmentBean> equipments = db.getEquipmentsByReservation(b.getId());
                    if (b.getStatusType().equals("is overdue")){
                    %>
                    <tr>
                        <td><%
                            for (EquipmentBean equipment : equipments){
                                out.println(equipment.getname() + "<br>");
                            }
                            %></td>
                        <td><%=db.getUser(r.getsubmitted_by()).getUsername()%></td>
                        <td><%=b.getDue_date()%></td>
                    </tr>
                    <% }} %>


                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
