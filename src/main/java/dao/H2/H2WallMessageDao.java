package dao.H2;

import dao.WallMessageDao;
import lombok.SneakyThrows;
import model.*;

import javax.annotation.Resource;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
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
    @SneakyThrows
    public void createWithUserPicture(int senderUserId, String text, Part filePart, Timestamp timestamp,
                                      int forumThemeId, String messageHeader, boolean isParent, int parentMessageId, MessageStatus messageStatus) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO WallMessage (" +
                             "sender_user_id, " +
                             "text, " +
                             "picture, " +
                             "date_time, " +
                             "forum_theme_id, " +
                             "message_header, " +
                             "is_parent, " +
                             "parent_message_id, " +
                             "status_id) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

//            // Для вставки фото профиля
//            File file = new File("/Users/veraivanova/IdeaProjects/EpamProjectSN/src/main/webapp/img/default_large.jpg");
//            FileInputStream fileInputStream = new FileInputStream(file);

            InputStream fileInputStream = filePart.getInputStream();

            preparedStatement.setObject(1, senderUserId);
            preparedStatement.setObject(2, text);
            preparedStatement.setBinaryStream(3, fileInputStream, (int)filePart.getSize());
            preparedStatement.setObject(4, timestamp);
            preparedStatement.setObject(5, forumThemeId);
            preparedStatement.setObject(6, messageHeader);
            preparedStatement.setObject(7, isParent);
            preparedStatement.setObject(8, parentMessageId);
            preparedStatement.setObject(9, messageStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();
            }
        }


    @Override
    @SneakyThrows
    public void createWithoutPicture(int senderUserId, String text, Timestamp timestamp,
                                     int forumThemeId, String messageHeader, boolean isParent, int parentMessageId, MessageStatus messageStatus) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO WallMessage (" +
                             "sender_user_id, " +
                             "text, " +
                             "date_time, " +
                             "forum_theme_id, " +
                             "message_header, " +
                             "is_parent, " +
                             "parent_message_id, " +
                             "status_id) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setObject(1, senderUserId);
            preparedStatement.setObject(2, text);
            preparedStatement.setObject(3, timestamp);
            preparedStatement.setObject(4, forumThemeId);
            preparedStatement.setObject(5, messageHeader);
            preparedStatement.setObject(6, isParent);
            preparedStatement.setObject(7, parentMessageId);
            preparedStatement.setObject(8, messageStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();
        }
    }


    @Override
    @SneakyThrows
    public void createForumAnswer(int senderUserId, String text, Timestamp timestamp, int forumThemeId,
                                  boolean isParent, int parentMessageId, MessageStatus messageStatus) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO WallMessage (" +
                             "sender_user_id, " +
                             "text, " +
                             "date_time, " +
                             "forum_theme_id, " +
                             "is_parent, " +
                             "parent_message_id, " +
                             "status_id) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setObject(1, senderUserId);
            preparedStatement.setObject(2, text);
            preparedStatement.setObject(3, timestamp);
            preparedStatement.setObject(4, forumThemeId);
            preparedStatement.setObject(5, isParent);
            preparedStatement.setObject(6, parentMessageId);
            preparedStatement.setObject(7, messageStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();
        }
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
                     "u.profile_photo, " +
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
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
                     "u.profile_photo, " +
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
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
    public Collection<WallMessage> getLast10(int userId) {
        List<WallMessage> last10WallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
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
                     "WHERE wm.sender_user_id <> ? AND wm.id <> 1 AND wm.parent_message_id = 1 " +
                     "ORDER BY date_time DESC LIMIT 10")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                last10WallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
                     "u.profile_photo, " +
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
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
    public Collection<WallMessage> getMyAnswers(int userId) {
        List<WallMessage> myAnswersWallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
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
                     "WHERE wm.is_parent = FALSE AND wmparent.sender_user_id = ?")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myAnswersWallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
    public Collection<WallMessage> getThisForumTheme(int thisForumThemeOrder) {
        List<WallMessage> thisThemeWallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
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
                     "WHERE ft.theme_order = ? AND wm.parent_message_id = 1 " +
                     "ORDER BY date_time DESC LIMIT 50")) {

                preparedStatement.setInt(1, thisForumThemeOrder);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    thisThemeWallMessages.add(new WallMessage(
                            resultSet.getInt("id"),
                            new User(
                                    resultSet.getInt("sender_user_id"),
                                    resultSet.getBlob("profile_photo"),
                                    resultSet.getString("first_name"),
                                    resultSet.getString("last_name")
                            ),
                            resultSet.getString("message_text"),
                            resultSet.getBlob("picture"),
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
    public Collection<WallMessage> getThisForumTopic(int thisForumTopicId) {
        List<WallMessage> thisTopicWallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
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
                     "WHERE wm.id = ? OR wm.parent_message_id = ? " +
                     "ORDER BY date_time ASC")) {

            preparedStatement.setInt(1, thisForumTopicId);
            preparedStatement.setInt(2, thisForumTopicId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                thisTopicWallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
                     "u.profile_photo, " +
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
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
    public Collection<WallMessage> getLast10ForUser(int someUserId) {
        List<WallMessage> last10ForUserWallMessages = new ArrayList<>();

        //        TODO: добавить try with resources

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "wm.id, " +
                "wm.sender_user_id, " +
                "u.id, " +
                "u.profile_photo, " +
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
                "WHERE wm.sender_user_id = ? AND wm.id <> 1 AND wm.parent_message_id = 1 " +
                "ORDER BY date_time DESC LIMIT 10");
        preparedStatement.setInt(1, someUserId);
        ResultSet resultSet = preparedStatement.executeQuery();

        {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                last10ForUserWallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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
                     "u.profile_photo, " +
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
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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


    @Override
    @SneakyThrows
    public Collection<WallMessage> getMyThemes(int userId) {
        List<WallMessage> myThemesWallMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "wm.id, " +
                     "wm.sender_user_id, " +
                     "u.id, " +
                     "u.profile_photo, " +
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
                     "WHERE wm.is_parent = TRUE AND wm.sender_user_id = ?")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myThemesWallMessages.add(new WallMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("profile_photo"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        ),
                        resultSet.getString("message_text"),
                        resultSet.getBlob("picture"),
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


    @Override
    @SneakyThrows
    public int getForumThemeId(int thisForumTopicId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT forum_theme_id FROM WallMessage WHERE id = ?")){
            preparedStatement.setInt(1, thisForumTopicId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("forum_theme_id");
        }
    };


    @Override
    @SneakyThrows
    public ResultSet transferWallMessagePicture(int wallMessagePictureId) {

//        TODO: добавить try with resources

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT picture FROM WallMessage WHERE id = ?");
        preparedStatement.setInt(1, wallMessagePictureId);
        ResultSet wallMessagePictureResultSet = preparedStatement.executeQuery();
        wallMessagePictureResultSet.next();

        return wallMessagePictureResultSet;

    }


}
