package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import models.User;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        LocalDate birthDate1 = LocalDate.of(1990, 1, 1);
        LocalDate birthDate2 = LocalDate.of(1985, 3, 15);
        LocalDate birthDate3 = LocalDate.of(1995, 5, 20);

        User user1 = new User.Builder("1")
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john@example.com")
                .withPhoneNumber("123456789")
                .withBirthDate(birthDate1)
                .withLocationUser("New York")
                .build();

        User user2 = new User.Builder("2")
                .withFirstName("Alice")
                .withLastName("Smith")
                .withEmail("alice@example.com")
                .withPhoneNumber("987654321")
                .withBirthDate(birthDate2)
                .withLocationUser("Los Angeles")
                .build();

        User user3 = new User.Builder("3")
                .withFirstName("Bob")
                .withLastName("Brown")
                .withEmail("bob@example.com")
                .withPhoneNumber("111222333")
                .withBirthDate(birthDate3)
                .withLocationUser("New York")
                .build();

        List<User> users = Arrays.asList(user1, user2, user3);
        userService = new UserService(users);
    }

    @Test
    public void testFindUsersByLocation() {
        List<User> result = userService.findUsersByLocation("New York");
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(u -> u.getFirstName().equals("John")));
        assertTrue(result.stream().anyMatch(u -> u.getFirstName().equals("Bob")));
    }

    @Test
    public void testSortUsersByBirthDate() {
        List<User> result = userService.sortUsersByBirthDate();
        assertEquals("Alice", result.get(0).getFirstName());
        assertEquals("John", result.get(1).getFirstName());
        assertEquals("Bob", result.get(2).getFirstName());
    }

    @Test
    public void testFindUserByEmail() {
        Optional<User> result = userService.findUserByEmail("alice@example.com");
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getFirstName());
    }

    @Test
    public void testFindUserByEmail_NotFound() {
        Optional<User> result = userService.findUserByEmail("nonexistent@example.com");
        assertFalse(result.isPresent());
    }

    @Test
    public void testGroupUsersByLocation() {
        Map<String, List<User>> groupedUsers = userService.groupUsersByLocation();
        assertEquals(2, groupedUsers.get("New York").size());
        assertEquals(1, groupedUsers.get("Los Angeles").size());
    }
}
