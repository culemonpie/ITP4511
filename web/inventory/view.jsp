<!DOCTYPE html>

<%
    String id = (String) request.getAttribute("id");
    String title = "View reservation - #" + id;
%>
<jsp:include page="../include/header.jsp">
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">

		<h4><%=title%></h4>
		<a href="${pageContext.request.contextPath}/profile-reservation.jsp" class="btn btn-primary">Return</a>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Reservation ID
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			ID
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Items
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			Brick<br>
			Glass Bottle<br>
			White Powder<br>
			Water-fille barrier<br>
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			User
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			LunchGor
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Submitted Time
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			2020-08-25 10:06
		    </div>
		</div>
		
		<div class="row mt-2">
		    <div class="col-12">
		    <a href="#" class="btn btn-success">Approve</a>
		    <a href="#" class="btn btn-danger ml-1">Reject</a>
		    <a href="#" class="btn btn-info ml-1">Cancel</a>
		    </div>
		</div>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="../include/footer.jsp" />  
