package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class WallMessage {

    private int id;
    private User senderUser;
    private String text;
    private String picture;
    private Date dateTime;
    private ForumTheme forumTheme;
    private boolean parent;
    private WallMessage parentMessage;
    private MessageStatus status;

    public WallMessage(String text) {
        this.text = text;
    }

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
}


