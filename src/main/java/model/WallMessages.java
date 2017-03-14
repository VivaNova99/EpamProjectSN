package model;

import lombok.Value;

@Value
public class WallMessages {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private int senderUserId;
//    sender_user_id int NOT NULL,
    private int recieverUserId;
//    reciever_user_id int NOT NULL,
    private String text;
//    text VARCHAR(500) NOT NULL,
    private String picture;
//    picture VARCHAR(100) NOT NULL,
    private
//    date_time DATETIME NOT NULL,
    private int forumThemesId;
//    forum_themes_id INT,
    private int parentMessageId;
//    parent_message_id INT,
    private int status;
//    status INT,
//
//    FOREIGN KEY (parent_message_id) REFERENCES WallMessages(id),
//    FOREIGN KEY (status) REFERENCES MessagesStatus(id)
//    FOREIGN KEY (forum_themes_id) REFERENCES ForumThemes(id)
}
