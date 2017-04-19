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
                     "WHERE wm.sender_user_id <> 1 AND wm.id <> 1 AND wm.parent_message_id = 1 " +
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


    @Override
    @SneakyThrows
    public Collection<WallMessage> getMyAnswers() {
        List<WallMessage> myAnswersWallMessages = new ArrayList<>();

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
                     "wmparent.sender_user_id," +
                     "wmparent.text as parent_message_text, " +
                     "wm.status_id " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id " +
                     "WHERE wm.is_parent = FALSE AND wmparent.sender_user_id = 1")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myAnswersWallMessages.add(new WallMessage(
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
            return myAnswersWallMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<WallMessage> getThisForumTheme() {
        List<WallMessage> thisThemeWallMessages = new ArrayList<>();

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
                     "wm.status_id, " +
                     "ft.theme_order " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id " +
                     "WHERE ft.theme_order = 310 AND wm.parent_message_id = 1 " +
                     "ORDER BY date_time DESC LIMIT 50")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                thisThemeWallMessages.add(new WallMessage(
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
            return thisThemeWallMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<WallMessage> getThisForumTopic() {
        List<WallMessage> thisTopicWallMessages = new ArrayList<>();

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
                     "wm.status_id, " +
                     "ft.theme_order " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id " +
                     "WHERE wm.id = 4 OR wm.parent_message_id = 4 " +
                     "ORDER BY date_time ASC")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                thisTopicWallMessages.add(new WallMessage(
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
            return thisTopicWallMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<WallMessage> getLast10ForUser() {
        List<WallMessage> last10ForUserWallMessages = new ArrayList<>();

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
                     "WHERE wm.sender_user_id = 1 AND wm.id <> 1 AND wm.parent_message_id = 1 " +
                     "ORDER BY date_time DESC LIMIT 10")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                last10ForUserWallMessages.add(new WallMessage(
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
            return last10ForUserWallMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<WallMessage> getMyThemes() {
        List<WallMessage> myThemesWallMessages = new ArrayList<>();

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
                     "wmparent.sender_user_id," +
                     "wmparent.text as parent_message_text, " +
                     "wm.status_id " +
                     "FROM WallMessage wm " +
                     "JOIN User u ON wm.sender_user_id = u.id " +
                     "JOIN ForumTheme ft ON wm.forum_theme_id = ft.id " +
                     "JOIN WallMessage wmparent ON wm.parent_message_id = wmparent.id " +
                     "WHERE wm.is_parent = TRUE AND wm.sender_user_id = 1")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myThemesWallMessages.add(new WallMessage(
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
            return myThemesWallMessages;
        }
    }


}
