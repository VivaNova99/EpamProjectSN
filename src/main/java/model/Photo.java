package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Photo {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private User user;
//    private int userId;
//    user_id INT NOT NULL,
    private PhotoAlbum photoAlbum;
//    private int albumId;
//    album_id INT,
    private String picture;
//    picture VARCHAR(100) NOT NULL,
    private String description;
//    description VARCHAR(100),
    private Date dateTime;
//    date_time DATETIME NOT NULL,
    private PhotoStatus status;


//    status_id INT,
//
//    FOREIGN KEY (user_id) REFERENCES User(id),
//    FOREIGN KEY (album_id) REFERENCES PhotoAlbum(id),
//    FOREIGN KEY (status_id) REFERENCES PhotoStatus(id)

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

