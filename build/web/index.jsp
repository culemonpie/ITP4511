<!DOCTYPE html>

<jsp:include page="include/header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">
		<h2 class="">IVPET <small class="text-muted">Equipment Borrowing System</small></h2>
		<input type="text" class="form-control" placeholder='Enter search keyword...'>
		<hr>
		<table class="table">
		    <%

			String[] items = {"3M Protection gear", "Red Brick", "Molotov bomb", "Water barricade", "Tear gas"};
			for (String item : items) {
			    String msg = String.format("<tr><td>%s</td><td><a href='#' class='btn btn-success'>Add</a></td>", item);
			    out.println(msg);
			}

		    %>
		</table>
	    </div>
	</div>
    </div>
</div>
<jsp:include page="include/footer.jsp" />  
