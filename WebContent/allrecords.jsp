<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

if (session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}
%>

<%@page import="com.hotwax.model.UserObjects"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operations</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
UserObjects userObject = new UserObjects();
ResultSet rs = userObject.selectAll();
while(rs.next()){
	%>
	<div class="card text-center mt-2 mb-4">
  <div class="card-header bg-secondary">
    <%=rs.getString(2)%> <%=rs.getString(3)%>
  </div>
  <div class="card-body bg-secondary">
    <h4><p class="card-text"> Address: <%=rs.getString(4)%> City: <%=rs.getString(5)%> Zip: <%=rs.getString(6)%> State: <%=rs.getString(7)%> Country: <%=rs.getString(8)%> Phone: <%=rs.getString(9)%> Password: <%=rs.getString(10)%></p></h4>
    <a href="allrecords.jsp?PartyId=<%=rs.getString(1)%>" class="btn btn-success">Update</a>
        <a href="delete?PartyId=<%=rs.getString(1)%>"onclick="return check()"  class="btn btn-danger">Delete</a>
  </div>

</div>


<%
}
%>
<%
	String pid = request.getParameter("PartyId");

	if(pid!=null){
		int partyId = Integer.parseInt(pid);
		ResultSet rs1 = userObject.updateRecordRetreive(partyId);
		rs1.next();
%>

<form action="update" method="post">
<div>
Party id: <input type= "number" name="partyid" value="<%=rs1.getString(1)%>" readonly>
First name: <input type= "text" name="fname" value="<%=rs1.getString(2)%>">
Last name: <input type= "text" name="lname" value="<%=rs1.getString(3)%>">
Address: <input type= "text" name="address" value="<%=rs1.getString(4)%>">
City: <input type= "text" name="city" value="<%=rs1.getString(5)%>">
State: <input type= "text" name="state" value="<%=rs1.getString(7)%>">
Country: <input type= "text" name="country" value="<%=rs1.getString(8)%>">
Zip: <input type= "number" name="zip" value="<%=rs1.getString(6)%>">
Phone: <input type= "number" name="phone" value="<%=rs1.getInt(9)%>">
Password: <input type= "password" name="password" value="<%=rs1.getString(10)%>">
</div>
  <button type="submit" class="btn btn-success">Update</button>
</form>	

    <%
    }
	
    %>
<script type="text/javascript">
	function check(){
		
	var a = confirm("Do you really want to Delete this record ");
	return a;
	}


</script>
    
</body>
</html>