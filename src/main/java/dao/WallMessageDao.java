package dao;

import model.WallMessage;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by veraivanova on 23.03.17.
 */
public interface WallMessageDao {
    int save();
    default Optional<WallMessage> get(int id){
        return getAll().stream()
                .filter(wallMessage -> wallMessage.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<WallMessage> getAll();

    Collection<WallMessage> getLast10();

    Collection<WallMessage> getMyAnswers();

    Collection<WallMessage> getThisForumTheme();

    Collection<WallMessage> getThisForumTopic();

    Collection<WallMessage> getLast10ForUser();

    Collection<WallMessage> getMyThemes();

}
