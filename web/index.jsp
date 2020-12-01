<!DOCTYPE html>

<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>


<%
    String message = (String) request.getAttribute("message");
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="Home" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">
		<ivpet:Alert message="<%=message%>" context="success" />
		<h2 class="">IVPET <small class="text-muted">Equipment Borrowing System</small></h2>
		<input type="text" class="form-control" placeholder='Enter search keyword...'>
		<hr>
		<table class="table table-extra-condensed">
		    <%

			String[] items = {"Surgical mask", "COVID-19 test bottle", "N95", "Syringe", "Pen", "HDMI Cable", "Chalk"};
			for (String item : items) {
			    String msg = String.format("<tr><td>%s</td><td>Medical supplies</td><td><a href='%s/addToCart?id=%s' class='btn btn-success'>Add</a></td>", item, request.getContextPath(), item);
			    out.println(msg);
			}

		    %>
		</table>
	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
