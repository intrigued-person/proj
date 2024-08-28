package com.shakeel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Application;
import com.shakeel.repo.ApplicationRepo;
import com.shakeel.serviceimp.ApplicationServiceImpl;

class ApplicationTests {

    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @Mock
    private ApplicationRepo applicationRepo;

    @Mock
    private MultipartFile profileImage;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    protected void testApplyApplication() throws IOException {
        // Arrange
        doNothing().when(applicationRepo).applyApplication(anyString(), anyLong(), anyString(), anyString(), 
                anyString(), anyString(), anyLong(), anyString(), anyDouble(), anyDouble(), anyString(), 
                anyString(), anyString(), anyLong(), any(MultipartFile.class), anyInt(), anyInt());

        // Act
        applicationService.applyApplication("John Doe", 1234567890L, "Male", "1990-01-01", "Father Name", 
                "Mother Name", 9876543210L, "Religion", 85.5, 90.0, "Degree", "Address", "State", 
                123456, profileImage, 1, 1);

        // Assert
        verify(applicationRepo, times(1)).applyApplication(anyString(), anyLong(), anyString(), anyString(), 
                anyString(), anyString(), anyLong(), anyString(), anyDouble(), anyDouble(), anyString(), 
                anyString(), anyString(), anyLong(), any(MultipartFile.class), anyInt(), anyInt());
    }

    @Test
    protected void testGetAllApplication() {
        // Arrange
        List<Application> applications = new ArrayList<>();
        when(applicationRepo.getAllApplication()).thenReturn(applications);

        // Act
        List<Application> result = applicationService.getAllApplication();

        // Assert
        assertEquals(applications, result);
        verify(applicationRepo, times(1)).getAllApplication();
    }

    @Test
    protected void testUpdateApplicationSuccess() {
        // Arrange
        int applicationId = 1;
        String status = "Approved";
        Application application = new Application();
        when(applicationRepo.findById(applicationId)).thenReturn(application);
        doNothing().when(applicationRepo).updateApplication(application);

        // Act
        boolean result = applicationService.updateApplication(applicationId, status);

        // Assert
        assertTrue(result);
        verify(applicationRepo, times(1)).findById(applicationId);
        verify(applicationRepo, times(1)).updateApplication(application);
    }

    @Test
    protected void testUpdateApplicationFailure() {
        // Arrange
        int applicationId = 1;
        String status = "Approved";
        when(applicationRepo.findById(applicationId)).thenThrow(new RuntimeException("Database error"));

        // Act
        boolean result = applicationService.updateApplication(applicationId, status);

        // Assert
        assertFalse(result);
        verify(applicationRepo, times(1)).findById(applicationId);
    }

    @Test
    protected void testDeleteApplication() {
        // Arrange
        int applicationId = 1;
        doNothing().when(applicationRepo).deleteApplication(applicationId);

        // Act
        applicationService.deleteApplication(applicationId);

        // Assert
        verify(applicationRepo, times(1)).deleteApplication(applicationId);
    }

    @Test
    protected void testFindById() {
        // Arrange
        int applicationId = 1;
        Application application = new Application();
        when(applicationRepo.findById(applicationId)).thenReturn(application);

        // Act
        Application result = applicationService.findById(applicationId);

        // Assert
        assertEquals(application, result);
        verify(applicationRepo, times(1)).findById(applicationId);
    }

    @Test
    protected void testFindByUserId() {
        // Arrange
        int userId = 1;
        Application application = new Application();
        when(applicationRepo.findByUserId(userId)).thenReturn(application);

        // Act
        Application result = applicationService.findByUserId(userId);

        // Assert
        assertEquals(application, result);
        verify(applicationRepo, times(1)).findByUserId(userId);
    }


}
