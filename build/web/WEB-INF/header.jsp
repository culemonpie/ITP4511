<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<html>

    <head></head>

    <body>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- PAGE settings -->
	<!-- <link rel="icon" href="https://templates.pingendo.com/assets/Pingendo_favicon.ico"> -->
	<title><%=request.getParameter("title") != null ? request.getParameter("title") + " - IVPET" : "IVPET"%></title>
	<meta name="description" content="Wireframe design of an album page by Pingendo">
	<meta name="keywords" content="Pingendo bootstrap example template wireframe album ">
	<meta name="author" content="Pingendo">
	<!-- CSS dependencies -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/wireframe.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">
	<!--JS dependencies-->
	<script src="https://use.fontawesome.com/a25b2f6ef3.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Barlow" rel="stylesheet">
	<div class="wrapper">
	    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container"> <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
			<b> IVPET</b>
		    </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar10">
			<span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbar10">
			<ul class="navbar-nav ml-auto">
			    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/trend.jsp">Trend</a> </li>
			    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/inventory/list.jsp">Inventory</a> </li>

			    <%
				/*
				Links for login user.
				If user is not login, show "login" button only.
				 */
				if (session.getAttribute("username") != null) {
			    %>


			    <!--Links for Technician-->
			    <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <i class="fas fa-tools"></i>
				    Manage
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/inventory/list-admin.jsp">Inventory</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/list">Accounts</a>
				    <a class="dropdown-item" href="#">Lease</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/reservation/list.jsp">Reservations</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/analytic/overdue.jsp">Overdue records</a>
				    <a class="dropdown-item" href="#">Tags</a>
				</div>
			    </li>


			    <!--Links for Student-->
			    <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <i class="fa fa-user"></i>
				    <%=session.getAttribute("username")%>
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/profile-checkout.jsp">Checked out</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/profile-reservation.jsp">Reservations</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/profile-history.jsp">History</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/cart.jsp">Cart</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/profile-contact.jsp">Contact</a>
				    <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
				</div>
			    </li>

			    <%
				} else {

				    out.println("<li class='nav-item'> <a class='nav-link' href='login.jsp'>Login</a> </li>");
				}
			    %>

			</ul>
		    </div>
		</div>
	    </nav>