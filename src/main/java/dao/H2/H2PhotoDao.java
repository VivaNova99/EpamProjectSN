package dao.H2;

import dao.PhotoDao;
import lombok.SneakyThrows;
import model.Photo;
import model.PhotoAlbum;
import model.PhotoStatus;
import model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class H2PhotoDao implements PhotoDao
{

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    public H2PhotoDao(DataSource dataSource) {
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
    public Collection<Photo> getAll() {
        List<Photo> photos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "p.id, " +
                     "p.user_id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "p.photo_album_id, " +
                     "pa.name," +
                     "p.picture, " +
                     "p.description, " +
                     "p.date_time, " +
                     "p.status_id " +
                     "FROM Photo p " +
                     "JOIN User u ON p.user_id = u.id " +
                     "JOIN PhotoAlbum pa ON p.photo_album_id = pa.id")) {
            while (resultSet.next()){

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                h2SavePictureFromDatabase.savePhotoFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                photos.add(new Photo(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        new PhotoAlbum(resultSet.getString("name")),
                        resultSet.getBlob("picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return photos;
        }
    }


    @Override
    @SneakyThrows
    public Collection<Photo> getLast5() {
        List<Photo> last5Photos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "p.id, " +
                     "p.user_id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "p.photo_album_id, " +
                     "pa.name," +
                     "p.picture, " +
                     "p.description, " +
                     "p.date_time, " +
                     "p.status_id " +
                     "FROM Photo p " +
                     "JOIN User u ON p.user_id = u.id " +
                     "JOIN PhotoAlbum pa ON p.photo_album_id = pa.id " +
                     "WHERE p.user_id = 1 " +
                     "ORDER BY date_time DESC LIMIT 5")) {
            while (resultSet.next()){

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                h2SavePictureFromDatabase.savePhotoFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                last5Photos.add(new Photo(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        new PhotoAlbum(resultSet.getString("name")),
                        resultSet.getBlob("picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return last5Photos;
        }
    }


    @Override
    @SneakyThrows
    public Collection<Photo> getUserPhotos() {
        List<Photo> UserPhotos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "p.id, " +
                     "p.user_id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "p.photo_album_id, " +
                     "pa.name," +
                     "p.picture, " +
                     "p.description, " +
                     "p.date_time, " +
                     "p.status_id " +
                     "FROM Photo p " +
                     "JOIN User u ON p.user_id = u.id " +
                     "JOIN PhotoAlbum pa ON p.photo_album_id = pa.id " +
                     "WHERE p.user_id = 1 " +
                     "ORDER BY date_time DESC")) {
            while (resultSet.next()){

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                h2SavePictureFromDatabase.savePhotoFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                UserPhotos.add(new Photo(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        new PhotoAlbum(resultSet.getString("name")),
                        resultSet.getBlob("picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return UserPhotos;
        }
    }


    @Override
    @SneakyThrows
    public ResultSet transferPhotoPicture(int photoPictureId) {


        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT picture FROM Photo WHERE id = ?");
        preparedStatement.setInt(1, photoPictureId);

        ResultSet photoPictureResultSet = preparedStatement.executeQuery();
        photoPictureResultSet.next();

        return photoPictureResultSet;

    }


}
