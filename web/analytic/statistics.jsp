<!DOCTYPE html>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%
    /**
     * Code: 7.1
     *
     */
    String title = "Usage records";

    Date dNow = new Date();
    String date = request.getParameter("date");
    SimpleDateFormat year = new SimpleDateFormat("yyyy-MM");
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
                Below is the list of borrow records in the month for <%=date%>:

                <form>
                    <input type="date" name="date" value="2020-12-01" >
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                <br>
                <table class="table table-extra-condensed table-hover">
                    <tr>
                        <th>Equipment</th>
                        <th>Usage</th>
                    </tr>

                    <tr>
                        <td>HDMI Cable</td>
                        <td><%=request.getParameter("date") == null ? 4 : 2%></td>
                    </tr>

                    <tr>
                        <td>Bandage</td>
                        <td><%=request.getParameter("date") == null ? 1 : 3%></td>
                    </tr>

                    <% if (request.getParameter("date") != null) {%>
                    <tr>
                        <td>Toy car</td>
                        <td>1</td>
                    </tr>
                    <% }%>


                </table>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />          
