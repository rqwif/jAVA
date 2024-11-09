package models;

import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація користувачів з використанням LocalDate
        User user1 = new User.Builder("1")
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john@example.com")
                .withPhoneNumber("123456789")
                .withBirthDate(LocalDate.of(1990, 1, 1)) // передаємо LocalDate
                .withLocationUser("New York")
                .build();

        User user2 = new User.Builder("2")
                .withFirstName("Alice")
                .withLastName("Smith")
                .withEmail("alice@example.com")
                .withPhoneNumber("987654321")
                .withBirthDate(LocalDate.of(1985, 3, 15)) // передаємо LocalDate
                .withLocationUser("Los Angeles")
                .build();

        User user3 = new User.Builder("3")
                .withFirstName("Bob")
                .withLastName("Brown")
                .withEmail("bob@example.com")
                .withPhoneNumber("111222333")
                .withBirthDate(LocalDate.of(1995, 5, 20)) // передаємо LocalDate
                .withLocationUser("New York")
                .build();

        // Створення списку користувачів
        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3));

        // Створення UserService з цим списком
        UserService userService = new UserService(users);

        // Використання методів
        System.out.println("Users from New York:");
        userService.findUsersByLocation("New York").forEach(System.out::println);

        System.out.println("\nUsers sorted by birth date:");
        userService.sortUsersByBirthDate().forEach(System.out::println);

        System.out.println("\nFind user by email 'alice@example.com':");
        userService.findUserByEmail("alice@example.com")
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));

        System.out.println("\nGroup users by location:");
        Map<String, List<User>> groupedUsers = userService.groupUsersByLocation();
        groupedUsers.forEach((location, userList) -> {
            System.out.println(location + ": " + userList);
        });

        // Додавання нового користувача
        User user4 = new User.Builder("4")
                .withFirstName("Charlie")
                .withLastName("Davis")
                .withEmail("charlie@example.com")
                .withPhoneNumber("555666777")
                .withBirthDate(LocalDate.of(1992, 6, 10)) // передаємо LocalDate
                .withLocationUser("Chicago")
                .build();
        userService.addUser(user4);

        System.out.println("\nAfter adding new user:");
        userService.getUsers().forEach(System.out::println);
    }
}
