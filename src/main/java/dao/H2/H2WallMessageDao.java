package dao.H2;

import dao.WallMessageDao;
import lombok.SneakyThrows;
import model.*;

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
 * Created by veraivanova on 23.03.17.
 */
public class H2WallMessageDao implements WallMessageDao {
    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    public H2WallMessageDao(DataSource dataSource) {
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
    public Collection<WallMessage> getAll() {
        List<WallMessage> wallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "wm.text as message_text, " +
                     "wm.picture," +
                     "wm.date_time, " +
                     "wm.forum_theme_id, " +
                     "wm.message_header, " +
                     "ft.name," +
                     "wm.is_parent, " +
                     "wm.parent_message_id, " +
                     "wmparent.id, " +
                     "wmparent.text as parent_message_text, " +
                     "wm.status_id " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                wallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getString("picture"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        new ForumTheme(
                                resultSet.getString("name")
                        ),
                        resultSet.getString("message_header"),
                        resultSet.getBoolean("is_parent"),
                        new WallMessage(
                                resultSet.getString("parent_message_text")
                        ),
                        MessageStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return wallMessages;
        }
    }

    @Override
    @SneakyThrows
    public Collection<WallMessage> getLast10() {
        List<WallMessage> last10WallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.first_name, " +
                     "u.last_name, " +
                     "wm.text as message_text, " +
                     "wm.picture," +
                     "wm.date_time, " +
                     "wm.forum_theme_id, " +
                     "wm.message_header, " +
                     "ft.name," +
                     "wm.is_parent, " +
                     "wm.parent_message_id, " +
                     "wmparent.id, " +
                     "wmparent.text as parent_message_text, " +
                     "wm.status_id " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id " +
                     "ORDER BY date_time DESC LIMIT 10")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                last10WallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getString("picture"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        new ForumTheme(
                                resultSet.getString("name")
                        ),
                        resultSet.getString("message_header"),
                        resultSet.getBoolean("is_parent"),
                        new WallMessage(
                                resultSet.getString("parent_message_text")
                        ),
                        MessageStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return last10WallMessages;
        }
    }
}
