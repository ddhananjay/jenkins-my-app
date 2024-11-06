import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.app.entity.PortalUser;
import org.app.service.AppService;
import org.junit.jupiter.api.Test;

class AppServiceTest {

    private final AppService appService = new AppService();

    @Test
    void testGetUserInfo_ValidUserName() {
        // Arrange
        String userName = "anyUserName";

        // Act
        PortalUser result = appService.getUserInfo(userName);

        // Assert
        assertNotNull(result, "Expected non-null user object");
        assertEquals(1, result.getUserId());
        assertEquals("Test User", result.getUserName());
        assertEquals("test@gmail.com", result.getUserMail());
        assertEquals("password", result.getPassword());
        assertEquals("admin", result.getRoles());
    }

    @Test
    void testGetUserInfo_DifferentUserName() {
        // Arrange
        String userName = "differentUser";

        // Act
        PortalUser result = appService.getUserInfo(userName);

        // Assert
        assertNotNull(result, "Expected non-null user object");
        assertEquals(1, result.getUserId());
        assertEquals("Test User", result.getUserName());
        assertEquals("test@gmail.com", result.getUserMail());
        assertEquals("password", result.getPassword());
        assertEquals("admin", result.getRoles());
    }

    @Test
    void testGetUserInfo_NullUserName() {
        // Arrange
        String userName = null;

        // Act
        PortalUser result = appService.getUserInfo(userName);

        // Assert
        assertNotNull(result, "Expected non-null user object");
        assertEquals(1, result.getUserId());
        assertEquals("Test User", result.getUserName());
        assertEquals("test@gmail.com", result.getUserMail());
        assertEquals("password", result.getPassword());
        assertEquals("admin", result.getRoles());
    }
}

