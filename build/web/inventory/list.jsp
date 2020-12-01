<!DOCTYPE html>
<%
    String title = (String)request.getAttribute("title");
    if (title == null){
	title = "List inventory";
    }
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">
		<h2><%=title%></h2>
		<table class="table table-extra-condensed">
		    <tr>
			<th>ID</th>
			<th>Name</th>
			<th>Availability</th>
		    </tr>
		    <%			String[] items = {"Surgical mask", "COVID-19 test bottle", "N95", "Syringe", "Pen", "HDMI Cable", "Chalk"};
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
