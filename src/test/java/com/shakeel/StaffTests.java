package com.shakeel;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shakeel.model.Staff;
import com.shakeel.repo.StaffRepo;
import com.shakeel.serviceimp.StaffServiceImpl;

class StaffTests {

	@InjectMocks
	private StaffServiceImpl staffService;

	@Mock
	private StaffRepo staffRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	protected void testAddStaff() {
		// Arrange
		Staff staff = new Staff();
		doNothing().when(staffRepo).addStaff(staff);

		// Act
		staffService.addStaff(staff);

		// Assert
		verify(staffRepo, times(1)).addStaff(staff);
	}

	@Test
	protected void testGetAllStaff() {
		// Arrange
		List<Staff> staffList = new ArrayList<>();
		when(staffRepo.getAllStaff()).thenReturn(staffList);

		// Act
		List<Staff> result = staffService.getAllStaff();

		// Assert
		assertEquals(staffList, result);
		verify(staffRepo, times(1)).getAllStaff();
	}

	@Test
	protected void testUpdateStaffSuccess() {
		// Arrange
		Staff staff = new Staff();
		when(staffRepo.updateDept(staff)).thenReturn(true);

		// Act
		boolean result = staffService.updateStaff(staff);

		// Assert
		assertTrue(result);
		verify(staffRepo, times(1)).updateDept(staff);
	}

	@Test
	protected void testUpdateStaffFailure() {
		// Arrange
		Staff staff = new Staff();
		when(staffRepo.updateDept(staff)).thenReturn(false);

		// Act
		boolean result = staffService.updateStaff(staff);

		// Assert
		assertFalse(result);
		verify(staffRepo, times(1)).updateDept(staff);
	}

	@Test
	protected void testDeleteStaff() {
		// Arrange
		int staffId = 1;
		doNothing().when(staffRepo).deleteStaff(staffId);

		// Act
		staffService.deleteStaff(staffId);

		// Assert
		verify(staffRepo, times(1)).deleteStaff(staffId);
	}

	@Test
	protected void testStaffLoginSuccess() {
		// Arrange
		String staffName = "staffName";
		String password = "password";
		Staff staff = new Staff();
		when(staffRepo.staffLogin(staffName, password)).thenReturn(staff);

		// Act
		Staff result = staffService.staffLogin(staffName, password);

		// Assert
		assertEquals(staff, result);
		verify(staffRepo, times(1)).staffLogin(staffName, password);
	}

	@Test
	protected void testStaffLoginFailure() {
		// Arrange
		String staffName = "staffName";
		String password = "wrongpassword";
		when(staffRepo.staffLogin(staffName, password)).thenThrow(new RuntimeException("Login failed"));

		// Act
		Staff result = staffService.staffLogin(staffName, password);

		// Assert
		assertNull(result);
		verify(staffRepo, times(1)).staffLogin(staffName, password);
	}

}
