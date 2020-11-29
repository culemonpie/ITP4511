<!DOCTYPE html>
<%
    String title = (String) request.getAttribute("title");
    if (title == null) {
	title = "List inventory";
    }
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <form action="${pageContext.request.contextPath}/analytic/borrowrecords" target="_blank">
		<div class="col-12">
		    <h2><%=title%></h2>
		    <a href="${pageContext.request.contextPath}/user/create.jsp" class="btn btn-primary">Create</a>
		    <button type="submit" class="btn btn-default">
			<i class="fa fa-print"> </i>
			Print outstanding records
		    </button>
		    <hr>
		    <div class="mt-1">

			<table class="table table-extra-condensed table-hover">
			    <tr>
				<th>ID</th>
				<th>Username</th>
				<th>Is active?</th>
				<th>Has overdue records?</th>
				<th>Select</th>
			    </tr>

			    <% for (int i = 0; i < 10; i++) {%>
			    <tr>
				<td><a href="${pageContext.request.contextPath}/user/view?id=<%=i%>"><%=i%></a></td>
				<td>andywong@gmail.com</td>
				<td>Yes</td>			
				<td>No</td>			
				<td><input type="checkbox" name="user" value="<%=i%>"></td>			
			    </tr>
			    <% }%>
			</table>
		    </div>
	    </form>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
