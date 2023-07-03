$(document).ready(function() {
	
	$("#submitClaim").click(function(event) {
	  event.preventDefault();
	  let claimantUsername = window.location.pathname.split("/")[2];
	  let claimantName = $("#claimantName").val();
		
	  let claimantContactNumber = $("#contactNumber").val();
	  let claimantDateOfBirth = $("#dateOfAccident").val();
	  let accidentLocation = $("#locationOfAccident").val();
	  let accidentDescription = $("#descriptionOfAccident").val();
	  let witnessName = $("#witnessName").val();
	
	  let customerClaim = {
		"claimantUsername": claimantUsername,
		"claimantName": claimantName,
		"claimantContactNumber": claimantContactNumber,
		"claimantDateOfBirth": claimantDateOfBirth,
		"accidentLocation": accidentLocation,
		"accidentDescription": accidentDescription,
		"witnessName": witnessName
	  };
	  
	  console.log(customerClaim);
		
	  $.ajax({
		  url: "http://localhost:8282/addCustomerClaim",
		  type: "POST",
		  data: JSON.stringify(customerClaim),
		  contentType: "application/json",
		  success: alert("Claim added")
		});
	});
});