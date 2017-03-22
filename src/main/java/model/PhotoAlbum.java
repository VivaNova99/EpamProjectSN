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
public class PhotoAlbum {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private String name;
//    name VARCHAR(50) NOT NULL,
    private User user;
//    private int userId;
//    user_id INT NOT NULL,
    private String albumPicture;
//    album_picture VARCHAR(100) NOT NULL,
    private String description;
//    description VARCHAR(100),
//    private LocalDateTime dateTime;
    private Date dateTime;
//    date_time DATETIME NOT NULL,
    private PhotoStatus status;

    public PhotoAlbum(String name) {
    }


//    status_id INT,
//
//    FOREIGN KEY (user_id) REFERENCES User(id),
//    FOREIGN KEY (status) REFERENCES PhotoStatus(id)

    public String getUserFirstNameAndLastName(){
        return user.getFirstNameAndLastName();
    }
}
