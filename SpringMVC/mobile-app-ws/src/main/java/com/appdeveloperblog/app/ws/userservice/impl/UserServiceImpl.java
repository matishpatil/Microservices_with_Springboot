package com.appdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.ui.model.reuest.UserDetailsReuestModel;
import com.appdeveloperblog.app.ws.userservice.UserService;
import com.appdeveloperblog.app.ws.utils.Utils;

@Service
public class UserServiceImpl implements UserService{

	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {}

	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}


	@Override
	public UserRest createUser(UserDetailsReuestModel userDetails) {
		UserRest retVal = new UserRest();
		retVal.setFirstName(userDetails.getFirstName());
		retVal.setLastName(userDetails.getLastName());
		retVal.setEmail(userDetails.getEmail());
		
		String userId = utils.generateUserId();
		retVal.setUserId(userId);
		if(users == null) users = new HashMap<>();
		users.put(userId, retVal);
		
		return retVal;	
	}

}
