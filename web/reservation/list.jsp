<!DOCTYPE html>
<%@page import="ivpet.db.AssignmentDB, ivpet.bean.*" %>
<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%
    String title = "List reservations";
    String message = (String) request.getAttribute("message");

    AssignmentDB db = new AssignmentDB();


%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-2">
    <div class="container">
        <div class="row">
            <div class="col-md-12">

                <h4><%=title%></h4>

                <% for (ReservationRequestBean reservation : db.listAllReservationRequest()) {%>


                <div class="card">
                    <div class="card-body">
                        <h5>#R<%=reservation.getId()%></h5>
                        <a href="${pageContext.request.contextPath}/reservation/view?id=<%=reservation.getId()%>">View</a> | <a href="#">Edit</a>

                        <div class="row">
                            <div class="col-12 col-sm-6 col-md-4">
                                Username
                            </div>
                            <div class="col-12 col-sm-6 col-md-8">
                                <%=db.getUser(reservation.getId()).getUsername()%>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 col-sm-6 col-md-4">
                                Status
                            </div>
                            <div class="col-12 col-sm-6 col-md-8">
                                <%=reservation.getTypeVerbose()%>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12 col-sm-6 col-md-4">
                                Item
                            </div>
                            <div class="col-12 col-sm-6 col-md-8">
                                <%
                                    String msg = "";
                                    for (EquipmentBean e : db.getEquipmentsByReservation(reservation.getId())) {
                                        msg += String.format("\n\t%s: (Status: %s)", e.getname(), e.getStatusVerbose());
                                    }
                                    out.println(msg);
                                %>
                            </div>
                        </div>
                    </div>
                </div>

                <% }%>

            </div>
        </div>
    </div>

</div><jsp:include page="/WEB-INF/footer.jsp" />          
