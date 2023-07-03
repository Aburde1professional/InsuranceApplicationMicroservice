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
<script src="http://localhost:8282/js/customerClaim.js"></script>
<head>
<meta charset="UTF-8">
</head>
<body>
    <h1>Auto Insurance Claim Form</h1>
    
    <form>
      
      <label for="claimant_name">Claimant Name:</label>
      <input type="text" id="claimantName" name="claimant_name" required><br><br>
      
      <label for="contact_number">Contact Number:</label>
      <input type="text" id="contactNumber" name="contact_number" required><br><br>
      
      <label for="date_of_accident">Date of Accident:</label>
      <input type="date" id="dateOfAccident" name="date_of_accident" required><br><br>
      
      <label for="location">Location of Accident:</label>
      <input type="text" id="locationOfAccident" name="location" required><br><br>
      
      <label for="description">Description of Accident:</label><br>
      <textarea id="descriptionOfAccident" name="descriptionOfAccident" rows="4" cols="50" required></textarea><br><br>
      
      <label for="witness_name">Witness Name:</label>
      <input type="text" id="witnessName" name="witness_name"><br><br>
      
      <input type="submit" value="Submit Claim" id = "submitClaim">
    </form>
  </body>
</html>