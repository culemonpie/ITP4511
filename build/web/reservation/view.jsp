<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>
<!DOCTYPE html>


<%
    String id = (String) request.getAttribute("id");
    String title = (String) request.getAttribute("title");
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
			Status
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			Pendings
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
		    <form method="POST">

			<button action="submit" name="action" value="approve" class="btn btn-success">Approve</Button>
			<button action="submit" name="action" value="reject" class="btn btn-danger ml-1">Reject</Button>
			<button action="submit" name="action" value="cancel" class="btn btn-info ml-1">Cancel</Button>
		    </form>
		    <div class="col-12">
		    </div>
		</div>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
