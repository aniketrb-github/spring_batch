package com.techprimers.springbatchexample1.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.techprimers.springbatchexample1.dto.UserDTO;

/**
 * Here, this is the class where u process the data obtained from connect V4 api.
 * processing is noting but transforming the obtained data into something else
 * for ex. i got data as 001 dept code but if we want to save dept code as dept name for better readability say 001 == UI/UX
 * then that transformation is to be implmented here
 * 
 * so basically we need to understand what transformation we need to perform on the obtained data.
 * if nothing, its fine we save the obtained v4 API data as it is the DB
 * 
 * @author abharsa
 *
 */
@Component
public class RESTAPIUserProcessor implements ItemProcessor<UserDTO, UserDTO> {

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public RESTAPIUserProcessor() {
        DEPT_NAMES.put("001", "UI/UX");
        DEPT_NAMES.put("002", "API Dept.");
        DEPT_NAMES.put("003", "IOS/Android");
        DEPT_NAMES.put("004", "Dev Ops");
        DEPT_NAMES.put("005", "Test");
    }

    @Override
    public UserDTO process(UserDTO user) throws Exception {
        
    	// Get DEPT from User Object
    	String deptCode = user.getDept();
    	
    	// Get the Actual Code from some Master List 
        String dept = DEPT_NAMES.get(deptCode);
        
        // set the Master Value to ur object
        user.setDept(dept);
        
        // set new Time
        user.setTime(new Date());
        
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
