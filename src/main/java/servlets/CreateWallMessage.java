package servlets;

import dao.ForumThemeDao;
import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;
import model.MessageStatus;
import model.PhotoStatus;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import static java.lang.Integer.parseInt;


@WebServlet("/create_wall_message")
@MultipartConfig
public class CreateWallMessage extends HttpServlet {

    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

    private UserDao userDao;
    private PhotoDao photoDao;
    private WallMessageDao wallMessageDao;
    private ForumThemeDao forumThemeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int senderUserId;
        String email = String.valueOf(session.getAttribute("email"));

        String userIdString = String.valueOf(session.getAttribute("user_id"));

        if ((userIdString == null) | (userIdString.equals("null"))){
            senderUserId = userDao.getUserId(email);
        }

        else {
            userIdString = String.valueOf(session.getAttribute("user_id"));
            senderUserId = parseInt(userIdString);
        }

        String text = request.getParameter("wall_message_text");

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        String forumThemeName = request.getParameter("forum_theme_name");
        int forumThemeId = forumThemeDao.getForumThemeId(forumThemeName);

        String messageHeader = request.getParameter("wall_message_header");

        Boolean isParent = true;

        int parentMessageId = 1;

        MessageStatus messageStatus = MessageStatus.STANDARD;

        Part filePart = request.getPart("upfile");

        if (request.getPart("upfile") == null){
            wallMessageDao.createWithoutPicture(senderUserId, text, timestamp, forumThemeId, messageHeader, isParent, parentMessageId, messageStatus);
        }
        else {
            wallMessageDao.createWithUserPicture(senderUserId, text, filePart, timestamp, forumThemeId, messageHeader, isParent, parentMessageId, messageStatus);
        }

        request.setAttribute(USER_INFO_KEY, userDao.getUser(senderUserId));
        request.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(senderUserId));
        request.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(senderUserId));


        request.getRequestDispatcher("reg-user-own-page.jsp").forward(request, response);
//        request.getRequestDispatcher("my-page").forward(request, response);

    }

}
