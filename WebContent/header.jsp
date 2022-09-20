<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:include page="bootstrap-include.jsp"></jsp:include>


  <%
if (session.getAttribute("name")==null){

  %>
  	   <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
  <a class="navbar-brand text-light" href="/customerRegistration">Customer Registration</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      
      <li class="nav-item dropdown">
  
  
      </li>
    </ul>
    
  </div>

    <a class="nav-link text-success" href="SignUp.jsp">Signup /</a>
    <a class="nav-link text-success" href="login.jsp">Login </a>
    </nav>
    <%
}
else{
	%>
	   <nav class="navbar navbar-expand-lg navbar-light bg-secondary">
  <a class="navbar-brand text-light" href="/customerRegistration">Customer Registration</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link text-light" href="/customerRegistration/searchRecord.jsp">Search</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-light" href="/customerRegistration/allrecords.jsp">All Records</a>
      </li>
      <li class="nav-item dropdown">
  
  
      </li>
    </ul>
    
  </div>
	Hello, <%=session.getAttribute("name") %>
    <a class="nav-link text-success" href="logout">Logout</a>
    </nav>
	<%

}
%>

</body>
</html>