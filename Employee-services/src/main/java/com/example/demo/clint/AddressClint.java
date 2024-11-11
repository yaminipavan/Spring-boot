package com.example.demo.clint;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Address1;

import lombok.Data;

@Component
@Data
public class AddressClint {
	
	@Autowired
	private RestTemplate restTemplate;

	public void saveAddress(List<Address1> address1, Integer empid) {
		
		address1.stream().forEach(address->{
		  
			address.setEmpid(empid);
			org.springframework.http.HttpHeaders httpHeaders  = new org.springframework.http.HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
			HttpEntity<Address1> httpEntity  = new HttpEntity<Address1>(address,httpHeaders);
			restTemplate.exchange("http://localhost:7070/Address-Service", HttpMethod.POST, httpEntity, String.class);
			
		});
		
		
	}
}
