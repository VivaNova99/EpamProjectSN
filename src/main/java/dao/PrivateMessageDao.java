package dao;

import lombok.SneakyThrows;
import model.MessageStatus;
import model.PrivateMessage;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;


public interface PrivateMessageDao {
//    int save();
//    default Optional<PrivateMessage> get(int id){
//        return getAll().stream()
//                .filter(privateMessage -> privateMessage.getId() == id)
//                .findAny();
//    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<PrivateMessage> getAll();

    Collection<PrivateMessage> getMyPrivateMessages();

    Collection<PrivateMessage> getMyPrivateMessages(int userId);

    void create(int senderUserId, int receiverUserId, String text, Timestamp timestamp, MessageStatus privateMessageStatus);
}
