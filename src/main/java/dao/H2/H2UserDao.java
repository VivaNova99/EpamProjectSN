package dao.H2;

import dao.UserDao;
import lombok.SneakyThrows;
import model.AccessLevel;
import model.User;

import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;


public class H2UserDao implements UserDao {

    private DataSource dataSource;

    public H2UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    @Override
//    @SneakyThrows
//    public int create(User user) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "INSERT INTO User (" +
//                             "first_name, " +
//                             "last_name, " +
//                             "date_of_birth, " +
//                             "access_level_id, " +
//                             "email, " +
//                             "password, " +
//                             "profile_photo, " +
//                             "status_on_wall, " +
//                             "city) " +
//                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setObject(1, user.getFirstName());
//            preparedStatement.setObject(2, user.getLastName());
//            preparedStatement.setObject(3, user.getDateOfBirth());
//            preparedStatement.setObject(4, user.getAccessLevel().ordinal() + 1);
//            //т.к. ordinal с нуля, а у нас база с автоинкрементом (у меня - не автоинкремент!)
//            // TODO - переделать ordinal на спец. поле
//            preparedStatement.setObject(5, user.getEmail());
//            preparedStatement.setObject(6, user.getPasswordHash());
//            preparedStatement.setObject(7, user.getProfilePhoto());
//            preparedStatement.setObject(8, user.getStatusOnWall());
//            preparedStatement.setObject(9, user.getCity());
//
//            preparedStatement.executeUpdate();
//
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    user.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Ошибка при создании профиля, нет такого ID");
//                }
//            }
//        }
//
//        return user.getId();
//    }


    @Override
    @SneakyThrows
    public int create(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO User (" +
                             "first_name, " +
                             "last_name, " +
                             "date_of_birth, " +
                             "access_level_id, " +
                             "email, " +
                             "password, " +
                             "profile_photo, " +
                             "status_on_wall, " +
                             "city) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            // Для вставки фото профиля
            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/default_large.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);

            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setObject(4, user.getAccessLevel().ordinal() + 1);
            //т.к. ordinal с нуля, а у нас база с автоинкрементом (у меня - не автоинкремент!)
            // TODO - переделать ordinal на спец. поле
            preparedStatement.setObject(5, user.getEmail());
            preparedStatement.setObject(6, user.getPasswordHash());
            preparedStatement.setBinaryStream(7, fileInputStream, (int)file.length());
            preparedStatement.setObject(8, user.getStatusOnWall());
            preparedStatement.setObject(9, user.getCity());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ошибка при создании профиля, нет такого ID");
                }
            }
        }

        return user.getId();
    }


//    @Override
//    @SneakyThrows
//    public void update(User user) {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "UPDATE User SET first_name = ?, " +
//                             "last_name = ?, " +
//                             "date_of_birth = ?, " +
//                             "password = ?, " +
//                             "status_on_wall = ?, " +
//                             "city = ? " +
//                             "WHERE id = ?")) {
//
//            preparedStatement.setObject(1, user.getFirstName());
//            preparedStatement.setObject(2, user.getLastName());
//            preparedStatement.setObject(3, java.sql.Date.valueOf(user.getDateOfBirth()));
//            preparedStatement.setObject(4, user.getPasswordHash());
//            preparedStatement.setObject(5, user.getStatusOnWall());
//            preparedStatement.setObject(6, user.getCity());
//            preparedStatement.setObject(7, user.getId());
//
//            preparedStatement.executeUpdate();
//
////            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
////                if (generatedKeys.next()) {
////                    user.setId(generatedKeys.getInt(1));
////                } else {
////                    throw new SQLException("Ошибка при редактировании профиля, нет такого ID");
////                }
////            }
//        }
//
////        return user.getId();
//    }

    @Override
    @SneakyThrows
    public void update(User user) {
        try (Connection connection = dataSource.getConnection()) {
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE User SET first_name = ?, " +
                             "last_name = ?, " +
                             "date_of_birth = ?, " +
                             "password = ?, " +
                             "status_on_wall = ?, " +
                             "city = ? " +
                             "WHERE id = ?");

            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setObject(4, user.getPasswordHash());
            preparedStatement.setObject(5, user.getStatusOnWall());
            preparedStatement.setObject(6, user.getCity());
            preparedStatement.setObject(7, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException("Ошибка при редактировании профиля, нет такого ID");
        }

    }


    @SneakyThrows
    @Override
    public void deleteUser(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM User WHERE id = ?"
             )){

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.commit();

        }
    }

    @Override
    @SneakyThrows
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "id, " +
                     "first_name, " +
                     "last_name, " +
                     "date_of_birth, " +
                     "access_level_id, " +
                     "email, " +
                     "password, " +
                     "profile_photo, " +
                     "status_on_wall, " +
                     "city FROM User")) {
            while (resultSet.next()) {

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);

                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth").toLocalDate(),
//                        resultSet.getInt("access_level_id"), -достанет только id
                        AccessLevel.valueOf(
                                resultSet.getInt("access_level_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого уровня доступа")),
                        resultSet.getString("email"),
                        resultSet.getString("password"),// todo вообще убрать вывод пароля?
                        // сделать отдельный кейс по проверке соответствия пользователя паролю?
                        resultSet.getBlob("profile_photo"),
                        resultSet.getString("status_on_wall"),
                        resultSet.getString("city")
                ));
            }
            return users;
        }
    }

