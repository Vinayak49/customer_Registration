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
<title>Search</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="h-100 h-custom" >
  <div class="mt-2">
    <div class="row d-flex justify-content-center align-items-center h-20">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <div class="card-body p-1 p-md-1">
				<h3 class="mb-1 mb-md-2 px-md-1">Search Customer</h3>
				
            <form class="px-md-2" action="search">

			<div class="form-column">
              <div class="form-outline mb-1">
                <label class="form-label" for="form3Example1q">First Name</label>
                <input type="text" name="fname" id="form3Example1q" class="form-control" />
              </div>
              <div class="form-outline mb-1 ">
                <label class="form-label" for="form3Example1q">Last Name</label>
                <input type="text" name="lname" id="form3Example1q" class="form-control" />
              </div>
			</div>

             
              <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>

            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>