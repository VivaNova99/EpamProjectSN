package tags;

import lombok.Setter;
import model.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;


public class regUserAllFriends extends TagSupport {

    @Setter
    private Collection<User> friends;

    private Iterator<User> userIterator;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        for (User friend: friends) {
            try {
                out.print("<li>" +
                "<ul>" +
                    "<li><a href=\"smb-page?some_user_id=" + friend.getId() + "\"><img src=\"users_profile_picture?user_id=" + friend.getId() + "\" /></a></li>" +
                    "<li class=\"name\"><a href=\"smb-page?some_user_id=" + friend.getId() + "\"" + ">" + friend.getFirstName() + " " + friend.getLastName() + "</a></li>" +
                    "<li>" + friend.getStatusOnWall() + "</li>" +
                "</ul>" +
            "</li>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return SKIP_BODY;
    }

}
