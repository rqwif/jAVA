package models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Date birthDate;
    private final String locationUser;
    private final List<Photo> photos;
    private final List<History> historyList;

    public User(String userId, String firstName, String lastName, String email,
                String phoneNumber, Date birthDate, String locationUser, List<Photo> photos, List<History> historyList) {
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

    // Додамо геттер для birthDate
    public Date getBirthDate() {
        return birthDate;
    }

    public static class Builder {
        private final String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Date birthDate;
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

        public Builder withBirthDate(Date birthDate) {
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
            return new User(userId, firstName, lastName, email, phoneNumber, birthDate, locationUser, photos, historyList);
        }
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
                ", photos=" + photos +
                ", historyList=" + historyList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(locationUser, user.locationUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, phoneNumber, birthDate, locationUser);
    }
}
