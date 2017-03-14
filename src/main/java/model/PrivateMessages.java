package model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PrivateMessages {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private User senderUser;
//    private int senderUserId;
//    sender_user_id int NOT NULL,
    private User recieverUser;
//    private int recieverUserId;
//    reciever_user_id int NOT NULL,
    private String text;
//    text VARCHAR(160) NOT NULL,
    private LocalDateTime dateTime;
//    date_time DATETIME NOT NULL,
    private MessagesStatus status;
//    status_id INT,
//
//    FOREIGN KEY (sender_user_id) REFERENCES User(id),
//    FOREIGN KEY (reciever_user_id) REFERENCES User(id),
//    FOREIGN KEY (status) REFERENCES MessagesStatus(id)
}
