package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Staff;

public interface StaffRepo {
	
	public void addStaff(Staff staff);

	public Staff staffLogin(String staffName, String password);
	
	public List<Staff> getAllStaff();

	public boolean updateDept(Staff staff);
	
	public void deleteStaff(int staffId);

}
