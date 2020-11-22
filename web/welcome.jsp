<!DOCTYPE html>

<jsp:include page="include/header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12 col-md-6 mx-auto text-center py-5">

		<h3>Welcome, <%= session.getAttribute("username") %>!</h4>
		    <br>
		    <a href="profile-contact.jsp" class="btn btn-outline-primary">Go to profile</a>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="include/footer.jsp" />  
