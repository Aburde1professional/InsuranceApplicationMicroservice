<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>  
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="./js/login.js"></script>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body style='height: 100vh' class='w-100'>

	<div class='mt-5 d-flex justify-content-center'>
	<frm:form id="loginForm">

		<div class='form-group'>
			<label>
				Please Enter Username:
			</label>
			<input class='form-control' type = 'text' name='username' id="userName"/>
		</div>
		
		<div class='form-group'>
			<label>
				Please Enter Password:
			</label>
			<input class='form-control' type = 'password' name='password'/>
		</div>
		<div><span class='text-muted'>Forgot your password? </span ><a href='#'>Reset Here!</a></div>
		<div><span class='text-muted'>Don't Have an Account? </span ><a href='/signup' id="signUpLink">Create Here!</a></div>
		<input class='btn btn-primary mt-5' id="signInButton" type = 'submit' value='Submit'/>
		<sec:csrfInput/>
	</frm:form>
	</div>

	<div>
		<center>
			<table border="1" id="tblCustomerPolicies">
				<h3 id="customerInsuranceTitle">Below is the summary of your Insurance Coverage for your vehicle.</h3><br><br>
				<tr><th>Monthly Cost</th><th>Coverage Policy Name</th><th>Coverage Description</th></tr>
			</table><br><br>

			<form id="customerDocuments" action = "http://localhost:8282/uploadCustomerDocuments" method = "post" enctype='multipart/form-data'>
				<h6>Please upload your documents below.</h6><br>
				<input type="file" name = "file" value="Upload License" accept="image/png, image/jpeg" id="driversLicenseUpload"><br><br>
				<input type="file" name = "file" value="Upload Registration" accept="image/png, image/jpeg" id="vehicleRegistrationUpload"><br><br>

				<input type = "submit" id = "addDocuments" name="submitDocuments" value = "Submit Documents">
			</form><br><br>

			<a href = "/customerClaims/" id = "customerClaimsPortal">Click Here to Submit a Claim</a><br><br>
			<a href = "/checkout" id = "checkoutLink">Click here to submit payment</a>
		</center>
	</div>

</body>
</html>