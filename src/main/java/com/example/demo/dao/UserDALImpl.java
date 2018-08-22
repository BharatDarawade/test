package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String userId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);

		// return mongoTemplate.findById(userId, User.class);
	}

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public String getAddress(String mobileNo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobileNo").is(mobileNo));
		User user = mongoTemplate.findOne(query, User.class);

		return user != null ? user.getAddress() : "User Not Found";
	}

	@Override
	public String updateAddress(String mobileNo, String address) {
		Query query = new Query();
		query.addCriteria(Criteria.where("mobileNo").is(mobileNo));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.setAddress(address);
			mongoTemplate.save(user);
			return "Address updated Successfully";
		}

		return "User Not Found";
	}

}
