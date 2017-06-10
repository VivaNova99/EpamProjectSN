package dao;

import lombok.SneakyThrows;
import model.Photo;
import model.PhotoStatus;

import javax.servlet.http.Part;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Optional;


public interface PhotoDao {
    int save();
    default Optional<Photo> get(int id){
        return getAll().stream()
                .filter(photo -> photo.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<Photo> getAll();

    Collection<Photo> getLast5();

    Collection<Photo> getLast5(int someUserId);

    Collection<Photo> getUserPhotos();

    Collection<Photo> getUserPhotos(int userId);

    ResultSet transferPhotoPicture(int photoPictureId);

//    @SneakyThrows
//    void insertUploadedPictureIntoUserPhotos(int userId, int photoAlbumId, Part filePart, String photoDescription, java.util.Date date, PhotoStatus photoStatus);

    @SneakyThrows
    void insertUploadedPictureIntoUserPhotos(int userId, int photoAlbumId, Part filePart, String photoDescription, java.sql.Timestamp timestamp, PhotoStatus photoStatus);
}
