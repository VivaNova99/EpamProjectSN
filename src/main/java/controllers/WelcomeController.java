package controllers;

import dao.ForumThemeDao;
import dao.PhotoAlbumDao;
import dao.PhotoDao;
import dao.UserDao;
import dao.PrivateMessageDao;
import dao.WallMessageDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static model.User.FIRST_NAME_KEY;
import static model.User.ID_KEY;


@WebServlet("/")
public class WelcomeController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";

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




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

//        String jUserLogin = req.getParameter("j_username");
//
//        String jUserPassword = req.getParameter("j_password");
//
//        String jUserId = null;



//        if (jUserLogin != null && jUserPassword != null) {
//            String userLogin = jUserLogin.replace("%40", "@");
//            int userId = userDao.getUserId(userLogin);
//            jUserId = "" + userId;
//        }


//        String userPageOrNot = Optional.ofNullable(jUserId)
//                .map(o -> String.format("reg-user-own-page/?j_id=%s", o)).
//                        orElse("test.jsp");


//        System.out.println("!!!!!"+this);

        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Здравствуйте, %s", o))
                .orElse("Здравствуйте!");

        String userPageOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
                .map(o -> String.format("reg-user-own-page/?=%s.jsp", o)).
                orElse("test.jsp");
//                orElse("/WEB-INF/index.jsp");

//        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> true)
//                .orElse(false);

        req.setAttribute(WELCOME_KEY, s);

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
        req.setAttribute(ALL_PRIVATE_MESSAGES_KEY, privateMessageDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());

//        if (b) {req.getRequestDispatcher("/WEB-INF/reg-user-own-page.jsp")
//                .forward(req, resp);
//        }
//        else {req.getRequestDispatcher("/WEB-INF/unreg-forum.jsp")
//                .forward(req, resp);
//        }

        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

//        req.getRequestDispatcher("/WEB-INF/index.jsp")
//                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
