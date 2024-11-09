package models;

import java.util.Objects;

public class Photo {
    private final String photoId;
    private final String image;
    private final User user;

    public Photo(String photoId, String image, User user) {
        this.photoId = photoId;
        this.image = image;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId='" + photoId + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
