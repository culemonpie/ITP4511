<!DOCTYPE html>

<%@page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean, java.util.ArrayList" %>

<%
    String title = "Cart";

    AssignmentDB db = new AssignmentDB();
    ArrayList<Integer> cart = (ArrayList) session.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList();
    }
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

                <hr>

                <form action="POST">
                    <table class="table">
                        <tr>
                            <th>ID</th>
                            <th>Item</th>
                            <th>Remove</th>
                        </tr>
                        <% for (Integer id : cart) {
                                EquipmentBean equipment = db.getEquipment(id);
                        %>
                        <tr>
                            <td><%=equipment.getid()%></td>
                            <td><%=equipment.getname()%></td>
                            <td><input type="checkbox" name="id" value="<%=equipment.getid()%>"></td>
                        </tr>
                        <% }%>

                    </table>

                    <br>

                    <button class="btn" onclick="confirm('Are you sure?')">
                        Remove selected items
                    </button>

                    <a href="cart-confirm.html" class="btn btn-success ml-2">
                        Submit
                    </a>

                    <br>

                    By clicking submit, you will submit all available items in cart to your request.
                    Availablility of the items may change depending on the actual situation.

                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
