$(document).ready(function() {

  // Set your publishable key
  let totalAmount = 0;
  let userName = window.location.href.split("/")[4];
  var publishableKey = "pk_test_51NGniWF75olEChOCj6MJVKbdeWFYFsw1VjkybygKL7ZIXYWrZdkYyneDo0hCW9EJCI6JitXXI0eyV1FACvOaH9iZ00WoNML1Zm";
  
  $.ajax({
	  url: `http://localhost:8282/getPoliciesByCustomerUsername/${userName}`,
	  type: "GET",
	  success: function(response){
		  response.forEach(policy => {
			  totalAmount += parseInt(policy.customerPolicyPrice);
		  })
		  $("#totalPrice").append(`${totalAmount} USD`);
		}
	});

  // Submit the payment form

  $("#paymentForm").on("submit", function(event) {

    event.preventDefault();
    // Retrieve the payment form data

    var paymentMethod = $("#paymentMethod").val();
    var cardNumber = $("#cardNumber").val();
    var expiryDate = $("#expiryDate").val();
    var cvv = $("#cvv").val();
    var cvvNumber = parseInt(cvv);
    var nameOnCard = $("#nameOnCard").val();
    
    var street = $("#street").val();
    var city = $("#city").val();
    var state = $("#state").val();
    var zipCode = $("#zipCode").val();
    var email = $("#email").val();
    var phone = $("#phone").val();

    // Create a payment object with the form data

    var paymentData = {

      paymentMethod: paymentMethod,
      cardNumber: cardNumber,
      expiryDate: expiryDate,
      cvv: cvvNumber,
      nameOnCard: nameOnCard,
      totalAmount: totalAmount,
      phone: phone,
      billingAddress: {
        street: street,
        city: city,
        state: state,
        zipCode: zipCode,
        email: email
      },
    };

    // Send the payment data to the server for processing

    $.ajax({
      type: "POST",
      url: "http://localhost:8282/process-payment",
      data: JSON.stringify(paymentData),
      contentType: "application/json",
      success: function(response) {
		  
        // Handle the success response
        console.log("Payment successful:", response);

        // Perform any necessary actions or show a success message to the user
        // Redirect to the confirmation page

        localStorage.setItem("paymentStatus", "Payment successful");
        localStorage.setItem("paymentData", JSON.stringify(paymentData));
        localStorage.setItem("paymentId", JSON.stringify(response.id));

        var paymentId = response.id;
        $.post("http://localhost:8282/sendPaymentDetails/" + paymentId, {}, function(response) {

            // Handle the response from the server

            console.log(response);

           //window.location.href = "/paymentConfirmation?payment_id=" + paymentId;

        // Redirect to the receipt URL

        //window.location.href = response.receiptUrl;

        }).fail(function(jqXHR, textStatus, errorThrown) {

            // Handle the error case

            console.log("Failed to send booking details: " + errorThrown);

        });

        window.location.href = response.receiptUrl;
      },

      error: function(xhr, status, error) {

        // Handle the error response

        console.error("Payment failed:", error);

        // Display an error message to the user

        alert("Payment failed. Please try again.");
      }
    });
  });
});