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
		<h1> Checked out </h1>

		<table class="table">
		    <tr>
			<th>ID</th>
			<th>Item</th>
			<th>Checked out</th>
			<th>Due Date</th>
			<th>Returned Date</th>
			<th>Status</th>
		    </tr>
		    <tr>
			<td><a href="#">B0004</a></td>
			<td>Ruler</td>
			<td>2020-05-21 08:42:33</td>
			<td>2020-06-08</td>
			<td>2020-06-01 13:26:10</td>
			<td>Returned</td>
		    </tr>
		    <tr>
			<td><a href="#">B0003</a></td>
			<td>Ruler</td>
			<td>2020-05-21 08:42:33</td>
			<td>2020-06-08</td>
			<td>2020-06-01 13:26:10</td>
			<td>Returned</td>
		    </tr>
		    <tr class="table-danger">
			<td><a href="#">B0002</a></td>
			<td>Ruler</td>
			<td>2020-05-21 08:42:33</td>
			<td>2020-06-08</td>
			<td>2020-06-01 13:26:10</td>
			<td>Returned (Overdue)</td>
		    </tr>
		    <tr class="table-danger">
			<td><a href="#">B0001</a></td>
			<td>Ruler</td>
			<td>2020-05-21 08:42:33</td>
			<td>2020-06-08</td>
			<td>2020-06-01 13:26:10</td>
			<td>Returned (Overdue)</td>
		    </tr>
		</table>

		Completed items will be listed in the history section.

	    </div>
	</div>
    </div>

</div><jsp:include page="include/footer.jsp" />  
