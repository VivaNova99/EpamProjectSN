package dao;

import lombok.SneakyThrows;
import model.Photo;
import model.PhotoStatus;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.Collection;


public interface PhotoDao {
//    int save();
//    default Optional<Photo> get(int id){
//        return getAll().stream()
//                .filter(photo -> photo.getId() == id)
//                .findAny();
//    };

    @SneakyThrows
    void create(int userId, int photoAlbumId, Part filePart, String photoDescription, java.sql.Timestamp timestamp, PhotoStatus photoStatus);

    void deletePhoto(int id);

    Collection<Photo> getAll();

//    Collection<Photo> getLast5();

    Collection<Photo> getLast5(int someUserId);

//    Collection<Photo> getUserPhotos();

    Collection<Photo> getUserPhotos(int userId);

    Collection<Photo> getUserPhotosInThisPhotoalbum(int userId, int photoalbumId);

    InputStream transferPhotoPicture(int photoPictureId);

//    @SneakyThrows
//    void insertUploadedPictureIntoUserPhotos(int userId, int photoAlbumId, Part filePart, String photoDescription, java.util.Date date, PhotoStatus photoStatus);

//    @SneakyThrows
//    void insertUploadedPictureIntoUserPhotos(int userId, int photoAlbumId, Part filePart, String photoDescription, java.sql.Timestamp timestamp, PhotoStatus photoStatus);
}
