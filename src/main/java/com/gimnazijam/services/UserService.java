package com.gimnazijam.services;

import java.util.List;

import com.gimnazijam.entities.User;

public interface UserService {

	public List<User> getAllUser();

	public User getUserByUsername(String username);

	public void saveOrUpdate(User user);

	public void deleteUser(int id);

}
