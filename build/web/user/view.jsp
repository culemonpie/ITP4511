<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>


<%
    String id = (String) request.getAttribute("id");
    String title = "View user - andywong@gmail.com";
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
		    <a href="${pageContext.request.contextPath}/user/update.jsp" class="btn btn-primary">UPDATE (TODO)</a>
		    <a href="${pageContext.request.contextPath}/user/list.jsp" class="btn btn-default ml-1">Return</a>


		    <div class="row">
			<div class="col-12 col-sm-6 col-md-4">
			    Email
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    andywong@gmail.com
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Role
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    Student
			</div>
		    </div>


		</form>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
