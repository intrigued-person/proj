package com.shakeel.service;

import java.util.List;

import com.shakeel.model.UserReg;




public interface UserService {
	
      public void addUser(UserReg user);
	
      public UserReg studentLogin(String email,String password);
      
      public List<UserReg> getAllUsers();
      
      public boolean updateUser(UserReg user);
      
     
      
     
}
