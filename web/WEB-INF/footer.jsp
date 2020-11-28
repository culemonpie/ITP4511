<hr>
<div class="container mx-auto">
    <%@ page import="java.util.Date,java.text.SimpleDateFormat" %>

    <%
	Date dNow = new Date();
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	out.print(String.format("Copyright IVPET %s. All rights reserved.", year.format(dNow)));
    %>


</div>
</div>
</body>
</html>
