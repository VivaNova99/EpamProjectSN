package dao;

import model.ForumThemes;
import model.Photo;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by veraivanova on 18.03.17.
 */
public interface PhotoDao {
    int save();
    default Optional<Photo> get(int id){
        return getAll().stream()
                .filter(photo -> photo.getId() == id)
                .findAny();
    };
    // update - если понадобится, делать отдельные апдейты по отдельным полям
    void remove(int id);

    Collection<Photo> getAll();
}
