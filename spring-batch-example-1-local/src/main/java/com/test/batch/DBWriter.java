package com.test.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.model.User;
import com.test.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<User>{
	
	@Autowired
	private UserRepository repository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data saved for users : "+users);
		repository.save(users);
	}
	
}
