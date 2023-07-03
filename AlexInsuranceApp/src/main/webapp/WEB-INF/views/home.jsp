<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Insurance App</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="./js/home.js"></script>
</head>
<body>
<div class="container" style="margin-left:100px">
<h1>Do you need Auto Insurance?</h1>
<h2>You've come to the right place. Click "Search" below after filling in your information to see policies and coverage options.</h2>
<h4><a href="http://localhost:8282/login">Login</a></h4><br>
</div>

<div class="container border rounded" style="margin:auto;padding:50px;margin-top:50px;margin-bottom:50px">
	<h3>Enter your information in the fields below.</h3>
	<div class="form-row">
	<div class="col">
		Full Name (First and Last) <input class="form-control" type="text" id="customerName"/>
	</div>
	<div class="col">
		Car Year, Make, and Model <input class="form-control" type="text" id="customerVehicle"/>
	</div>
	<div class="col">
	    Date of Birth <input type="date" id="dateOfBirth" name="dateOfBirth"/>
	</div>
	<div class="col">
		Input a total monetary limit for policies below <input type="number" id="customerPriceLimit">
	</div>
	<div class="col">
	    <label for="customerGender">Gender</label>
            <select id="customerGender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
	</div>
    <div class="col">
	    <label for="policyChoices">What type of insurance do you need?</label>
            <input type="checkbox" id="liabilityCoverage"><label id="liabilityCoverageName">Liability</label><br>
            <input type="checkbox" id="comprehensiveCoverage"><label id="comprehensiveCoverageName">Comprehensive</label><br>
			<input type="checkbox" id="collisionCoverage"><label id="collisionCoverageName">Collision</label><br>
			<input type="checkbox" id="medicalPaymentsCoverage"><label id="medicalPaymentsCoverageName">Medical Payments</label><br>
	</div>
	<input class="btn-sm btn-primary" type="button" id="searchBtn" value="SEARCH"/>
	</div>
</div>

<center>
	<div class="col-7 border rounded" style="margin-left:50px;">
		<div style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica, sans-serif'>List of Policies:</div>	
		
		<div id="listPolicies">
			<center>
				<table border="1" id="tblPolicies">
					<tr><th>Monthly Cost</th><th>Coverage Policy Name</th><th>Coverage Description</th></tr>
				</table>
			</center>
		</div>
		<br></div><input type="text" id="customerEmail" placeholder = "Enter your email here"/><br><br>
		<input class="btn-sm btn-primary" type="button" id="sendEmail" value="Send email with coverage details"/></div>
	</div>
</center>

</div>

<script>
var slider = document.getElementById("priceRange");
var output = document.getElementById("priceValue");
output.innerHTML = slider.value;
slider.oninput = function() {
	output.innerHTML = this.value;
}
</script>
</body>
</html>