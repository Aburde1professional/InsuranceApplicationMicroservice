	  	$.ajax({
		  url: "http://localhost:8282/addCustomerClaim",
		  type: "POST",
		  data: JSON.stringify(updatedClaim),
		  contentType: "application/json",
		  success: function() {
		    alert("Claim status updated.")
		  }
		})