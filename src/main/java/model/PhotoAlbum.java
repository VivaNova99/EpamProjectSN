package model;

import lombok.Value;

@Value
public class PhotoAlbum {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private String name;
//    name VARCHAR(50) NOT NULL,
    private int userId;
//    user_id INT NOT NULL,
    private String albumPicture;
//    album_picture VARCHAR(100) NOT NULL,
    private String description;
//    description VARCHAR(100),
    private
//    date_time DATETIME NOT NULL,
    private int status;
//    status INT,
//
//    FOREIGN KEY (user_id) REFERENCES User(id),
//    FOREIGN KEY (status) REFERENCES PhotoStatus(id)
}
