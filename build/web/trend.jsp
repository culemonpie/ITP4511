<!DOCTYPE html>

<%
    String title = "Trending items";

%>

<jsp:include page="/WEB-INF/header.jsp">
    <jsp:param name="title" value="<%=title%>" />
</jsp:include>
<div class="py-3">
    <div class="container">
        <div class="row">
            <div>
                <h2><%=title%></h2>
            </div>
            <br>
            <div>
                Below are the trending items:
            </div>
            <table class="table table-extra-condensed table-hover">
                <tr>
                    <th>Name</th>
                    <th># of borrows in past 6 months</th>
                </tr>
                <% for (int i = 5; i > 0; i--) {%>
                <tr>
                    <td>HDMI Cable</td>
                    <td><%=i*10%></td>
                </tr>
                <% }%>
            </table>
            <hr>
            Remarks: select name, count(*) from borrowrecords inner join equipment on borrowrecords.equipment_id = equipment.id group by borrowrecords.equipment_id

        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />  
