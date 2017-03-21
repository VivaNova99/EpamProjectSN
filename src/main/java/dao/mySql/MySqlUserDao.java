package dao.mySql;

import dao.UserDao;
import lombok.SneakyThrows;
import model.AccessLevel;
import model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by veraivanova on 16.03.17.
 */
public class MySqlUserDao implements UserDao {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;


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

            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getDateOfBirth());
            preparedStatement.setObject(4, user.getAccessLevel().ordinal()+1);
            //т.к. ordinal с нуля, а у нас база с автоинкрементом (у меня - не автоинкремент!)
            // TODO - переделать ordinal на спец. поле
            preparedStatement.setObject(5, user.getEmail());
            preparedStatement.setObject(6, user.getPasswordHash());
            preparedStatement.setObject(7, user.getProfilePhoto());
            preparedStatement.setObject(8, user.getStatusOnWall());
            preparedStatement.setObject(9, user.getCity());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Ошибка при создании профиля, нет такого ID");
                }
            }
        }

        return user.getId();
    }

    @Override
    public void remove(User user) {

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
            while (resultSet.next()){
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
                        resultSet.getString("profile_photo"),
                        resultSet.getString("status_on_wall"),
                        resultSet.getString("city")
                        ));
            }
            return users;
        }
    }
}
