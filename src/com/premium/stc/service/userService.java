package com.premium.stc.service;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.premium.stc.dao.UserDaoInterface;
import com.premium.stc.model.User;

@Service
@Transactional
public class userService implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDaoInterface;
	
	@Override
	public int addOrUpdateUser(User userData, int index) {
		return userDaoInterface.addOrUpdateUser(userData,2);
	}

	@Override
	public User getUser(String username, String password) {
		return userDaoInterface.getUser(username, password);
	}

	@Override
	public List<User> usersList() {
		return userDaoInterface.usersList();
	}

	@Override
	public User getUserByIdOrUsername(int id, String username) {
		return userDaoInterface.getUserByIdOrUsername(id, username);
	}

	@Override
	public boolean deleteUserByIdOrUsername(int id, String username) {
		return userDaoInterface.deleteUserByIdOrUsername(id, username);
	}
}