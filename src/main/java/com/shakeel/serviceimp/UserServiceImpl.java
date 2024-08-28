package com.shakeel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakeel.model.UserReg;
import com.shakeel.repo.UserRepo;
import com.shakeel.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	UserRepo dao;

	@Override
	public void addUser(UserReg user) {
		dao.addUser(user);
	}

	@Override
	public UserReg studentLogin(String email, String password) {
		UserReg user = null;
		try {
			user = dao.studentLogin(email, password);
		} catch (Exception e) {
			user = null;

		}
		return user;

	}

	@Override
	public List<UserReg> getAllUsers() {

		return dao.getAllUsers();
	}

	@Override
	public boolean updateUser(UserReg user) {

		return dao.updateUser(user);
	}

}
