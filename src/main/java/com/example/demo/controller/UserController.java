package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDALImpl;
import com.example.demo.model.User;

@RestController
public class UserController {
	//@Autowired
	//UserRepository userRepository;
	@Autowired
	UserDALImpl userDAL;
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userDAL.addNewUser(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userDAL.getUserById(userId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userDAL.getAllUsers();
	}

	// get User address
	@GetMapping("/getAddress/{mobileNo}")
	public String getMobileNo(@PathVariable String mobileNo) {
		return userDAL.getAddress(mobileNo);
	}

	@GetMapping("/updateAddress/{userId}/{address}")
	public String updateAddress(@PathVariable String userId, @PathVariable String address) {
		User user = userDAL.getUserById(userId);
		if (user!=null) {
			user.setAddress(address);
			userDAL.addNewUser(user);
			return "your address updated successfully";
		}
		return "User Not Found";
	}
}
