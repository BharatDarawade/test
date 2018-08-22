package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findById(userId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	// get User address
	@GetMapping("/getAddress/{userId}")
	public String getMobileNo(@PathVariable String userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			return user.get().getAddress();
		return "User Not Found";
	}

	@GetMapping("/updateAddress/{userId}/{address}")
	public String updateAddress(@PathVariable String userId, @PathVariable String address) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			user.get().setAddress(address);
			userRepository.save(user.get());
			return "your address updated successfully";
		}
		return "User Not Found";
	}
}
