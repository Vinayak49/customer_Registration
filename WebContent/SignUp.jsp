<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class="h-100 h-custom" >
  <div class="mt-2">
    <div class="row d-flex justify-content-center align-items-center h-20">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <div class="card-body p-1 p-md-1">
				<h3 class="mb-1 mb-md-2 px-md-1">SignUp Here...</h3>
            <form class="px-md-2" action="SignUp" method="post">
				<div class="form-row">
	              <div class="form-outline mb-1 col-md-6">
	                <label class="form-label" for="form3Example1q">First Name</label>
	                <input type="text" name="fname" id="form3Example1q" class="form-control" />
	              </div>
	              <div class="form-outline mb-1 col-md-6">
	                <label class="form-label" for="form3Example1q">Last Name</label>
	                <input type="text" name="lname" id="form3Example1q" class="form-control" />
	              </div>
				</div>
				<div class="form-row">
				<div class="form-outline mb-1 col-md-8">
                <label class="form-label" for="form3Example1q">Address</label>
                <input type="text" name="address" id="form3Example1q" class="form-control" />
              </div>
              <div class="form-outline mb-1 col-md-4" >
                <label class="form-label" for="form3Example1q">Zip</label>
                <input type="number" name="zip" id="form3Example1q" class="form-control" />
              </div>
              </div>
              
              <div class="form-row">
				<div class="form-outline mb-1 col-md-4">
	                <label class="form-label" for="form3Example1q">City</label>
	                <input type="text" name="city" id="form3Example1q" class="form-control" />
              	</div>
              	<div class="form-outline mb-1 col-md-4" >
	                <label class="form-label" for="form3Example1q">State</label>
	                <input type="text" name="state" id="form3Example1q" class="form-control" />
              	</div>
              	<div class="form-outline mb-1 col-md-4" >
	                <label class="form-label" for="form3Example1q">Country</label>
	                <input type="text" name="country" id="form3Example1q" class="form-control" />
              	</div>
              </div>
			<div class="form-row">
              <div class="form-outline mb-1 col-md-6">
                <label class="form-label" for="form3Example1q">Email</label>
                <input type="email" name="userid" id="form3Example1q" class="form-control" />
              </div>
              <div class="form-outline mb-1 col-md-6">
                <label class="form-label" for="form3Example1q">Password</label>
                <input type="password" name="password" id="form3Example1q" class="form-control" />
              </div>
			</div>
		   <div class="form-outline mb-1">
               <label class="form-label" for="form3Example1q">Phone</label>
               <input type="number" name="phone" id="form3Example1q" class="form-control" />
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