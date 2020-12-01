<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>


<%
    String id = (String) request.getAttribute("id");
    String title = "Create user";
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
		    <button type="submit" class="btn btn-primary">Create</button>
		    <a href="${pageContext.request.contextPath}/user/list.jsp" class="btn btn-default ml-1">Return</a>


		    <div class="row">
			<div class="col-12 col-sm-6 col-md-4">
			    Username
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <input type="text" name="username" value="" class="form-control" required>
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Password
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <input type="password" name="password" value="" class="form-control" required>
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Type
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <select name="type" class="form-control" required>
				<option value="1" selected>Student</option>
				<option value="2" selected>Technician</option>
				<option value="3" selected>Senior Technician</option>
			    </select>
			</div>
		    </div>


		</form>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
