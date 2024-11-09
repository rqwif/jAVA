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
                '}';
    }
}
