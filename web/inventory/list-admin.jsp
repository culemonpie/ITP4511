<!DOCTYPE html>

<%@ page import="ivpet.db.AssignmentDB,ivpet.bean.EquipmentBean, java.util.ArrayList" %>

<%
    AssignmentDB db = new AssignmentDB();

    ArrayList<EquipmentBean> equipments = db.listAllEquipment();

    String title = (String) request.getAttribute("title");
    if (title == null) {
        title = "List inventory (admin)";
    }
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2><%=title%></h2>
                
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/inventory/create.jsp">Create</a>
                <table class="table table-extra-condensed mt-1">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Availability</th>
                        <th>Action</th>
                    </tr>


                    <% for (EquipmentBean equipment : equipments) {%>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/inventory/view.jsp?id=<%=equipment.getid()%>"><%=equipment.getid()%></a></td>
                        <td><%=equipment.getname()%></td>
                        <td><%=equipment.getStatusVerbose()%></td>
                        <td><a href="${pageContext.request.contextPath}/inventory/update?id=<%=equipment.getid()%>" class="btn btn-primary btn-sm">Update</a></td>
                    </tr>
                    <% }%>

                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
