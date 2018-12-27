package com.test.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.test.model.User;

@Component
public class Processor implements ItemProcessor<User, User> {

	private static final Map<String, String> DEPT_NAMES = new HashMap<>();
	
	public Processor() {
		DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002", "Operations");
		DEPT_NAMES.put("003", "Accounts");
	}
	
	// process: here we transform dept_code to dept_name
	@Override
	public User process(User user) throws Exception {
		
		String deptCode = user.getDept();
		String dept = DEPT_NAMES.get(deptCode);
		user.setDept(dept);
		System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
		return user;
	}

}
