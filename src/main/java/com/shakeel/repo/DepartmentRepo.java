package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Departments;

public interface DepartmentRepo {
	
	public void addDept(Departments dept);


	public List<Departments> getAllDepertment();

	public boolean updateDept(Departments department);
	
	public void deleteDept(int id);
	
	public List<Departments> getAlldeptName();
	
	public List<Departments> getUgDept();
	
	public List<Departments> getPgDept();
	
	public List<Departments> getAllPgDetails();
	
	public List<Departments> getAllUgDetails();
	
	
	

}
