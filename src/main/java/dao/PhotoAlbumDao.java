package dao;

import lombok.SneakyThrows;
import model.PhotoAlbum;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by veraivanova on 18.03.17.
 */
public interface PhotoAlbumDao {
    int save();
    default Optional<PhotoAlbum> get(int id){
        return getAll().stream()
                .filter(photoAlbum -> photoAlbum.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<PhotoAlbum> getAll();

    Collection<PhotoAlbum> getUserPhotoAlbums();

    Collection<PhotoAlbum> getUserPhotoAlbums(int userId);

    ResultSet transferPhotoalbumPicture(int photoalbumPictureId);

}
