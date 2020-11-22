<!DOCTYPE html>

<jsp:include page="include/header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12 col-md-6 mx-auto">

		<%
		    String error_message = (String) request.getAttribute("error_message");
		    if (error_message != null) {
			String error_message_html = String.format("<div class='alert alert-danger'>%s</div>", error_message);
			out.println(error_message_html);
		    }

		%>


		<h5>Login</h5>
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
<jsp:include page="include/footer.jsp" />  
