$(document).ready(function() {
	$("#searchBtn").click(function() {
		$("#tblPolicies").find("tr:gt(0)").remove();
		
		let liabilityClicked = $("#liabilityCoverage").is(':checked');
		let comprehensiveClicked = $("#comprehensiveCoverage").is(':checked');
		let collisionClicked = $("#collisionCoverage").is(':checked');
		let medicalPaymentsClicked = $("#medicalPaymentsCoverage").is(':checked');
		
		let customerPriceLimit = parseInt($("#customerPriceLimit")[0].value);
		let totalPrice = 0;
		
		if (liabilityClicked) {
			let text = $("#liabilityCoverageName")[0].textContent;
			
			$.ajax({
				url: `http://localhost:8282/searchInsurancePolicies/${text}`,
				type: "GET",
				success: function(response){
					totalPrice += response[0].policyPrice;
					if (totalPrice > customerPriceLimit) {
						alert("The total price of your insurance policies is over the limit you entered. Please enter a different number for your limit or uncheck a policy box.");
					}
					$("#tblPolicies").append(`<tr><td>${response[0].policyPrice}</td><td>${response[0].policyName}</td><td>${response[0].policyDescription}</td></tr>`);
				}
			});
		};
		
		if(comprehensiveClicked) {
			let text = $("#comprehensiveCoverageName")[0].textContent;
			
			$.ajax({
				url: `http://localhost:8282/searchInsurancePolicies/${text}`,
				type: "GET",
				success: function(response){
					totalPrice += response[0].policyPrice;
					if (totalPrice > customerPriceLimit) {
						alert("The total price of your insurance policies is over the limit you entered. Please enter a different number for your limit or uncheck a policy box.");
					}
					$("#tblPolicies").append(`<tr><td>${response[0].policyPrice}</td><td>${response[0].policyName}</td><td>${response[0].policyDescription}</td></tr>`);
				}
			});
		};
		
		if (collisionClicked) {
			let text = $("#collisionCoverageName")[0].textContent;
			
			$.ajax({
				url: `http://localhost:8282/searchInsurancePolicies/${text}`,
				type: "GET",
				success: function(response){
					totalPrice += response[0].policyPrice;
					if (totalPrice > customerPriceLimit) {
						alert("The total price of your insurance policies is over the limit you entered. Please enter a different number for your limit or uncheck a policy box.");
					}
					$("#tblPolicies").append(`<tr><td>${response[0].policyPrice}</td><td>${response[0].policyName}</td><td>${response[0].policyDescription}</td></tr>`);
				}
			});
		};
		
		if(medicalPaymentsClicked) {
			let text = $("#medicalPaymentsCoverageName")[0].textContent;
			
			$.ajax({
				url: `http://localhost:8282/searchInsurancePolicies/${text}`,
				type: "GET",
				success: function(response){
					totalPrice += response[0].policyPrice;
					if (totalPrice > customerPriceLimit) {
						alert("The total price of your insurance policies is over the limit you entered. Please enter a different number for your limit or uncheck a policy box.");
					}
					$("#tblPolicies").append(`<tr><td>${response[0].policyPrice}</td><td>${response[0].policyName}</td><td>${response[0].policyDescription}</td></tr>`);
				}
			});
		}
	});
	
	$("#sendEmail").click(function() {
		let customerEmail = $("#customerEmail")[0].value;
		let customerPolicyData = [];
		let message = `Thanks for your interest in buying auto insurance. Below is a summary of your coverage and the total monthly cost of those policies, as well as your login and password to view your coverage.`;
		
		let tableData = ($("#tblPolicies tr").not(":first"));

		for(let rowIndex = 0; rowIndex < tableData.length; rowIndex += 1) {
			row = $(tableData[rowIndex].children);
			
			let rowData = {
				monthlyPrice: row[0].textContent,
				policyName: row[1].textContent,
				policyDescription: row[2].textContent
			};
			customerPolicyData.push(rowData);
		}
		
		customerPolicyData.forEach(policy => {
			message += ` Monthly Cost: ${policy.monthlyPrice}, Policy Name: ${policy.policyName}, Policy Description: ${policy.policyDescription}.`
		});
		
		message += `Your username is the email you used to register, and your password is "alex".`
		
		let emailData = {
			"recipient": customerEmail,
			"msgBody": message,
			"subject": "Welcome!"
		};
		
		let userData = {
			"userName": customerEmail,
			"userPassword": "alex",
		};
		
		let customerData = {
			"customerName": $("#customerName").val(),
			"customerVehicle": $("#customerVehicle").val(),
			"customerDateOfBirth": $("#dateOfBirth").val(),
			"customerPriceLimit": parseFloat($("#customerPriceLimit").val())
		};
		
		$.ajax({
			url: "http://localhost:8282/sendMail",
			type: "POST",
			data: JSON.stringify(emailData),
			contentType: "application/json"
		})
		
		$.ajax({
			url: "http://localhost:8282/saveUser",
			type: "POST",
			data: JSON.stringify(userData),
			contentType: "application/json"
		});
		
		customerPolicyData.forEach(policy => {
			let customerPolicies = {
				"customer": customerData,
				"customerPolicyName": policy.policyName,
				"customerPolicyDescription": policy.policyDescription,
				"customerPolicyPrice": policy.monthlyPrice,
				"customerUsername": customerEmail
			};
			
			$.ajax({
				url: "http://localhost:8282/addCustomerPolicy",
				type: "POST",
				data: JSON.stringify(customerPolicies),
				contentType: "application/json",
				success: alert("Policy added")
			});
		});
	});
});