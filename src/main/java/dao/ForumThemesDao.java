package dao;

import model.ForumThemes;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by veraivanova on 16.03.17.
 */
public interface ForumThemesDao {
    int save(); //вместо create, а в Hibernate такой метод называется persist
    default Optional<ForumThemes> get(int id){
        return getAll().stream()
                .filter(forumThemes -> forumThemes.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<ForumThemes> getAll();
}
