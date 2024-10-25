package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо список фотографій
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("1", "image1.jpg", null));
        photos.add(new Photo("2", "image2.jpg", null));

        // Створюємо список історії
        List<History> historyList = new ArrayList<>();
        historyList.add(new History("1", java.time.LocalDate.now(), null, null));
        historyList.add(new History("2", java.time.LocalDate.now(), null, null));

        // Створення об'єкта User за допомогою Builder
        User user1 = new User.Builder("user123")
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@example.com")
                .withPhoneNumber("123456789")
                .withBirthDate(new Date())
                .withLocationUser("New York")
                .withPhotos(photos)
                .withHistoryList(historyList)
                .build();

        // Друк інформації про користувача
        System.out.println("User 1 Info: " + user1);

        // Перевірка методів equals і hashCode
        User user2 = new User.Builder("user123")
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@example.com")
                .withPhoneNumber("123456789")
                .withBirthDate(user1.getBirthDate())
                .withLocationUser("New York")
                .withPhotos(photos)
                .withHistoryList(historyList)
                .build();

        System.out.println("User 1 equals User 2: " + user1.equals(user2));
        System.out.println("User 1 hashCode: " + user1.hashCode());
        System.out.println("User 2 hashCode: " + user2.hashCode());


        User user3 = new User.Builder("user456")
                .withFirstName("Jane")
                .withLastName("Smith")
                .withEmail("jane.smith@example.com")
                .withPhoneNumber("987654321")
                .withBirthDate(new Date())
                .withLocationUser("Los Angeles")
                .withPhotos(new ArrayList<>())
                .withHistoryList(new ArrayList<>())
                .build();

        System.out.println("User 3 Info: " + user3);
        System.out.println("User 1 equals User 3: " + user1.equals(user3));
    }
}
