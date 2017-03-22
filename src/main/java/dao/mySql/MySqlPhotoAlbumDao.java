package dao.mySql;

import dao.PhotoAlbumDao;
//import javaslang.Function1;
import lombok.SneakyThrows;
import model.ForumThemes;
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
import java.util.Date;
import java.util.List;

/**
 * Created by veraivanova on 18.03.17.
 */
public class MySqlPhotoAlbumDao implements PhotoAlbumDao {

       @Resource(name = "jdbc/TestDB")
       private DataSource dataSource;

    public MySqlPhotoAlbumDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//      //для того, чтобы можно было связать с юзером по id - на вход принимает id, а выдает юзера.
//      // Из библиотеки javaslang
//    Function1<Integer, User> getUserById;
//
//    public MySqlPhotoAlbumDao(Function1<Integer, User> getUserById) {
//        this.getUserById = getUserById;
//    }


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
                     "status_id FROM PhotoAlbum pa, User u WHERE pa.user_id = u.id")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                photoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),

//                        new User(
//                                resultSet.getString("first_name"),
//                                resultSet.getString("last_name")
//                        ).setId(resultSet.getInt("user_id")),

                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),

//                        getUserById.apply(resultSet.getInt("user_id")),

//                        new User().setId(resultSet.getInt("user_id")),

                        resultSet.getString("photo_album_picture"),
                        resultSet.getString("description"),
                        (Date) simpleFormatter.parse(resultSet.getString("date_time")),
//                        resultSet.("date_time").toLocalTime(),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))


                ));
            }
            return photoAlbums;
        }
    }
}
