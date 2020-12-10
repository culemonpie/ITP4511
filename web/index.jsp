<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%@ page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean, java.util.ArrayList" %>

<%
    String message = (String) request.getAttribute("message");
    
    AssignmentDB db = new AssignmentDB();
    ArrayList<EquipmentBean> equipments = db.listAllEquipment();
    
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <ivpet:Alert message="<%=message%>" context="success" />
                <h2 class="">IVPET <small class="text-muted">Equipment Borrowing System</small></h2>
                <form action="${pageContext.request.contextPath}/inventory/list.jsp">
                    <input type="text" name="search" class="form-control" placeholder='Enter search keyword...'>
                </form>
                <hr>
                <table class="table table-extra-condensed">

                    <% for (EquipmentBean equipment : equipments) {%>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/inventory/view.jsp?id=<%=equipment.getid()%>"><%=equipment.getid()%></a></td>
                        <td><%=equipment.getname()%></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/addToCart?id=<%=equipment.getid()%>" class="btn btn-primary btn-sm">Add</a>
                        </td>
                    </tr>
                    <% }%>

                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
