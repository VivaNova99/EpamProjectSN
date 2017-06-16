package dao;

import lombok.SneakyThrows;
import model.ForumTheme;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by veraivanova on 16.03.17.
 */
public interface ForumThemeDao {
    int save(); //вместо create, а в Hibernate такой метод называется persist
    default Optional<ForumTheme> get(int id){
        return getAll().stream()
                .filter(forumTheme -> forumTheme.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<ForumTheme> getAll();

    @SneakyThrows
    Collection<ForumTheme> getAllForumThemeNames();

    @SneakyThrows
    int getForumThemeId(String forumThemeName);
}
