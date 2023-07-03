$(document).ready(function() {
	$("#tblCustomerPolicies").hide();
	$("#customerInsuranceTitle").hide();
	$("#customerDocuments").hide();
	$("#paymentPortal").hide();
	$("#customerClaimsPortal").hide();
	$("#checkoutLink").hide();
	
	$("#signInButton").click(function(event) {
		event.preventDefault();
		let userName = $("#userName").val();
		
		$.ajax({
			url:"http://localhost:8282/login",
			method: "GET",
			success: function() {
				$("#loginForm").hide();
				$("#tblCustomerPolicies").show();
				$("#customerInsuranceTitle").show();
				$("#customerDocuments").show();
				$("#paymentPortal").show();
				$("#customerClaimsPortal").show();
				$("#checkoutLink").show();
			}
		});
		
		$.ajax({
			url: `http://localhost:8282/getPoliciesByCustomerUsername/${userName}`,
			type: "GET",
			success: function(response){
				response.forEach(policy => {
					$("#tblCustomerPolicies").append(`<tr><td>${policy.customerPolicyPrice}</td><td>${policy.customerPolicyName}</td><td>${policy.customerPolicyDescription}</td></tr>`)
				})
			}
		});
		
		if (userName == "admin") {
			$("#customerClaimsPortal")[0].href += "admin";
		} else {
			$("#customerClaimsPortal")[0].href += $("#userName").val();
			$("#checkoutLink")[0].href += "/";
			$("#checkoutLink")[0].href += $("#userName").val();
		}
	});
	
	
});