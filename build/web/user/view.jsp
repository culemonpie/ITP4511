<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%@ page import="ivpet.db.AssignmentDB, ivpet.bean.UserBean" %>

<%
    String id = (String) request.getAttribute("id");
    AssignmentDB db = new AssignmentDB();
    UserBean user = db.getUser(Integer.parseInt(id));
    
    String title = "View user - " + user.getUsername() ;
    String message = (String) request.getAttribute("message");
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <ivpet:Alert message="<%=message%>" context="success" />

                <h4><%=title%></h4>
                <form method="POST" action="${pageContext.request.contextPath}/user/createServlet">
                    <a href="${pageContext.request.contextPath}/user/update.jsp?id=<%=id%>" class="btn btn-primary">Update</a>
                    <a href="${pageContext.request.contextPath}/user/list.jsp" class="btn btn-default ml-1">Return</a>


                    <div class="row">
                        <div class="col-12 col-sm-6 col-md-4">
                            Username
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <%=user.getUsername()%>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Role
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <%=user.getRole()%>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Is listed
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            Yes
                        </div>
                    </div>


                </form>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
