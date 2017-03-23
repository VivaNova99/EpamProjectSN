package model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class WallMessage {

    private int id;
    private User senderUserId;
    private User recieverUserId;
    private String text;
    private String picture;
    private LocalDateTime dateTime;
    private ForumTheme forumThemeId;
    private WallMessage parentMessageId;
    private MessageStatus status;

}
