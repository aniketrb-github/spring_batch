package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.dto.UserDTO;
import com.techprimers.springbatchexample1.repository.UserReSTRepository;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is an customized class written specially for our REST API Consumption/Reading
 * UserDTO is the Class into which u have to read data from the desired API
 * say for ex. connect v4 is returning an User entity, so we have created out own DTO say UserDTo.java class which is same as connect's User.java
 * so as to map the JSON data returned by connect v4 api into our side
 * 
 * Here in write() method we will implement the Logic of saving the data which we read from connect V4 API to database
 * 
 * @author abharsa
 *
 */
@Component
public class RESTAPI_UserWriter implements ItemWriter<UserDTO> {

	@Autowired
	private UserReSTRepository userRepository;

	@Override
	public void write(List<? extends UserDTO> users) throws Exception {

		System.out.println("Data Saved for Users: " + users);
		userRepository.save(users);
	}
}
