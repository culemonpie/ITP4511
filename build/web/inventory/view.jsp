<!DOCTYPE html>

<%
    String id = (String) request.getAttribute("id");
    String title = (String) request.getAttribute("title");
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">

		<h4><%=title%></h4>

		<a href="${pageContext.request.contextPath}/inventory/list.jsp" class="btn btn-default">Return</a>
		<!-- todo: Technician only -->
		<a href="${pageContext.request.contextPath}/inventory/update?id=<%=id%>" class="btn btn-primary">Edit</a>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Name
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			HDMI Cable
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Status
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			Available
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Description
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			An HDMI cable connecting visual devices to processing devices.
		    </div>
		</div>

		<div class="row">
		    <div class="col-12 col-sm-6 col-md-4">
			Tags
		    </div>
		    <div class="col-12 col-sm-6 col-md-8">
			<a href="#" class="badge badge-primary">Video</a> 
			<a href="#" class="badge badge-primary">Accessories</a>
		    </div>
		</div>


	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
