package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PrivateMessage {

    private int id;
    private User senderUser;
    private User receiverUser;
    private String text;
    private Date dateTime;
    private MessageStatus status;

    public int getId() {
        return id;
    }

    public String getDateTime() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy hh:mm").format(this.dateTime);
        }
        catch (NullPointerException e) {
            return "Дата и время не определены";
        }
    }

    public int getSenderUserId() { return senderUser.getId(); }

    public int getReceiverUserId() { return receiverUser.getId(); }

    public String getSenderUserFirstNameAndLastName(){
        return senderUser.getFirstNameAndLastName();
    }

    public String getReceiverUserFirstNameAndLastName(){
        return receiverUser.getFirstNameAndLastName();
    }

}
