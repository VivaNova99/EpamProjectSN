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


@WebServlet("/test-page")
public class TestPageController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

    private UserDao userDao;
    private ForumThemeDao forumThemeDao;
    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;
    private PrivateMessageDao privateMessageDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        int userId;

        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);
//
        if (b && !((session.getAttribute("email")).equals("null"))) {
            String email = String.valueOf(session.getAttribute("email"));

            String userIdString = String.valueOf(session.getAttribute("user_id"));
            int userId = parseInt(userIdString);

            req.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
            req.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
            req.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));
            req.setAttribute(ALL_USERS_KEY, userDao.getAll());
            req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
            req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
            req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
            req.setAttribute(ALL_PRIVATE_MESSAGES_KEY, privateMessageDao.getAll());
            req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());


//            System.out.println("In UserOwnPageController: user_id from getUserId(email) - " + userDao.getUserId(email) + ", " +
//                    "user_id - " + session.getAttribute("user_id") + "," +
//                    " email - " + session.getAttribute("email") + ", " +
//                    "photoalbum_name - " + req.getParameter("photoalbum_name") + "," +
//                    " description - " + req.getParameter("description"));

            req.getRequestDispatcher("WEB-INF/test-pages/test.jsp")
                    .forward(req, resp);
        }
        
        else {
            System.out.println("незарегистрированный пользователь (нет атрибута email в сессии)");

            req.getRequestDispatcher("unreg-forum.jsp")
                    .forward(req, resp);
        }


//        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
//                .map(o -> String.format("Здравствуйте, %s", o))
//                .orElse("Здравствуйте!");

//        String userPageOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("reg-user-own-page/%s.jsp", o)).
//                orElse("test.jsp");
//                orElse("/WEB-INF/index.jsp");

//        req.setAttribute(WELCOME_KEY, s);

//        if (b) {req.getRequestDispatcher("/WEB-INF/reg-user-own-page.jsp")
//                .forward(req, resp);
//        }
//        else {req.getRequestDispatcher("/WEB-INF/unreg-forum.jsp")
//                .forward(req, resp);
//        }

//        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

    }
}
