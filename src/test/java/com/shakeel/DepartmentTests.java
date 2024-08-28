package com.shakeel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shakeel.model.Departments;
import com.shakeel.repo.DepartmentRepo;
import com.shakeel.serviceimp.DepartmentServiceImpl;

class DepartmentTests {

	 @InjectMocks
	    private DepartmentServiceImpl departmentService;

	    @Mock
	    private DepartmentRepo departmentRepo;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    protected void testAddDept() {
	        // Arrange
	        Departments dept = new Departments();
	        doNothing().when(departmentRepo).addDept(dept);

	        // Act
	        departmentService.addDept(dept);

	        // Assert
	        verify(departmentRepo, times(1)).addDept(dept);
	    }

	    @Test
	    protected void testGetAllDepertment() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getAllDepertment()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getAllDepertment();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getAllDepertment();
	    }

	    @Test
	    protected void testUpdateDept() {
	        // Arrange
	        Departments dept = new Departments();
	        when(departmentRepo.updateDept(dept)).thenReturn(true);

	        // Act
	        boolean result = departmentService.updateDept(dept);

	        // Assert
	        assertTrue(result);
	        verify(departmentRepo, times(1)).updateDept(dept);
	    }

	    @Test
	    protected void testDeleteDept() {
	        // Arrange
	        int id = 1;
	        doNothing().when(departmentRepo).deleteDept(id);

	        // Act
	        departmentService.deleteDept(id);

	        // Assert
	        verify(departmentRepo, times(1)).deleteDept(id);
	    }

	    @Test
	    protected void testGetAlldeptName() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getAlldeptName()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getAlldeptName();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getAlldeptName();
	    }

	    @Test
	    protected void testGetPgdeptName() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getPgDept()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getPgdeptName();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getPgDept();
	    }

	    @Test
	    protected void testGetUgdeptName() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getUgDept()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getUgdeptName();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getUgDept();
	    }

	    @Test
	    protected void testGetAllPgDetails() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getAllPgDetails()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getAllPgDetails();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getAllPgDetails();
	    }

	    @Test
	    protected void testGetAllUgDetails() {
	        // Arrange
	        List<Departments> departments = new ArrayList<>();
	        when(departmentRepo.getAllUgDetails()).thenReturn(departments);

	        // Act
	        List<Departments> result = departmentService.getAllUgDetails();

	        // Assert
	        assertEquals(departments, result);
	        verify(departmentRepo, times(1)).getAllUgDetails();
	    }

}
