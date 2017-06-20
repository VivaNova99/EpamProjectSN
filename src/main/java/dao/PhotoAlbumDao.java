package dao;

import lombok.SneakyThrows;
import model.PhotoAlbum;
import model.PhotoStatus;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.Collection;


public interface PhotoAlbumDao {
//    int save();
//    default Optional<PhotoAlbum> get(int id){
//        return getAll().stream()
//                .filter(photoAlbum -> photoAlbum.getId() == id)
//                .findAny();
//    };

    void createWithUserPicture(String photoAlbumName, int userId, Part filePart, String photoAlbumDescription, java.sql.Timestamp timestamp, PhotoStatus photoAlbumStatus);

    void createWithDefaultPicture(String photoAlbumName, int userId, String photoAlbumDescription, java.sql.Timestamp timestamp, PhotoStatus photoAlbumStatus);

    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<PhotoAlbum> getAll();

    Collection<PhotoAlbum> getUserPhotoAlbums();

    Collection<PhotoAlbum> getUserPhotoAlbums(int userId);

    @SneakyThrows
    int getPhotoalbumId(String photoalbumName);

    InputStream transferPhotoalbumPicture(int photoalbumPictureId);

}
