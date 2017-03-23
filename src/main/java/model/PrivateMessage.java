package model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PrivateMessage {

    private int id;
    private User senderUser;
    private User recieverUser;
    private String text;
    private LocalDateTime dateTime;
    private MessageStatus status;

}