//    @Override
//    @SneakyThrows
//    public List<User> getAllFriends() {
//        List<User> friends = new ArrayList<>();
//
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT " +
//                     "id, " +
//                     "first_name, " +
//                     "last_name, " +
//                     "date_of_birth, " +
//                     "access_level_id, " +
//                     "email, " +
//                     "password, " +
//                     "profile_photo, " +
//                     "status_on_wall, " +
//                     "city FROM User WHERE id <> 1")) {
//
//            while (resultSet.next()) {
//
//                //                Для выгрузки фотографий из базы данных при помощи временных файлов
////                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
////                h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);
//
//                friends.add(new User(
//                        resultSet.getInt("id"),
//                        resultSet.getString("first_name"),
//                        resultSet.getString("last_name"),
//                        resultSet.getDate("date_of_birth").toLocalDate(),
////                        resultSet.getInt("access_level_id"), -достанет только id
//                        AccessLevel.valueOf(
//                                resultSet.getInt("access_level_id") - 1)
//                                .orElseThrow(() -> new RuntimeException("нет такого уровня доступа")),
//                        resultSet.getString("email"),
//                        resultSet.getString("password"),// todo вообще убрать вывод пароля?
//                        // сделать отдельный кейс по проверке соответствия пользователя паролю?
//                        resultSet.getBlob("profile_photo"),
//                        resultSet.getString("status_on_wall"),
//                        resultSet.getString("city")
//                ));
//            }
//            return friends;
//        }
//    }


    @Override
    @SneakyThrows
    public List<User> getAllFriends(int userId) {
        List<User> friends = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id, " +
                     "first_name, " +
                     "last_name, " +
                     "date_of_birth, " +
                     "access_level_id, " +
                     "email, " +
                     "password, " +
                     "profile_photo, " +
                     "status_on_wall, " +
                     "city FROM User WHERE id <> ?")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                //                Для выгрузки фотографий из базы данных при помощи временных файлов
//                H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//                h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);

                friends.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth").toLocalDate(),
