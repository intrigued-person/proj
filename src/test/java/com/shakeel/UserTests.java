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

import com.shakeel.model.UserReg;
import com.shakeel.repo.UserRepo;
import com.shakeel.serviceimp.UserServiceImpl;

class UserTests {

	@InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    protected void testAddUser() {
        // Arrange
        UserReg user = new UserReg();
        doNothing().when(userRepo).addUser(user);

        // Act
        userService.addUser(user);

        // Assert
        verify(userRepo, times(1)).addUser(user);
    }

    @Test
    protected void testStudentLoginSuccess() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        UserReg user = new UserReg();
        when(userRepo.studentLogin(email, password)).thenReturn(user);

        // Act
        UserReg result = userService.studentLogin(email, password);

        // Assert
        assertEquals(user, result);
        verify(userRepo, times(1)).studentLogin(email, password);
    }

    @Test
    protected void testStudentLoginFailure() {
        // Arrange
        String email = "test@example.com";
        String password = "wrongpassword";
        when(userRepo.studentLogin(email, password)).thenThrow(new RuntimeException("Login failed"));

        // Act
        UserReg result = userService.studentLogin(email, password);

        // Assert
        assertNull(result);
        verify(userRepo, times(1)).studentLogin(email, password);
    }

    @Test
    protected void testGetAllUsers() {
        // Arrange
        List<UserReg> users = new ArrayList<>();
        when(userRepo.getAllUsers()).thenReturn(users);

        // Act
        List<UserReg> result = userService.getAllUsers();

        // Assert
        assertEquals(users, result);
        verify(userRepo, times(1)).getAllUsers();
    }

    @Test
    protected void testUpdateUser() {
        // Arrange
        UserReg user = new UserReg();
        when(userRepo.updateUser(user)).thenReturn(true);

        // Act
        boolean result = userService.updateUser(user);

        // Assert
        assertTrue(result);
        verify(userRepo, times(1)).updateUser(user);
    }

}
