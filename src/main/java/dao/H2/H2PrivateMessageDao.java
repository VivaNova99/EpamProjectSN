package dao.H2;

import dao.PrivateMessageDao;
import lombok.SneakyThrows;
import model.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by veraivanova on 23.03.17.
 */
public class H2PrivateMessageDao implements PrivateMessageDao {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    public H2PrivateMessageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//    @Override
//    public int save() {
//        return 0;
//    }

    @Override
    @SneakyThrows
    public void create(int senderUserId, int receiverUserId, String text, Timestamp timestamp, MessageStatus privateMessageStatus){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO PrivateMessage (" +
                             "sender_user_id, " +
                             "receiver_user_id," +
                             "text, " +
                             "date_time, " +
                             "status_id) " +
                             "VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setObject(1, senderUserId);
            preparedStatement.setObject(2, receiverUserId);
            preparedStatement.setObject(3, text);
            preparedStatement.setObject(4, timestamp);
            preparedStatement.setObject(5, privateMessageStatus.ordinal() + 1);

            preparedStatement.executeUpdate();

            connection.commit();
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    @SneakyThrows
    public Collection<PrivateMessage> getAll() {
        List<PrivateMessage> privateMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "pm.id, " +
                     "pm.sender_user_id, " +
                     "u1.id as sender_user_id, " +
                     "u1.profile_photo as sender_profile_photo, " +
                     "u1.first_name as sender_first_name, " +
                     "u1.last_name as sender_last_name, " +
                     "pm.receiver_user_id," +
                     "u2.id as receiver_user_id, " +
                     "u2.profile_photo as receiver_profile_photo, " +
                     "u2.first_name as receiver_first_name, " +
                     "u2.last_name as receiver_last_name, " +
                     "text," +
                     "date_time, " +
                     "status_id " +
                     "FROM PrivateMessage pm " +
                     "JOIN User u1 ON pm.sender_user_id = u1.id " +
                     "JOIN User u2 ON pm.receiver_user_id = u2.id ")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                privateMessages.add(new PrivateMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("sender_profile_photo"),
                                resultSet.getString("sender_first_name"),
                                resultSet.getString("sender_last_name")
                        ),
                        new User(
                                resultSet.getInt("receiver_user_id"),
                                resultSet.getBlob("receiver_profile_photo"),
                                resultSet.getString("receiver_first_name"),
                                resultSet.getString("receiver_last_name")
                        ),
                        resultSet.getString("text"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        MessageStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return privateMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<PrivateMessage> getMyPrivateMessages() {
        List<PrivateMessage> myPrivateMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "pm.id, " +
                     "pm.sender_user_id, " +
                     "u1.id as sender_user_id, " +
                     "u1.profile_photo as sender_profile_photo, " +
                     "u1.first_name as sender_first_name, " +
                     "u1.last_name as sender_last_name, " +
                     "pm.receiver_user_id," +
                     "u2.id as receiver_user_id, " +
                     "u2.profile_photo as receiver_profile_photo, " +
                     "u2.first_name as receiver_first_name, " +
                     "u2.last_name as receiver_last_name, " +
                     "text," +
                     "date_time, " +
                     "status_id " +
                     "FROM PrivateMessage pm " +
                     "JOIN User u1 ON pm.sender_user_id = u1.id " +
                     "JOIN User u2 ON pm.receiver_user_id = u2.id " +
                     "WHERE pm.sender_user_id = 1 OR pm.receiver_user_id = 1 " +
                     "ORDER BY date_time DESC")) {
            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myPrivateMessages.add(new PrivateMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("sender_profile_photo"),
                                resultSet.getString("sender_first_name"),
                                resultSet.getString("sender_last_name")
                        ),
                        new User(
                                resultSet.getInt("receiver_user_id"),
                                resultSet.getBlob("receiver_profile_photo"),
                                resultSet.getString("receiver_first_name"),
                                resultSet.getString("receiver_last_name")
                        ),
                        resultSet.getString("text"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        MessageStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return myPrivateMessages;
        }
    }


    @Override
    @SneakyThrows
    public Collection<PrivateMessage> getMyPrivateMessages(int userId) {
        List<PrivateMessage> myPrivateMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                     "pm.id, " +
                     "pm.sender_user_id, " +
                     "u1.id as sender_user_id, " +
                     "u1.profile_photo as sender_profile_photo, " +
                     "u1.first_name as sender_first_name, " +
                     "u1.last_name as sender_last_name, " +
                     "pm.receiver_user_id," +
                     "u2.id as receiver_user_id, " +
                     "u2.profile_photo as receiver_profile_photo, " +
                     "u2.first_name as receiver_first_name, " +
                     "u2.last_name as receiver_last_name, " +
                     "text," +
                     "date_time, " +
                     "status_id " +
                     "FROM PrivateMessage pm " +
                     "JOIN User u1 ON pm.sender_user_id = u1.id " +
                     "JOIN User u2 ON pm.receiver_user_id = u2.id " +
                     "WHERE pm.sender_user_id = ? OR pm.receiver_user_id = ? " +
                     "ORDER BY date_time DESC")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                myPrivateMessages.add(new PrivateMessage(
                        resultSet.getInt("id"),
                        new User(
                                resultSet.getInt("sender_user_id"),
                                resultSet.getBlob("sender_profile_photo"),
                                resultSet.getString("sender_first_name"),
                                resultSet.getString("sender_last_name")
                        ),
                        new User(
                                resultSet.getInt("receiver_user_id"),
                                resultSet.getBlob("receiver_profile_photo"),
                                resultSet.getString("receiver_first_name"),
                                resultSet.getString("receiver_last_name")
                        ),
                        resultSet.getString("text"),
                        simpleFormatter.parse(resultSet.getString("date_time")),
                        MessageStatus.valueOf(
                                resultSet.getInt("status_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такого статуса"))
                ));
            }
            return myPrivateMessages;
        }
    }



}
