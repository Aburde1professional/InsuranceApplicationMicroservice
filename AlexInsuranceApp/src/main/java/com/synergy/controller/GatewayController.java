package com.synergy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergy.component.InsuranceClient;
import com.synergy.domain.ResponseMessage;
import com.synergy.dto.EmailDetails;
import com.synergy.service.EmailServiceImpl;
import com.synergy.service.FilesStorageService;


@RestController
public class GatewayController {
	
	@Autowired
	EmailServiceImpl emailService;
	
	@Autowired
	InsuranceClient insuranceClient;
	
	@Autowired
	FilesStorageService storageService;
	
	@RequestMapping(value = "/searchInsurancePolicies/{searchString}", method = RequestMethod.GET)
	public JsonNode searchInsurance(@PathVariable String searchString){
		return insuranceClient.getInsuranceByPolicies(searchString);
	}
	
	@RequestMapping(value = "/getPoliciesByCustomerUsername", method = RequestMethod.GET)
	public JsonNode getPoliciesByCustomer(@PathVariable String customerUsername) {
		return insuranceClient.getPoliciesByCustomerUsername(customerUsername);
	}
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendMail(@RequestBody EmailDetails emailDetails){
		return emailService.sendSimpleMail(emailDetails);
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public JsonNode saveCustomerInfo(@RequestBody JsonNode customer) {
		return insuranceClient.addCustomer(customer);
	}
	
	@RequestMapping(value = "/addCustomerPolicy", method = RequestMethod.POST)
	public JsonNode saveCustomerPolicy(@RequestBody JsonNode customerPolicy) {
		return insuranceClient.addCustomerPolicy(customerPolicy);
	}

	@PostMapping("/uploadCustomerDocuments")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		storageService.init();
		String message = "";
		try {
			storageService.save(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@RequestMapping(value = "/addCustomerClaim", method = RequestMethod.POST)
	public JsonNode addCustomerClaim(@RequestBody JsonNode customerClaim) {
		return insuranceClient.addCustomerClaim(customerClaim);
	}
	
	@RequestMapping(value = "/getAllClaims", method = RequestMethod.GET)
	public JsonNode getAllClaims() {
		return insuranceClient.getAllClaims();
	}
}