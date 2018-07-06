package com.techprimers.springbatchexample1.customizedItemReaders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techprimers.springbatchexample1.dto.UserDTO;

/**
 * Here we have implemented 3 read() methods
 * 
 * 1) 1st read() implmentation is for simply consuming an external GET REST API which returns a LIST of Items
 * 2) 2nd read() implmentation is for consuming an external GET REST API which returns a single UserDTO object but its done using HttpHeader
 * 
 * the 3rd method is our concern which we need to replicate & integrate into JobManager
 * 
 * @author abharsa
 *
 */
public class RESTUserReader implements ItemReader<UserDTO> {

	private String apiUrl = null; // contains the URL of the external REST API.
	private RestTemplate restTemplate = null; // ref. to the RestTemplate, so as to fetch the user information.

	private int nextStudentIndex; // index of the next StudentDTO object.
	private List<UserDTO> userDataList; // list of user objects obtained from ReST API

	@Autowired
	private Environment environment;
	
	public RESTUserReader(String apiUrl, RestTemplate restTemplate) {
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
		nextStudentIndex = 0;
	}

	/**
		// This read() method I have overwritten to read an entire List of Objects from some 3rd Party API
	// 2nd Read Method Implementation
	@Override
	public UserDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (isUserDataNotInitialized()) {
			userDataList = this.fetchUserDataFromAPI();
		}

		UserDTO nextUser = null;

		if (nextStudentIndex < userDataList.size()) {
			nextUser = userDataList.get(nextStudentIndex);
			nextStudentIndex++;
		}

		return nextUser;
	}
	
	
	private boolean isUserDataNotInitialized() {
		return (this.userDataList == null);
	}


	
	private List<UserDTO> fetchUserDataFromAPI() {
		ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(apiUrl, UserDTO[].class);
		UserDTO[] userDataArray = response.getBody();
		return Arrays.asList(userDataArray);
	}
	*/
	
	
	private boolean isUserDataNotInitialized() {
		return (this.userDTO == null);
	}
	
	private UserDTO userDTO;
	
	/**
	 * 3rd Read() method Implmentation
	 */
	@Override
	public UserDTO read() throws Exception {
		// TODO :  get current bridge api key at runtime & pass it in the place of {id}
		if (isUserDataNotInitialized()) {
			userDTO = this.fetchUserDataFromAPI(environment, 1);		// Passing the variable in static way for time being
		}
		System.out.println("Got USER_DTO OBJECT: "+userDTO);
		return userDTO;
	}
	
	private UserDTO fetchUserDataFromAPI(Environment environment, Integer id) {
		RestTemplate restTemplate = new RestTemplate();
    	
    	HttpHeaders httpHeaders = new HttpHeaders();
    	httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    	httpHeaders.add("id", id.toString());

    	HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

    	UserDTO userDTO = restTemplate.exchange(environment.getRequiredProperty("get.user.for.id.url"), HttpMethod.GET, entity, UserDTO.class).getBody();
    	
        return (null != userDTO) ? userDTO : null;
	}
	
}
