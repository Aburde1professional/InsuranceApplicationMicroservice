package com.synergy.component;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InsuranceClient {
	
	public JsonNode getInsuranceByPolicies(String policies) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getInsuranceByPolicies/" + policies, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		return returnObj;
	}
	
	public JsonNode getPoliciesByCustomerUsername(String customerUsername) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getPoliciesByCustomerUsername/" + customerUsername, Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		return returnObj;
	}
	
	public JsonNode addCustomer(JsonNode customer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        HttpEntity<String> request = new HttpEntity<String>(customer.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveCustomer", request, JsonNode.class);
        JsonNode object = responseEntity.getBody();
        return object;
	}

	public JsonNode addCustomerPolicy(JsonNode customerPolicy) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        HttpEntity<String> request = new HttpEntity<String>(customerPolicy.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveCustomerPolicy", request, JsonNode.class);
        JsonNode object = responseEntity.getBody();
        return object;
	}
	
	public JsonNode addCustomerClaim(JsonNode customerClaim) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        HttpEntity<String> request = new HttpEntity<String>(customerClaim.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity("http://localhost:8383/saveCustomerClaim", request, JsonNode.class);
        JsonNode object = responseEntity.getBody();
        return object;
	}

	public JsonNode getAllClaims() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://localhost:8383/getAllClaimsAdmin", Object.class);
		
		Object objects = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);
		return returnObj;
	}
}
