package dao;

import lombok.SneakyThrows;
import model.MessageStatus;
import model.WallMessage;

import javax.servlet.http.Part;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by veraivanova on 23.03.17.
 */
public interface WallMessageDao {

//    int save();
//    default Optional<WallMessage> get(int id){
//        return getAll().stream()
//                .filter(wallMessage -> wallMessage.getId() == id)
//                .findAny();
//    };


//    int createWithUserPicture(WallMessage wallMessage);

    void createWithUserPicture(int senderUserId, String text, Part filePart, Timestamp timestamp, int forumThemeId, String messageHeader, boolean isParent, int parentMessageId, MessageStatus messageStatus);

    @SneakyThrows
    void createWithoutPicture(int senderUserId, String text, Timestamp timestamp,
                              int forumThemeId, String messageHeader, boolean isParent, int parentMessageId, MessageStatus messageStatus);

    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<WallMessage> getAll();

    Collection<WallMessage> getLast10();

    Collection<WallMessage> getLast10(int userId);

    Collection<WallMessage> getMyAnswers();

    Collection<WallMessage> getMyAnswers(int userId);

    Collection<WallMessage> getThisForumTheme(int thisForumThemeOrder);

    Collection<WallMessage> getThisForumTopic(int thisForumTopicId);

    Collection<WallMessage> getLast10ForUser();

    Collection<WallMessage> getLast10ForUser(int someUserId);

    Collection<WallMessage> getMyThemes();

    Collection<WallMessage> getMyThemes(int userId);

    ResultSet transferWallMessagePicture(int wallMessagePictureId);
}
