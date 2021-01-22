package com.appdeveloperblog.app.ws.ui.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdeveloperblog.app.ws.exceptions.UserServiceException;
import com.appdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appdeveloperblog.app.ws.ui.model.reuest.UpdateUserDetailsRequestModel;
import com.appdeveloperblog.app.ws.ui.model.reuest.UserDetailsReuestModel;
import com.appdeveloperblog.app.ws.userservice.UserService;
import com.appdeveloperblog.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("users") //http://localhost:8080/users?page=1&limit=20 - query parameters
public class UserController {
	
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue = "1") int page,  //required - false
			@RequestParam(value="limit", defaultValue = "20") int limit,
			@RequestParam(value="sort", required=false) String sort) {
		return "get user was called with page "+ page + " and limit "+ limit + " sort "+ sort;
	}
	
	@GetMapping(path="/{userId}", produces= { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(true) throw new UserServiceException("A user service exception is thrown");
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}
	
	/*
	 * @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE }, produces = {
	 * MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) public
	 * ResponseEntity<UserRest> createUser(@Valid @RequestBody
	 * UserDetailsReuestModel userDetails) { UserRest retVal = new UserRest();
	 * retVal.setFirstName(userDetails.getFirstName());
	 * retVal.setLastName(userDetails.getLastName());
	 * retVal.setEmail(userDetails.getEmail());
	 * 
	 * String userId = UUID.randomUUID().toString(); retVal.setUserId(userId);
	 * if(users == null) users = new HashMap<>(); users.put(userId, retVal);
	 * 
	 * return new ResponseEntity<UserRest>(retVal, HttpStatus.OK); }
	 */
	
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsReuestModel userDetails) {
		//UserRest retVal = new UserServiceImpl().createUser(userDetails);	
		
		UserRest retVal = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(retVal, HttpStatus.OK);	
	}
	
	@PutMapping(path="/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		
		return ResponseEntity.noContent().build();
	}
}
