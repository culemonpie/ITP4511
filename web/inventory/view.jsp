<!DOCTYPE html>

<%@ page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean" %>

<%
    String id = (String) request.getParameter("id");

    AssignmentDB db = new AssignmentDB();
    EquipmentBean equipment = db.getEquipment(Integer.parseInt(id));

    String title = equipment.getname() + " - View inventory";


%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-12">

                <h4><%=title%></h4>

                <!-- todo: Technician only -->
                <a href="${pageContext.request.contextPath}/inventory/update?id=<%=id%>" class="btn btn-primary">Update</a>
                <a href="${pageContext.request.contextPath}/inventory/update?id=<%=id%>" class="btn btn-primary">Add to cart</a>
                <a href="${pageContext.request.contextPath}/inventory/list.jsp" class="btn btn-default">Return</a>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        id
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <%=equipment.getid()%>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Name
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <%=equipment.getname()%>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Status
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <%=equipment.getStatusVerbose()%>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Description
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <%=equipment.getDescription()%>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12 col-sm-6 col-md-4">
                        Tags
                    </div>
                    <div class="col-12 col-sm-6 col-md-8">
                        <a href="#" class="badge badge-primary"><%=equipment.getTag()%></a> 
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
