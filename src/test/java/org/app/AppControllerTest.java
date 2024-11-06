package org.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.app.controller.AppController;
import org.app.entity.PortalUser;
import org.app.service.AppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AppControllerTest {

        @Mock
        private AppService appService;

        @InjectMocks
        private AppController yourController;

        @BeforeEach
        void setUp() {
            openMocks(this);
        }

        @Test
        void testGetData_UserFound() {
            // Arrange
            String username = "johndoe";
            PortalUser user = new PortalUser();
            user.setUserName("johndoe");
            user.setUserMail("johndoe@example.com");

            when(appService.getUserInfo(username)).thenReturn(user);

            // Act
            String result = yourController.getData(username);

            // Assert
            assertEquals("found user :johndoe johndoe@example.com", result);
        }

        @Test
        void testGetData_UserNotFound() {
            // Arrange
            String username = "unknownuser";

            when(appService.getUserInfo(username)).thenReturn(null);

            // Act
            String result = yourController.getData(username);

            // Assert
            assertEquals("No user found", result);
        }

        @Test
        void testGetData_NullUsername() {
            // Arrange
            String username = null;

            when(appService.getUserInfo(username)).thenReturn(null);

            // Act
            String result = yourController.getData(username);

            // Assert
            assertEquals("No user found", result);
        }

}
