<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>
<%@ page import="ivpet.db.AssignmentDB, ivpet.bean.UserBean" %>

<%
    
String id = request.getParameter("id");
AssignmentDB db = new AssignmentDB();
UserBean user = db.getUser(Integer.parseInt(id));    
String title = "Update user - " + user.getUsername() ;
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
                <form method="POST" action="${pageContext.request.contextPath}/user/updateServlet">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="${pageContext.request.contextPath}/user/list.jsp" class="btn btn-default ml-1">Return</a>
                    <input type="hidden" name="id" value="<%=id%>" >


                    <div class="row">
                        <div class="col-12 col-sm-6 col-md-4">
                            Username
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <input type="textbox" name="username" value="<%=user.getUsername()%>" class="form-control" required>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Role
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <select id="type" name="type" class="form-control" required>
                                <option value="1">Student</option>
                                <option value="2">Technician</option>
                                <option value="3">Senior Technician</option>
                            </select>

                            <script>
                                document.getElementById('type').value = <%=user.getType()%>;
                            </script>

                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Is listed?
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <input type="checkbox" name="is_listed" <%=true?"checked":""%> >
                        </div>
                    </div>


                </form>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
