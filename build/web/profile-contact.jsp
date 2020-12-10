<%@page import="ivpet.bean.UserBean"%>
<%@page import="ivpet.db.AssignmentDB"%>
<!DOCTYPE html>

<%
    String title = "Profile";
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-2">
    <div class="container">
        <div class="row">
            <div class="col-md-3" id="profile_sidebar">
                <ul class="list-group">
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
                <%     int i = Integer.parseInt(session.getAttribute("id").toString());
                    AssignmentDB db = new AssignmentDB();
                    UserBean U = new UserBean();
                    U = db.getUser(i);
                %>
                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Username
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <% out.print(U.getUsername()); %>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Role
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <% out.print(U.getRole()); %>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Student ID
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <% out.print(U.getId());%>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
