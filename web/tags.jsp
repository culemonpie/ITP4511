<!DOCTYPE html>
<%@page import="ivpet.db.AssignmentDB, ivpet.bean.*" %>


<%
    String title = "Tags";

    AssignmentDB db = new AssignmentDB();

    String sql = "select * from equipment order by tag";

%>

<jsp:include page="/WEB-INF/header.jsp">
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <h2><%=title%></h2>
            <hr>
            Below are the trending items by tags:
            <table class="table table-extra-condensed table-hover">
                <tr>
                    <th>Equipment</th>
                    <th>Tag</th>
                </tr>
                <% for (EquipmentBean equipment : db.listAllEquipment_inner(sql)) {%>
                <tr>
                    <td><%=equipment.getname()%></td>
                    <td><%=equipment.getTag()%></td>
                </tr>
                <% }%>
            </table>
            <hr>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
