<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%@page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean, java.util.ArrayList" %>


<%
    String title = "Cart";

    AssignmentDB db = new AssignmentDB();
    ArrayList<Integer> cart = (ArrayList) session.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList();
    }
    String message = (String) request.getAttribute("message");
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-2">
    <div class="container">
        <div class="row">
            <div class="col-md-3" id="profile_sidebar">
                <ul class="list-group">
                    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center active">
                        <a href="profile-checkout.jsp">
                            Checked Out
                        </a>
                    </li>
                    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
                        <a href="profile-reservation.jsp">
                            Reservations
                        </a>
                    </li>
                    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
                        <a href="profile-history.jsp">
                            History
                        </a>
                    </li>
                    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
                        <a href="cart.jsp">
                            Cart
                        </a>
                    </li>
                    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
                        <a href="profile-contact.jsp">
                            Contact
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-md-9">
                <h1> <%=title%> </h1>

                <ivpet:Alert message="<%=message%>" context="success" />

                <form action="POST">
                    <table class="table mt-2">
                        <tr>
                            <th>ID</th>
                            <th>Item</th>
                            <th>Status</th>
                        </tr>
                        <% for (Integer id : cart) {
                                EquipmentBean equipment = db.getEquipment(id);
                        %>
                        <tr>
                            <td><%=equipment.getid()%></td>
                            <td><%=equipment.getname()%></td>
                            <td><%=equipment.getStatusVerbose()%></td>
                        </tr>
                        <% }%>

                    </table>

                    <br>

                    <a href="${pageContext.request.contextPath}/addToCart?action=clear" class="btn btn-default" onclick="confirm('Are you sure?')">
                        Clear cart
                    </a>

                        <% if (cart != null && cart.size() > 0){ %>
                    <a href="${pageContext.request.contextPath}/addToCart?action=submit" class="btn btn-success ml-2">
                        Submit
                    </a>
                        <% } else { %>
                        <button class="btn btn-primary" disabled>Submit</button>
                        <% }  %>

                    <br>

                    By clicking submit, you will submit all available items in cart to your request.<br>
                    Availability of the items may change depending on the actual situation.<br>
                    Reservation will be considered on an overall basis. We will only notify you if all items are ready.

                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
