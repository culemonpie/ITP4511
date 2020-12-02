<!DOCTYPE html>

<%@page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean, java.util.ArrayList" %>

<%
    String title = "Cart";

    AssignmentDB db = new AssignmentDB();
    ArrayList<Integer> cart = (ArrayList) session.getAttribute("cart");

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

                <ul>
                    <% for (Integer c : cart) { %>
                    <li><%=c%></li>
                    <% } %>
                </ul>

                <hr>

                Dummy<br>

                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Item</th>
                        <th>Remove</th>
                    </tr>
                    <tr>
                        <td><a href='${pageContext.request.contextPath}/inventory/view?id=1'>LWL-00062</a></td>
                        <td>Ruler</td>
                        <td><input type="checkbox"></td>
                    </tr>
                    <tr>
                        <td>LWL-0024</td>
                        <td>Camera</td>
                        <td><input type="checkbox"></td>
                    </tr>
                    <tr>
                        <td>LWL-0027</td>
                        <td>Scrotch tape</td>
                        <td><input type="checkbox"></td>
                    </tr>

                    <%
                        //Iterate through the items

                    %>

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

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
