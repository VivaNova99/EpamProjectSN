package servlets;

import dao.*;
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


@WebServlet("/create_private_message")
@MultipartConfig
public class CreatePrivateMessage extends HttpServlet {

//    public static final String USER_INFO_KEY = "UserInfo";
//    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
//    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

//    public static final String MY_PRIVATE_MESSAGES_KEY = "UserPrivateMessages";

//    private UserDao userDao;
//    private PhotoDao photoDao;
//    private WallMessageDao wallMessageDao;
//    private ForumThemeDao forumThemeDao;

    private PrivateMessageDao privateMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
//        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
//        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int senderUserId = parseInt(request.getParameter("sender_user_id"));
        int receiverUserId = parseInt(request.getParameter("receiver_user_id"));
//        String email = String.valueOf(session.getAttribute("email"));
//
//        String userIdString = String.valueOf(session.getAttribute("user_id"));
//
//        if ((userIdString == null) | (userIdString.equals("null"))){
//            senderUserId = userDao.getUserId(email);
//        }
//
//        else {
//            userIdString = String.valueOf(session.getAttribute("user_id"));
//            senderUserId = parseInt(userIdString);
//        }

        String text = request.getParameter("private_message_text");

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        MessageStatus privateMessageStatus = MessageStatus.STANDARD;

        privateMessageDao.create(senderUserId, receiverUserId, text, timestamp, privateMessageStatus);

//        request.setAttribute(MY_PRIVATE_MESSAGES_KEY, privateMessageDao.getMyPrivateMessages(senderUserId));

//        System.out.println("sender_user_id "+senderUserId+" receiver_user_id "+receiverUserId+" private_message_text "+text+timestamp+privateMessageStatus);


        request.getRequestDispatcher("/reg-user-private-messages").forward(request, response);
//        request.getRequestDispatcher("my-page").forward(request, response);

    }

}
