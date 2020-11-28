<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%
    String id = (String) request.getAttribute("id");
    String title = (String) request.getAttribute("title");
    String message = (String) request.getAttribute("message");
%>
<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
	<div class="row">
	    <div class="col-12">
		<ivpet:Alert message="<%=message%>" context="success" />
		
		<h4><%=title%></h4>
		<form method="POST">
		    <button type="submit" class="btn btn-primary">Save</button>
		    <a href="${pageContext.request.contextPath}/inventory/view?id=<%=id%>" class="btn btn-default ml-1">Return</a>


		    <div class="row">
			<div class="col-12 col-sm-6 col-md-4">
			    Name
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <input type="text" name="name" value="HDMI Cable" class="form-control">
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Status
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <select name="status" class="form-control">
				<option value="0">Available</option>
				<option value="1">Occupied</option>
				<option value="2">Under Repair</option>
				<option value="3">Removed</option>
			    </select>
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Description
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <textarea name="description" rows="4" cols="30" class="form-control">An HDMI cable connecting visual devices to processing devices.</textarea>
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Tags
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <textarea name="tags" rows="4" cols="30" class="form-control">
				
			    </textarea>
			    <small class="help-text">Each row represents a tag.</small>
			</div>
		    </div>

		    <div class="row mt-1">
			<div class="col-12 col-sm-6 col-md-4">
			    Is listed?
			</div>
			<div class="col-12 col-sm-6 col-md-8">
			    <input type="checkbox" name="is_listed">
			</div>
		    </div>

		</form>

	    </div>
	</div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  