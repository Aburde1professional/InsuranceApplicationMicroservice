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
<script src="http://localhost:8282/js/adminClaims.js"></script>
<head>
<meta charset="UTF-8">
</head>
<body>

	<center><h1>Admin- Approve or Deny</h1></center><br><br>

    <center><table border = "1" id="adminAllClaims"><th>Claim Id</th><th>Claimant Name</th><th>Claimant Contact Number</th><th>Claimant Date of Birth</th><th>Witness Name</th><th>Accident Location</th><th>Accident Description</th><th>Claim Status</th><th>Approve/Deny Claim</th></table>
</body>
</html>