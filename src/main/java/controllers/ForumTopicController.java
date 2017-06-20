package controllers;

import dao.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static model.User.FIRST_NAME_KEY;
import static model.User.ID_KEY;
import static model.User.LOGIN_KEY;


@WebServlet("/forum-this-topic")
public class ForumTopicController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String THIS_TOPIC_WALL_MESSAGES_KEY = "ThisTopicWallMessages";


    private UserDao userDao;
    private ForumThemeDao forumThemeDao;
    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String thisForumTopicIdString = req.getParameter("this_forum_topic_id");

        int thisForumTopicId = parseInt(thisForumTopicIdString);

//        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(LOGIN_KEY)))
        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);

//        req.setAttribute("user_id", req.getParameter("user_id"));
//        req.setAttribute("email", req.getParameter("email"));

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
        req.setAttribute(THIS_TOPIC_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTopic(thisForumTopicId));
        req.setAttribute("parent_message_id", thisForumTopicId);
        req.setAttribute("forum_theme_id", wallMessageDao.getForumThemeId(thisForumTopicId));

        if (b && !((session.getAttribute("email")).equals("null"))) {
            req.getRequestDispatcher("/reg-user-forum-this-topic.jsp")
                .forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/unreg-forum-this-topic.jsp")
                .forward(req, resp);
        }

    }
}
