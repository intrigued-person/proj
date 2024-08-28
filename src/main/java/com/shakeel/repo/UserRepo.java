package com.shakeel.repo;

import java.util.*;

import com.shakeel.model.UserReg;

public interface UserRepo {

	public void addUser(UserReg user);

	public UserReg studentLogin(String email, String password);

	public List<UserReg> getAllUsers();

	public boolean updateUser(UserReg user);
	
	public UserReg findById(int userId);
	
	
	Optional<UserReg> findByEmail (String email);
	
	

}
