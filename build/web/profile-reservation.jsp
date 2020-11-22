<!DOCTYPE html>

<jsp:include page="include/header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-2">
    <div class="container">
	<div class="row">
	    <div class="col-md-3" id="profile_sidebar">
		<ul class="list-group">
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center active">
			<a href="profile-checkout.jsp">
			    Checked Out
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-reservation.jsp">
			    Reservations
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-history.jsp">
			    History
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="cart.jsp">
			    Cart
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-contact.jsp">
			    Contact
			</a>
		    </li>
		</ul>
	    </div>
	    <div class="col-md-9">

		<h4>View reservations</h4>
		
		<div class="card">
		    <div class="card-body">
			<h5>#R0002</h5>
			<a href="${pageContext.request.contextPath}/inventory/view?id=2">View</a> | <a href="#">Edit</a>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Username
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				demo
			    </div>
			</div>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Status
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				Pending
			    </div>
			</div>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Item
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				HDMI Cable<br>
				Projector<br>
				Amplifier<br>
			    </div>
			</div>
		    </div>
		</div>
		
		<div class="card mt-2">
		    <div class="card-body">
			<h5>#R0001</h5>
			<a href="${pageContext.request.contextPath}/inventory/view?id=1">View</a> | <a href="#">Edit</a>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Username
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				demo
			    </div>
			</div>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Full name
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				Demo User
			    </div>
			</div>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Role
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				Student
			    </div>
			</div>

			<div class="row">
			    <div class="col-12 col-sm-6 col-md-4">
				Student ID
			    </div>
			    <div class="col-12 col-sm-6 col-md-8">
				31415926
			    </div>
			</div>

		    </div>
		</div>

	    </div>
	</div>
    </div>

</div><jsp:include page="include/footer.jsp" />  
