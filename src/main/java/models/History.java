package models;

import java.time.LocalDate;
import java.util.Objects;

public class History {
    private final String historyId;
    private final LocalDate historyData;
    private final User user;
    private final Photo photo;

    public History(String historyId, LocalDate historyData, User user, Photo photo) {
        this.historyId = historyId;
        this.historyData = historyData;
        this.user = user;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", historyData=" + historyData +
                ", user=" + user +
                ", photo=" + photo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return historyId.equals(history.historyId) &&
                Objects.equals(historyData, history.historyData) &&
                Objects.equals(user, history.user) &&
                Objects.equals(photo, history.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, historyData, user, photo);
    }
}