//                        resultSet.getInt("access_level_id"), -достанет только id
                        AccessLevel.valueOf(
                                resultSet.getInt("access_level_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого уровня доступа")),
                        resultSet.getString("email"),
                        resultSet.getString("password"),// todo вообще убрать вывод пароля?
                        // сделать отдельный кейс по проверке соответствия пользователя паролю?
                        resultSet.getBlob("profile_photo"),
                        resultSet.getString("status_on_wall"),
                        resultSet.getString("city")
                ));
            }
            return friends;
        }
    }


    @Override
    @SneakyThrows
    public User getUser() {

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "id, " +
                     "first_name, " +
                     "last_name, " +
                     "date_of_birth, " +
                     "access_level_id, " +
                     "email, " +
                     "password, " +
                     "profile_photo, " +
                     "status_on_wall, " +
                     "city " +
                     "FROM User " +
                     "WHERE id = 1")) {

            resultSet.next();

            //                Для выгрузки фотографий из базы данных при помощи временных файлов
//            H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//            h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);

            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("date_of_birth").toLocalDate(),
//                        resultSet.getInt("access_level_id"), -достанет только id
                    AccessLevel.valueOf(
                            resultSet.getInt("access_level_id") - 1)
                            .orElseThrow(() -> new RuntimeException("нет такого уровня доступа")),
                    resultSet.getString("email"),
                    resultSet.getString("password"),// todo вообще убрать вывод пароля?
                    // сделать отдельный кейс по проверке соответствия пользователя паролю?
                    resultSet.getBlob("profile_photo"),
                    resultSet.getString("status_on_wall"),
                    resultSet.getString("city")
            );

            return user;
        }
    }


    @Override
    @SneakyThrows
    public User getUser(int someUserId) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id, " +
                     "first_name, " +
                     "last_name, " +
                     "date_of_birth, " +
                     "access_level_id, " +
                     "email, " +
                     "password, " +
                     "profile_photo, " +
                     "status_on_wall, " +
                     "city " +
                     "FROM User " +
                     "WHERE id = ?")){

        preparedStatement.setInt(1, someUserId);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

            //                Для выгрузки фотографий из базы данных при помощи временных файлов
//            H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//            h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);

            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("date_of_birth").toLocalDate(),
//                        resultSet.getInt("access_level_id"), -достанет только id
                    AccessLevel.valueOf(
                            resultSet.getInt("access_level_id") - 1)
                            .orElseThrow(() -> new RuntimeException("нет такого уровня доступа")),
                    resultSet.getString("email"),
                    resultSet.getString("password"),// todo вообще убрать вывод пароля?
                    // сделать отдельный кейс по проверке соответствия пользователя паролю?
                    resultSet.getBlob("profile_photo"),
                    resultSet.getString("status_on_wall"),
                    resultSet.getString("city")
            );

            return user;
        }
    }


    @Override
    @SneakyThrows
    public User getUserTest(int someUserId) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id, " +
                     "first_name, " +
                     "last_name, " +
                     "email, " +
                     "password, " +
                     "status_on_wall, " +
                     "city " +
                     "FROM User " +
                     "WHERE id = ?")){

            preparedStatement.setInt(1, someUserId);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            //                Для выгрузки фотографий из базы данных при помощи временных файлов
//            H2SavePictureFromDatabase h2SavePictureFromDatabase = new H2SavePictureFromDatabase();
//            h2SavePictureFromDatabase.saveUserProfilePhotoFromDatabaseIntoFile(resultSet);

            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),// todo вообще убрать вывод пароля?
                    // сделать отдельный кейс по проверке соответствия пользователя паролю?
                    resultSet.getString("status_on_wall"),
                    resultSet.getString("city")
            );

            return user;
        }
    }


    @Override
    @SneakyThrows
    public int getUserId(String email) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "id FROM User WHERE email = ?")){

        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

                int userId = resultSet.getInt("id");

            return userId;
        }
    }


    @Override
    @SneakyThrows
    public InputStream transferUsersProfilePicture(int usersProfilePictureId) {
        InputStream is = null;

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT profile_photo FROM User WHERE id = ?") ) {
            preparedStatement.setInt(1, usersProfilePictureId);
            ResultSet usersProfilePicturePictureResultSet = preparedStatement.executeQuery();
            usersProfilePicturePictureResultSet.next();

            return usersProfilePicturePictureResultSet.getBinaryStream(1);
        }
    }


    @Override
    @SneakyThrows
    public void insertUploadedPictureIntoUserProfilePhoto(int id, Part filePart) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE User set profile_photo = ? WHERE id = ?"
             )){

            InputStream fileInputStream = filePart.getInputStream();
//            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/default_large.jpg");
//            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream, (int)filePart.getSize());
            preparedStatement.setObject(2, id);

            preparedStatement.executeUpdate();

            connection.commit();

        }

    }

}
