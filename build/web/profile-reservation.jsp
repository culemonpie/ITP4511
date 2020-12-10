<%@page import="ivpet.bean.EquipmentBean"%>
<%@page import="ivpet.bean.ReservationEquipmentBean"%>
<%@page import="ivpet.bean.BorrowRecordBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ivpet.bean.ReservationRequestBean"%>
<%@page import="ivpet.bean.UserBean"%>
<%@page import="ivpet.db.AssignmentDB"%>
<!DOCTYPE html>

<%
    String title = "View reservations";
%>

<jsp:include page="/WEB-INF/header.jsp">  
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-2">
    <div class="container">
	<div class="row">
	    <div class="col-md-3" id="profile_sidebar">
		<ul class="list-group">
		    <li class=" border-0 list-group-item d-flex justify-content-between align-items-center active">
			<a href="profile-checkout.jsp">
			    Checked Out
			</a>
		    </li>
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

		<h4><%=title%></h4>
<%     int i=  Integer.parseInt(session.getAttribute("id").toString());
    AssignmentDB db = new AssignmentDB();
    ArrayList<ReservationRequestBean> R=new ArrayList<ReservationRequestBean>();
R=db.listAllReservationRequestBySub(i);
//    ArrayList<BorrowRecordBean> BorrowRecordBean = db.QueryBorrowRecordById(i);
    String item="";

for(int j=0;j<R.size();j++){
    ArrayList<ReservationEquipmentBean> ReservationEquipment = db.listReservationEquipmentByid(R.get(j).getId());
    for(int k=0;k<ReservationEquipment.size();k++){
        EquipmentBean Equipment = db.getEquipment(ReservationEquipment.get(k).geEid());
    item+=Equipment.getname()+"<br>";
    }
    out.print( "<div class=\"card\">"+
"		    <div class=\"card-body\">"+
"			<h5>#"+R.get(j).getId()+"</h5>"+
"			<a href=\""+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/ITP4511/reservation/view?id="+R.get(j).getId()+"\">View</a> | <a href=\"#\">Edit</a>"+
""+
"			<div class=\"row\">"+
"			    <div class=\"col-12 col-sm-6 col-md-4\">"+
"				"+R.get(j).getsubmitted_by()+
"			    </div>"+
"			    <div class=\"col-12 col-sm-6 col-md-8\">"+
"			    </div>"+
"			</div>"+
""+
"			<div class=\"row\">"+
"			    <div class=\"col-12 col-sm-6 col-md-4\">"+
"				Status"+
"			    </div>"+
"			    <div class=\"col-12 col-sm-6 col-md-8\">"+
"				"+R.get(j).gettype()+
"			    </div>"+
"			</div>"+
""+
"			<div class=\"row\">"+
"			    <div class=\"col-12 col-sm-6 col-md-4\">"+
"				Item"+
"			    </div>"+
"			    <div class=\"col-12 col-sm-6 col-md-8\">"+
item+

"			    </div>"+
"			</div>"+
"		    </div>"+
"		</div>");
}
%>

	    </div>
	</div>
    </div>

</div><jsp:include page="/WEB-INF/footer.jsp" />          
