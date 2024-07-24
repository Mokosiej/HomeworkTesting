import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testGetLogin() {
        User user = new User("user123", "password123", "user@example.com");
        assertEquals("user123", user.getLogin());
    }

    @Test
    public void testGetPassword() {
        User user = new User("user123", "password123", "user@example.com");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testGetEmail() {
        User user = new User("user123", "password123", "user@example.com");
        assertEquals("user@example.com", user.getEmail());
    }

    @Test
    public void testSetLogin() {
        User user = new User("user123", "password123", "user@example.com");
        user.setLogin("newuser");
        assertEquals("newuser", user.getLogin());
    }

    @Test
    public void testSetLoginThrowsException() {
        User user = new User("user123", "password123", "user@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setLogin("us");
        });
        assertEquals("Логин должен быть не менее 3 символов!", exception.getMessage());
    }

    @Test
    public void testSetPassword() {
        User user = new User("user123", "password123", "user@example.com");
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testSetPasswordThrowsException() {
        User user = new User("user123", "password123", "user@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setPassword("short");
        });
        assertEquals("Пароль должен быть не менее 8 символов!", exception.getMessage());
    }

    @Test
    public void testSetEmail() {
        User user = new User("user123", "password123", "user@example.com");
        user.setEmail("newuser@example.com");
        assertEquals("newuser@example.com", user.getEmail());
    }

    @Test
    public void testSetEmailThrowsException() {
        User user = new User("user123", "password123", "user@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setEmail("userexample.com");
        });
        assertEquals("Email должен содержать '@'!", exception.getMessage());
    }

    @Test
    public void testIsValidPassword() {
        User user = new User("user123", "password123", "user@example.com");
        assertTrue(user.isValidPassword("password123"));
        assertFalse(user.isValidPassword("wrongpassword"));
    }
}
