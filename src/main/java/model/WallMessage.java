package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class WallMessage {

    private int id;
    private User senderUser;
    private String text;
    private Blob picture;
    private Date dateTime;
    private ForumTheme forumTheme;
    private String messageHeader;
    private boolean parent;
    private WallMessage parentMessage;
    private MessageStatus status;

    public WallMessage(String text) {
        this.text = text;
    }

    public WallMessage(int id, User user, String message_text, Blob picture, Date date_time, ForumTheme name, String message_header, boolean is_parent, WallMessage wallMessage, MessageStatus messageStatus) {
    }

    public String getDateTime() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy hh:mm").format(this.dateTime);
        }
        catch (NullPointerException e) {
            return "Дата и время не определены";
        }
    }

    private String senderUserFirstNameAndLastName;

    public int getSenderUserId() { return senderUser.getId(); }

    public String getSenderUserFirstNameAndLastName(){
        return senderUser.getFirstNameAndLastName();
    }

    public String getForumThemeName() {
        return forumTheme.getName();
    }

    public String getParentMessageText() {
        return parentMessage.getText();
    }

    public boolean getParent() {
        return parent;
    }

    public void setSenderUserFirstNameAndLastName(String senderUserFirstNameAndLastName) {
        this.senderUserFirstNameAndLastName = senderUserFirstNameAndLastName;
    }
}


