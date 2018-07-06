package com.techprimers.springbatchexample1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.springbatchexample1.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	// http://localhost:8081/users
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public List<User> getUsersList() {
		Date currentDate = new Date();
	
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "Ivan Rakitich", "001", 11000, currentDate));
		userList.add(new User(2, "Luka Modrich", "002", 22000, currentDate));
		userList.add(new User(3, "Jesus Navas", "003", 33000, currentDate));
		userList.add(new User(4, "Harry Kane", "004", 44000, currentDate));
		userList.add(new User(5, "Marcus Rashford", "005", 55000, currentDate));
		
    	return userList;
    } 
	
	// Actual demo API : http://localhost:8081/users/apitest
	// Expected Connect v4 API : https://api-dev.vitalsource.com/v4/products
	@RequestMapping(value = "/apitest", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getUser(@RequestHeader HttpHeaders request) {
		List<User> userList = this.getUsersList();
		String idRequest = request.get("id").get(0);
		Integer id = Integer.parseInt(idRequest);
		if (null != id && id != 0) {
			return userList.get(id);
		}
		return null;
	}
	
}
