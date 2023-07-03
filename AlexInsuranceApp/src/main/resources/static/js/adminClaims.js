$(document).ready(function() {
	
	$.ajax({
		url: "http://localhost:8282/getAllClaims",
		type: "GET",
		success: function(response) {		
			response.forEach(claim => {
				$("#adminAllClaims").append(`<tr><td>${claim.customerClaimId}</td><td>${claim.claimantName}</td><td>${claim.claimantContactNumber}</td><td>${claim.claimantDateOfBirth}</td><td>${claim.witnessName}</td><td>${claim.accidentLocation}</td><td>${claim.accidentDescription}</td><td>${claim.claimStatus}</td><td><input type = "submit" value = "Approve" id = "approveClaim"><input type = "submit" value = "Deny" id = "denyClaim"></td></tr>`)
			});
		}
	});
	
	$("#adminAllClaims").on("click", "input", function(event){
		let claimData;
		let customerClaimId = parseInt($(event.target).parent().siblings()[0].textContent);
		let claimantName = $(event.target).parent().siblings()[1].textContent;
		let claimantContactNumber = $(event.target).parent().siblings()[2].textContent;
		let claimantDateOfBirth = $(event.target).parent().siblings()[3].textContent; 
		let witnessName = $(event.target).parent().siblings()[4].textContent;
		let accidentLocation = $(event.target).parent().siblings()[5].textContent;
		let accidentDescription = $(event.target).parent().siblings()[6].textContent;
		let claimStatus;
		
		if (event.target.value == "Approve") {
			claimStatus = "Approved";
			
			claimData = {
				"customerClaimId": customerClaimId,
				"claimantName": claimantName,
				"claimantContactNumber": claimantContactNumber,
				"claimantDateOfBirth": claimantDateOfBirth,
				"witnessName": witnessName,
				"accidentLocation": accidentLocation,
				"accidentDescription": accidentDescription,
				"claimStatus": claimStatus
			};
			
		    $.ajax({
		    	url: "http://localhost:8282/addCustomerClaim",
		  		type: "POST",
		  		data: JSON.stringify(claimData),
		  		contentType: "application/json",
		  	 	success: alert("Claim added")
		  	});
			
		} else if (event.target.value == "Deny") {
			claimStatus = "Denied";
			
			claimData = {
				"customerClaimId": customerClaimId,
				"claimantName": claimantName,
				"claimantContactNumber": claimantContactNumber,
				"claimantDateOfBirth": claimantDateOfBirth,
				"witnessName": witnessName,
				"accidentLocation": accidentLocation,
				"accidentDescription": accidentDescription,
				"claimStatus": claimStatus
			};
			
			$.ajax({
		      url: "http://localhost:8282/addCustomerClaim",
		  	  type: "POST",
		  	  data: JSON.stringify(claimData),
		  	  contentType: "application/json",
		  	  success: alert("Claim added")
		  });
		}
	});
});