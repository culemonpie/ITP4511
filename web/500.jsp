<!DOCTYPE html>

<%@ page isErrorPage="true" %>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="Internal Server Error" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class='card col-12 mx-auto '>
		<div class='card-body'>
		    <div class="text-center">
			<h3>500</h3>
			Internal Server Error
		    </div>
		    <hr>
		    <pre>
			<jsp:scriptlet>
			exception.printStackTrace(new java.io.PrintWriter(out));
			</jsp:scriptlet>
		    </pre>
		</div>
	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
