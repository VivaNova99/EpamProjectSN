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
public class PhotoAlbum {

    private int id;
    private String name;
    private User user;
    private String albumPicture;
    private String description;
    private Date dateTime;
    private PhotoStatus status;

    public PhotoAlbum(String name) {

        this.name = name;
    }

    public String getUserFirstNameAndLastName(){

        return user.getFirstNameAndLastName();

    }
}
