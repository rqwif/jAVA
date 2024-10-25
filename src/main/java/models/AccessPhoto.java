package models;

import java.util.Objects;

public class AccessPhoto {
    private final User userMain;
    private final User userFriend;

    public AccessPhoto(User userMain, User userFriend) {
        this.userMain = userMain;
        this.userFriend = userFriend;
    }

    @Override
    public String toString() {
        return "AccessPhoto{" +
                "userMain=" + userMain +
                ", userFriend=" + userFriend +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessPhoto that = (AccessPhoto) o;
        return Objects.equals(userMain, that.userMain) &&
                Objects.equals(userFriend, that.userFriend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMain, userFriend);
    }
}
