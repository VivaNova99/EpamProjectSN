package model;

import lombok.Value;

@Value
public class PrivateMessages {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private int senderUserId;
//    sender_user_id int NOT NULL,
    private int recieverUserId;
//    reciever_user_id int NOT NULL,
    private String text;
//    text VARCHAR(160) NOT NULL,
    private
//    date_time DATETIME NOT NULL,
    private int status;
//    status INT,
//
//    FOREIGN KEY (sender_user_id) REFERENCES User(id),
//    FOREIGN KEY (reciever_user_id) REFERENCES User(id),
//    FOREIGN KEY (status) REFERENCES MessagesStatus(id)
}
