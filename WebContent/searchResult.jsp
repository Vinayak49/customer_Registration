<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

if (session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}

%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="card text-white bg-secondary mb-6" style="max-width: 24rem;">
  <div class="card-header">First Name: <b><%=request.getAttribute("fname")%> Last name: <%=request.getAttribute("lname")%> </b> </div>
  <div class="card-body">
    <div class="card-text"> Party id: <%=request.getAttribute("partyId")%> </div>
     <div class="card-text"> Address: <%=request.getAttribute("address")%> </div> 
     <div class="card-text">City: <%=request.getAttribute("city")%> </div> 
     <div class="card-text">Zip: <%=request.getAttribute("zip")%> </div> 
     <div class="card-text">State <%=request.getAttribute("state")%> </div> 
     <div class="card-text">Country: <%=request.getAttribute("country")%> </div> 
     <div class="card-text">Phone: <%=request.getAttribute("phone")%> </div> 
     <div class="card-text">Password: <%=request.getAttribute("password")%> </div> 
  </div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>