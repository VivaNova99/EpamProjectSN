package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PrivateMessage {

    private int id;
    private User senderUser;
    private User recieverUser;
    private String text;
    private Date dateTime;
    private MessageStatus status;

    public int getId() {
        return id;
    }

    public String getSenderUserFirstNameAndLastName(){
        return senderUser.getFirstNameAndLastName();
    }

    public String getRecieverUserFirstNameAndLastName(){
        return recieverUser.getFirstNameAndLastName();
    }

}
