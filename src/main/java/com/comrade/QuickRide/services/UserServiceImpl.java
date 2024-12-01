package com.comrade.QuickRide.services;

import java.util.ArrayList;
import java.util.List;
import com.comrade.QuickRide.dao.UserDao;
import com.comrade.QuickRide.entities.Coordinate;
import com.comrade.QuickRide.entities.NullUser;
import com.comrade.QuickRide.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	List<User> userList = new ArrayList<>();
	public void loadUsers(){
		userList.add(new User("Abhishek", 'M', 23,null,null));
		userList.add(new User("Rahul", 'M', 29,null,null));
		userList.add(new User("Nandini", 'F', 22,null,null));
		userDao.saveAll(userList);
	}

	public List<User> getList() {
		return userDao.findAll();
	}

	public User getUserById(int userId) {
         User requiredUser = userDao.findById(userId).orElse(null);
		 if(requiredUser == null){
			 return new NullUser();
		 }
		 return requiredUser;
    }

	public void addUser(User user) {
		userDao.save(user);
	}

	public String updateUserLocation(int userId, Coordinate location) {
		User requiredUser = userDao.findById(userId).orElse(null);
		if(requiredUser != null) {
			requiredUser.setLocation(location);
			userDao.save(requiredUser);
			return "Success!!!";
		}
		return "User not found!!!";

	}
	public String findRide(int userId, Coordinate destination) {
		User requiredUser = userDao.findById(userId).orElse(null);
		if(requiredUser != null) {
			requiredUser.setDestination(destination);
			userDao.save(requiredUser);
			return "Success!!!";
		}
		return "User not found!!!";
	}

	public void removeUser(User user) {
		userDao.delete(user);
	}
}
