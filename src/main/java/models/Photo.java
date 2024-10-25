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
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return photoId.equals(photo.photoId) &&
                Objects.equals(image, photo.image) &&
                Objects.equals(user, photo.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, image, user);
    }
}
