package servlets;

import dao.ForumThemeDao;
import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;
import model.MessageStatus;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import static java.lang.Integer.parseInt;


@WebServlet("/answer_forum_message")
@MultipartConfig
public class AnswerOnForumWallMessage extends HttpServlet {

//    public static final String USER_INFO_KEY = "UserInfo";
//    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
//    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";
    public static final String THIS_TOPIC_WALL_MESSAGES_KEY = "ThisTopicWallMessages";

//    private UserDao userDao;
//    private PhotoDao photoDao;
    private WallMessageDao wallMessageDao;
    private ForumThemeDao forumThemeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = String.valueOf(session.getAttribute("email"));

        String userIdString = String.valueOf(session.getAttribute("user_id"));
        int senderUserId = parseInt(userIdString);

//        if ((userIdString == null) | (userIdString.equals("null"))){
//            senderUserId = userDao.getUserId(email);
//        }
//
//        else {
//            userIdString = String.valueOf(session.getAttribute("user_id"));
//            senderUserId = parseInt(userIdString);
//        }

        String text = request.getParameter("forum_message_text");

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        String forumThemeIdString = request.getParameter("forum_theme_id");
        int forumThemeId = parseInt(forumThemeIdString);

//        String forumThemeName = request.getParameter("forum_theme_name");
//        int forumThemeId = forumThemeDao.getForumThemeId(forumThemeName);

//        String messageHeader = request.getParameter("wall_message_header");

        Boolean isParent = false;

        String parentMessageIdString = request.getParameter("parent_message_id");
        int parentMessageId = parseInt(parentMessageIdString);

        MessageStatus messageStatus = MessageStatus.STANDARD;

//        Part filePart = request.getPart("upfile");

        wallMessageDao.createForumAnswer(senderUserId, text, timestamp, forumThemeId, isParent, parentMessageId, messageStatus);

        request.setAttribute(THIS_TOPIC_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTopic(parentMessageId));
        request.setAttribute("parent_message_id", parentMessageId);
        request.setAttribute("forum_theme_id", forumThemeId);

        System.out.println("In AnswerOnForumWallMessage: user_id - " + session.getAttribute("user_id") + ", " +
                "email - " + session.getAttribute("email") + ", " +
                "parent_message_id - " + request.getParameter("parent_message_id") + ", " +
                "text - " + request.getParameter("forum_message_text"));

        request.getRequestDispatcher("/reg-user-forum-this-topic.jsp").forward(request, response);

    }

}
