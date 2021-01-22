package com.appdeveloperblog.app.ws.userservice;

import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.ui.model.reuest.UserDetailsReuestModel;

public interface UserService {
	
	UserRest createUser(UserDetailsReuestModel userDetails);

}
