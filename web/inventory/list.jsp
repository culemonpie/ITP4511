<!DOCTYPE html>

<jsp:include page="/WEB-INF/header.jsp">  
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
		    <tr>
			<th>ID</th>
			<th>Description</th>
		    </tr>
		    <%

			String[] items = {"3M Protection gear", "Red Brick", "Molotov bomb", "Water barricade", "Tear gas"};
			for (int i = 0; i < items.length; i++) {
			    String item = items[i];
			    String msg = String.format("<tr><td><a href='%s/inventory/view?id=%d'>%d</td><td>%s</td><td><a href='#' class='btn btn-success'>Add</a></td>", request.getContextPath(), i, i, item);
			    out.println(msg);
			}
		    %>
		</table>
	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
