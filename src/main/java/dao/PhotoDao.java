package dao;

import model.Photo;

import java.util.Collection;
import java.util.Optional;


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

    Collection<Photo> getLast5();

    Collection<Photo> getUserPhotos();

}
