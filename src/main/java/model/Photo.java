package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Photo {

    private int id;
    private User user;
    private PhotoAlbum photoAlbum;
    private String picture;
    private String description;
    private Date dateTime;
    private PhotoStatus status;


    public int getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public PhotoStatus getStatus() {
        return status;
    }

    public String getUserFirstNameAndLastName(){
        return user.getFirstNameAndLastName();
    }

    public String getPhotoAlbumName(){
        return photoAlbum.getName();
    }

}

