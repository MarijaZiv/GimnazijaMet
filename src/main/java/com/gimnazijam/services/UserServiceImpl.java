package com.gimnazijam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnazijam.entities.User;
import com.gimnazijam.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);

	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
