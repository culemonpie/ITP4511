<!DOCTYPE html>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%
    /**
     * Code: 7.1
     *
     */
    String title = "List overdue records";

    Date dNow = new Date();
    SimpleDateFormat year = new SimpleDateFormat("yyyy-MM-dd");
    String today = year.format(dNow);


%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">

		<h2><%=title%></h2>

		<br />
		Below is the list of borrow records:
		<br>
		<table class="table table-extra-condensed table-hover">
		    <tr>
			<th>Equipment</th>
			<th>User</th>
			<th>Due date</th>
		    </tr>

		    <% for (int i = 0; i < 10; i++){ %>
		    <tr>
			<td>HDMI Cable</td>
			<td>wilson.c</td>
			<td>2020-08-06</td>
		    </tr>
		    <% } %>


		</table>
	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
