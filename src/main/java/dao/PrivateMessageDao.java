package dao;

import lombok.SneakyThrows;
import model.PrivateMessage;

import java.util.Collection;
import java.util.Optional;


public interface PrivateMessageDao {
    int save();
    default Optional<PrivateMessage> get(int id){
        return getAll().stream()
                .filter(privateMessage -> privateMessage.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<PrivateMessage> getAll();

    Collection<PrivateMessage> getMyPrivateMessages();

    Collection<PrivateMessage> getMyPrivateMessages(int userId);
}
