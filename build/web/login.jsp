<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%
    String message = (String) request.getAttribute("message");
    String title = "Login";
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12 col-md-6 mx-auto">

		<ivpet:Alert message="<%=message%>" context="danger" />


		<h5><%=title%></h5>
		<form class="form-signin" action="loginServlet" method="post">
		    <div class="form-label-group">
			<label for="inputEmail">Username</label>
			<input type="text" name="username" id="username" class="form-control" placeholder="Email address" required autofocus>
		    </div>

		    <div class="form-label-group">
			<label for="inputPassword">Password</label>
			<input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
		    </div>

		    <button class="btn btn-lg btn-primary btn-block mt-1" type="submit">Log in</button>
		</form>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
