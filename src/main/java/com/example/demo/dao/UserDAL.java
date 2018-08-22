package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	String getAddress(String userId);

	String updateAddress(String userID, String address);

}
