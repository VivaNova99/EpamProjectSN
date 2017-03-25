package dao.H2;

import dao.PrivateMessageDao;
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
public class H2PrivateMessageDao implements PrivateMessageDao {

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    public H2PrivateMessageDao(DataSource dataSource) {
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
    public Collection<PrivateMessage> getAll() {
        List<PrivateMessage> privateMessages = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     "pm.id, " +
                     "pm.sender_user_id, " +
                     "u1.id, " +
                     "u1.first_name as sender_first_name, " +
                     "u1.last_name as sender_last_name, " +
                     "pm.receiver_user_id," +
                     "u2.id, " +
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
                                resultSet.getString("sender_first_name"),
                                resultSet.getString("sender_last_name")
                        ),
                        new User(
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
}
