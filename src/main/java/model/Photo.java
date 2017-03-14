package model;

import lombok.Value;

@Value
public class Photo {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private int userId;
//    user_id INT NOT NULL,
    private int albumId;
//    album_id INT,
    private String picture;
//    picture VARCHAR(100) NOT NULL,
    private String description;
//    description VARCHAR(100),
    private
//    date_time DATETIME NOT NULL,
    private int status;
//    status INT,
//
//    FOREIGN KEY (user_id) REFERENCES User(id),
//    FOREIGN KEY (album_id) REFERENCES PhotoAlbum(id),
//    FOREIGN KEY (status) REFERENCES PhotoStatus(id)
}
