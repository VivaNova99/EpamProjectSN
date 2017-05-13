package dao;

import lombok.SneakyThrows;
import model.User;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

/**
 * Created by veraivanova on 16.03.17.
 */
public interface UserDao {
    // CRUD + getAll - стандартный контракт

    int create(User user);
    default Optional<User> get(int id) {
        return getAll().stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }; // для продакшна эта дефолтовая реализация не годится, нужно переопределять,
    // а для предварительной работы можно, метод-заглушка.
    // Если юзера с таким id нет, то без Optional упадет метод get()
//    update(User user); - есть ли смысл апдейтить всего юзера, если нужно апдейтить одно поле
    void remove(User user); //удаление в базе той сущности, которая соответствует данному объекту,
    // объект остается

    List<User> getAll();

    List<User> getAllFriends();

    User getUser();

    User getUser(int someUserId);

    int getUserId(String userLogin);

    ResultSet transferUsersProfilePicture(int usersProfilePictureId);
}
