package models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import java.time.LocalDate;
import java.util.List;

public class User implements Comparable<User> {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final LocalDate birthDate;  // Використовуємо LocalDate замість Date
    private final String locationUser;
    private final List<Photo> photos;
    private final List<History> historyList;

    private User(String userId, String firstName, String lastName, String email,
                 String phoneNumber, LocalDate birthDate, String locationUser,
                 List<Photo> photos, List<History> historyList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.locationUser = locationUser;
        this.photos = photos;
        this.historyList = historyList;
    }


    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {  // Повертає LocalDate
        return birthDate;
    }

    public String getLocationUser() {
        return locationUser;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    @Override
    public int compareTo(User other) {
        return this.birthDate.compareTo(other.birthDate);  // Порівняння LocalDate
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", locationUser='" + locationUser + '\'' +
                '}';
    }

    public static class Builder {
        private final String userId;  // Обов'язкове поле
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private LocalDate birthDate;  // Використовуємо LocalDate замість Date
        private String locationUser;
        private List<Photo> photos;
        private List<History> historyList;

        public Builder(String userId) {
            this.userId = userId;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withBirthDate(LocalDate birthDate) {  // Параметр типу LocalDate
            this.birthDate = birthDate;
            return this;
        }

        public Builder withLocationUser(String locationUser) {
            this.locationUser = locationUser;
            return this;
        }

        public Builder withPhotos(List<Photo> photos) {
            this.photos = photos;
            return this;
        }

        public Builder withHistoryList(List<History> historyList) {
            this.historyList = historyList;
            return this;
        }

        public User build() {
            return new User(userId, firstName, lastName, email, phoneNumber,
                    birthDate, locationUser, photos, historyList);
        }
    }
}
