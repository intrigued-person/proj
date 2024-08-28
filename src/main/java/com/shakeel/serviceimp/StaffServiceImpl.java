package com.shakeel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakeel.model.Staff;
import com.shakeel.repo.StaffRepo;
import com.shakeel.service.StaffService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepo dao;

	@Override
	public void addStaff(Staff staff) {
		dao.addStaff(staff);
	}

	@Override
	public List<Staff> getAllStaff() {

		return dao.getAllStaff();
	}

	@Override
	public boolean updateStaff(Staff staff) {

		return dao.updateDept(staff);
	}

	@Override
	public void deleteStaff(int staffId) {
		dao.deleteStaff(staffId);

	}

	@Override
	public Staff staffLogin(String staffName, String password) {
		
		Staff staff=null;
		try {
			staff= dao.staffLogin(staffName, password);
		} catch (Exception e) {
			staff=null;
		}

		return staff;
	}

}
