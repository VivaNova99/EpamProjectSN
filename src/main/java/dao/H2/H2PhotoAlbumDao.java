package dao.H2;

import dao.PhotoAlbumDao;
import lombok.SneakyThrows;
import model.PhotoAlbum;
import model.PhotoStatus;
import model.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.util.OptionHelper.isEmpty;


public class H2PhotoAlbumDao implements PhotoAlbumDao {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    public H2PhotoAlbumDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @SneakyThrows
    @Override
    public void createWithUserPicture(String photoAlbumName, int userId, Part filePart, String photoAlbumDescription, java.sql.Timestamp timestamp, PhotoStatus photoAlbumStatus) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id) VALUES (?, ?, ?, ?, ?, ?)"
             )){

            InputStream fileInputStream = filePart.getInputStream();

            preparedStatement.setObject(1, photoAlbumName);
            preparedStatement.setObject(2, userId);
            preparedStatement.setBinaryStream(3, fileInputStream, (int)filePart.getSize());
            preparedStatement.setObject(4, photoAlbumDescription);
            preparedStatement.setObject(5, timestamp);
            preparedStatement.setObject(6, photoAlbumStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }


    @SneakyThrows
    @Override
    public void createWithDefaultPicture(String photoAlbumName, int userId, String photoAlbumDescription, java.sql.Timestamp timestamp, PhotoStatus photoAlbumStatus) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO PhotoAlbum (name, user_id, photo_album_picture, description, date_time, status_id) VALUES (?, ?, ?, ?, ?, ?)"
             )){

            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/no_image.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);

            preparedStatement.setObject(1, photoAlbumName);
            preparedStatement.setObject(2, userId);
            preparedStatement.setBinaryStream(3, fileInputStream, (int)file.length());
            preparedStatement.setObject(4, photoAlbumDescription);
            preparedStatement.setObject(5, timestamp);
            preparedStatement.setObject(6, photoAlbumStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();

        }

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
                     "u.profile_photo, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "photo_album_picture, " +
                     "description, " +
                     "date_time, " +
                     "status_id " +
                     "FROM PhotoAlbum pa, User u " +
                     "WHERE pa.user_id = u.id")) {
            while (resultSet.next()) {

//                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                String pathname = h2SavePictureFromDatabase.savePhotoAlbumPictureFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                photoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getBlob("photo_album_picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))

                        //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                        pathname
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
                     "u.profile_photo, " +
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
            while (resultSet.next()) {

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                String pathname = h2SavePictureFromDatabase.savePhotoAlbumPictureFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userPhotoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getBlob("photo_album_picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))

                        //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                        pathname
                ));
            }
            return userPhotoAlbums;
        }
    }


    @Override
    @SneakyThrows
    public Collection<PhotoAlbum> getUserPhotoAlbums(int userId) {
        List<PhotoAlbum> userPhotoAlbums = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "pa.id, " +
                     "name, " +
                     "pa.user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "photo_album_picture, " +
                     "description, " +
                     "date_time, " +
                     "status_id " +
                     "FROM PhotoAlbum pa " +
                     "JOIN User u ON pa.user_id = u.id " +
                     "WHERE pa.user_id = ? " +
                     "ORDER BY date_time DESC")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                String pathname = h2SavePictureFromDatabase.savePhotoAlbumPictureFromDatabaseIntoFile(resultSet);

                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                userPhotoAlbums.add(new PhotoAlbum(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getBlob("photo_album_picture"),
                        resultSet.getString("description"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        PhotoStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))

                        //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                        pathname
                ));
            }
            return userPhotoAlbums;
        }
    }

//    @Override
//    @SneakyThrows
//    public boolean isUserPhotoalbumsListEmpty(int userId) {
//        List<PhotoAlbum> userPhotoAlbums = new ArrayList<>();
//        boolean isListEmpty;
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
//                     "pa.id, " +
//                     "name, " +
//                     "pa.user_id, " +
//                     "u.id, " +
//                     "u.profile_photo, " +
//                     "u.first_name, " +
//                     "u.last_name, " +
//                     "photo_album_picture, " +
//                     "description, " +
//                     "date_time, " +
//                     "status_id " +
//                     "FROM PhotoAlbum pa " +
//                     "JOIN User u ON pa.user_id = u.id " +
//                     "WHERE pa.user_id = ? " +
//                     "ORDER BY date_time DESC")) {
//
//            preparedStatement.setInt(1, userId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                //                Для выгрузки фотографий из базы данных при помощи временных файлов
////                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
////                String pathname = h2SavePictureFromDatabase.savePhotoAlbumPictureFromDatabaseIntoFile(resultSet);
//
//                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                userPhotoAlbums.add(new PhotoAlbum(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        new User(
//                                resultSet.getInt("user_id"),
//                                resultSet.getBlob("profile_photo"),
//                                resultSet.getString("first_name"),
//                                resultSet.getString("last_name")
//                        ),
//                        resultSet.getBlob("photo_album_picture"),
//                        resultSet.getString("description"),
//                        simpleFormatter.parse(resultSet.getString("date_time")),
//                        PhotoStatus.valueOf(
//                                resultSet.getInt("status_id") - 1)
//                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
//
//                        //                Для выгрузки фотографий из базы данных при помощи временных файлов
////                        pathname
//                ));
//            }
//            return isListEmpty = isEmpty(String.valueOf(userPhotoAlbums));
//        }
//    }


//    @Override
//    @SneakyThrows
//    public ResultSet transferPhotoalbumPicture(int photoalbumPictureId) {
//
//        try (Connection connection = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement
//                    ("SELECT photo_album_picture FROM PhotoAlbum WHERE id = ?")) {
//
//                preparedStatement.setInt(1, photoalbumPictureId);
//
//                ResultSet photoalbumPictureResultSet = preparedStatement.executeQuery();
//                photoalbumPictureResultSet.next();
//
//                return photoalbumPictureResultSet;
//
//
//            }
//
//    }


    @Override
    @SneakyThrows
    public int getPhotoalbumId(String photoalbumName) {

        //        TODO: добавить try with resources

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id FROM PhotoAlbum WHERE name = ?")){

            preparedStatement.setString(1, photoalbumName);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            int photoalbumId = resultSet.getInt("id");

            return photoalbumId;
        }
    }

    @Override
    @SneakyThrows
    public ResultSet transferPhotoalbumPicture(int photoalbumPictureId) {

        //        TODO: добавить try with resources

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT photo_album_picture FROM PhotoAlbum WHERE id = ?");
        preparedStatement.setInt(1, photoalbumPictureId);
        ResultSet photoalbumPictureResultSet = preparedStatement.executeQuery();
        photoalbumPictureResultSet.next();

        return photoalbumPictureResultSet;


//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("SELECT photo_album_picture FROM PhotoAlbum WHERE id = ?")) {
//
//            preparedStatement.setInt(1, photoalbumPictureId);
//            try (ResultSet photoalbumPictureResultSet = preparedStatement.executeQuery()) {
//
//                photoalbumPictureResultSet.next();
//
//                return photoalbumPictureResultSet;
//            }
//
//        }

    }


}
