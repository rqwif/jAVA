package models;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class UserService {

    private final List<User> users;

    public UserService(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("User list cannot be null");
        }
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (user != null) {
            this.users.add(user);
        } else {
            throw new IllegalArgumentException("User cannot be null");
        }
    }

    public void removeUser(User user) {
        if (user != null) {
            this.users.remove(user);
        } else {
            throw new IllegalArgumentException("User cannot be null");
        }
    }

    // 1. Пошук користувачів за місцем проживання
    public List<User> findUsersByLocation(String location) {
        if (location == null) {
            return List.of();
        }
        return users.stream()
                .filter(user -> user.getLocationUser() != null && user.getLocationUser().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    // 2. Сортування за датою народження (Comparator)
    public List<User> sortUsersByBirthDate() {
        return users.stream()
                .sorted(Comparator.comparing(User::getBirthDate))
                .collect(Collectors.toList());
    }

    // 3. Пошук за email
    public Optional<User> findUserByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return users.stream()
                .filter(user -> user.getEmail() != null && user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    // 4. Групування за місцем проживання
    public Map<String, List<User>> groupUsersByLocation() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getLocationUser));
    }
}
