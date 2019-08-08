package com.premium.stc.dao;

import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.premium.stc.model.User;

@Repository
public class UserDao implements UserDaoInterface{

	@Autowired
	SessionFactory sessionfactory;


	//Adding or updating the user
	@Override
	public int addOrUpdateUser(User userData,int i) {
		try {
			Session session = sessionfactory.getCurrentSession();
			if(i==1) {
				int x = (int)session.save(userData);
				return x;
			}else {
				session.update(userData);
				return 1;
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}


	//user authorization for login
	@Override
	@SuppressWarnings("unchecked")
	public User getUser(String username, String password) {
		try {
			Session session = sessionfactory.getCurrentSession();
			List<User> userList = session.createQuery("from User where username = ? and userPassword = ?")
					.setParameter(0, username).setParameter(1, password).list();
			if(userList.size()!=0&&userList!=null) {
				return userList.get(0);
			} 
		} catch (Exception e) {
			System.out.println("Cannot be connected to database");
		}
		return null;
	}


	//Getting users list
	@SuppressWarnings("unchecked")
	@Override
	public List<User> usersList() {
		List<User> listOfUser = null;
		try {
			Session session = sessionfactory.getCurrentSession();
			listOfUser = session.createQuery("from User").list();
			return listOfUser;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listOfUser;

	}


	//getting user with username or id
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByIdOrUsername(int id, String username) {
		Session session = sessionfactory.getCurrentSession();
		if(id ==0) {
			try {
				List<User> user = session.createQuery("from User where username = ?")
						.setParameter(0, username).list();
				if(user.size()!=0||user!=null)
					return (User)user.get(0);

			}catch (Exception e) {
				System.out.println(e.getMessage());
			} return null;
		} else {
			try {
				User user = session.byId(User.class).getReference(id);
				return user;
			} catch (ObjectNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
	}



	//Deleting user with id or username
	//deleting a not existing user giving error
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteUserByIdOrUsername(int id, String username) {
		Session session = sessionfactory.getCurrentSession();
		try {
			if(id!=0) {
				User user = new User();
				user.setUserId(id);
				session.delete(user);
				return true;
			}else {
				List<User> user = session.createQuery("from User where username =?")
						.setParameter(0, username).list();
				session.delete((User)user.get(0));
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}




}
