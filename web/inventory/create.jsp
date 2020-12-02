<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/tlds/ivpet_tags.tld" prefix="ivpet" %>

<%@ page import="ivpet.db.AssignmentDB, ivpet.bean.EquipmentBean" %>

<%  
    String id = (String) request.getAttribute("id");
    String title = "Create Equipment";
    String message = (String) request.getAttribute("message");
    
    AssignmentDB db = new AssignmentDB();
//    EquipmentBean equipment = db.getEquipment(Integer.parseInt(id));

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
                <form method="POST" action="${pageContext.request.contextPath}/inventory/createServlet">
                    <button type="submit" class="btn btn-primary">Create</button>
                    <a href="${pageContext.request.contextPath}/inventory/list.jsp" class="btn btn-default ml-1">Return</a>


                    <div class="row">
                        <div class="col-12 col-sm-6 col-md-4">
                            Name
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <input type="text" name="name" value="" class="form-control">
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Description
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <textarea name="description" rows="4" cols="30" class="form-control"></textarea>
                        </div>
                    </div>

                    <div class="row mt-1">
                        <div class="col-12 col-sm-6 col-md-4">
                            Tags
                        </div>
                        <div class="col-12 col-sm-6 col-md-8">
                            <textarea name="tags" rows="4" cols="30" class="form-control"></textarea>
                            <small class="help-text">Each row represents a tag.</small>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
