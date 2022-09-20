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
<title>Home</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="mt-4">
<div class="d-flex justify-content-center">

<a href="searchRecord.jsp"> <button class="btn btn-success btn-lg mr-4">Search</button> </a> 
<a href="allrecords.jsp"> <button class="btn btn-success btn-lg">All Records</button> </a>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>