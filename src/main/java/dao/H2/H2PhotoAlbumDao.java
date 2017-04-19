package dao.H2;

import dao.PhotoAlbumDao;
import lombok.SneakyThrows;
import model.PhotoAlbum;
import model.PhotoStatus;
import model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by veraivanova on 18.03.17.
 */
public class H2PhotoAlbumDao implements PhotoAlbumDao {

       @Resource(name = "jdbc/TestDB")
       private DataSource dataSource;

    public H2PhotoAlbumDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int save() {
        return 0;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    @SneakyThrows
    public Collection<PhotoAlbum> getAll() {
        List<PhotoAlbum> photoAlbums = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "pa.id, " +
                     "name, " +
                     "pa.user_id, " +
                     "u.id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "photo_album_picture, " +
                     "description, " +
                     "date_time, " +
                     "status_id " +
                     "FROM PhotoAlbum pa, User u " +
                     "WHERE pa.user_id = u.id")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                photoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("photo_album_picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return photoAlbums;
        }
    }


    @Override
    @SneakyThrows
    public Collection<PhotoAlbum> getUserPhotoAlbums() {
        List<PhotoAlbum> userPhotoAlbums = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "pa.id, " +
                     "name, " +
                     "pa.user_id, " +
                     "u.id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "photo_album_picture, " +
                     "description, " +
                     "date_time, " +
                     "status_id " +
                     "FROM PhotoAlbum pa " +
                     "JOIN User u ON pa.user_id = u.id " +
                     "WHERE pa.user_id = 1 " +
                     "ORDER BY date_time DESC")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userPhotoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("photo_album_picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return userPhotoAlbums;
        }
    }


}
