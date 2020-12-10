<%@page import="ivpet.bean.ReservationRequestBean"%>
<%@page import="ivpet.bean.ReservationEquipmentBean"%>
<%@page import="ivpet.bean.EquipmentBean"%>
<%@page import="ivpet.bean.BorrowRecordBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ivpet.db.AssignmentDB"%>
<%@page import="ivpet.db.AssignmentDB"%>
<!DOCTYPE html>

<%
    String title = "Checkout history";
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-2">
    <div class="container">
	<div class="row">
	    <div class="col-md-3" id="profile_sidebar">
		<ul class="list-group">
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-reservation.jsp">
			    Reservations
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-history.jsp">
			    History
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="cart.jsp">
			    Cart
			</a>
		    </li>
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center">
			<a href="profile-contact.jsp">
			    Contact
			</a>
		    </li>
		</ul>
	    </div>
	    <div class="col-md-9">
		<h1> <%=title%> </h1>

		<table class="table">
		    <tr>
			<th>ID</th>
			<th>Item</th>
			<th>Checked out</th>
			<th>Due Date</th>
			<th>Returned Date</th>
			<th>Status</th>
		    </tr>
                    
                    <%
    String message = (String) request.getAttribute("message");
    int i=  Integer.parseInt(session.getAttribute("id").toString());
    AssignmentDB db = new AssignmentDB();
    ArrayList<BorrowRecordBean> LB=db.listAllBorrowRecord();
    ArrayList<ReservationRequestBean> R=db.listAllReservationRequestBySub(i);

//    ArrayList<BorrowRecordBean> BorrowRecordBean = db.QueryBorrowRecordById(i);
    String item="";
    for(int j=0;j<LB.size();j++){
        int s=LB.get(j).getId();
        ArrayList<ReservationEquipmentBean> ReservationEquipment = db.listReservationEquipmentByid(s);
        for(int a=0;a<ReservationEquipment.size();a++){
         EquipmentBean Equipment = db.getEquipment(ReservationEquipment.get(a).geEid());
    item+=Equipment.getname()+" ";
        }
    }
        for(int j=0;j<LB.size();j++){
    for(int k=0;k<R.size();k++){
    if(LB.get(j).getId()==R.get(k).getId()){
        out.println("<tr><td>"+LB.get(j).getId()+"</td><td>"+item+"</td><td>"+LB.get(j).getCheckout_date()+"</td><td>"+LB.get(j).getDue_date()+"</td><td>"+LB.get(j).getReturn_date()+"</td><td>"+LB.get(j).getStatusType()+"</td></tr>");

    }
    }
    }
       %>
                    
		 
		</table>

	    </div>
	</div>
    </div>

</div><jsp:include page="/WEB-INF/footer.jsp" />          
