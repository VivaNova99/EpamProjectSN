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


@WebServlet("/user-photos-in-photoalbum")
public class UserPhotosInThisPhotoalbumController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
//    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
//    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
//    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String USER_PHOTOS_KEY = "UserPhotos";

    private UserDao userDao;
    private ForumThemeDao forumThemeDao;
    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;
    private PrivateMessageDao privateMessageDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
//        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
//        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        HttpSession session = req.getSession(true);

//        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
//                .map(o -> String.format("Здравствуйте, %s", o))
//                .orElse("Здравствуйте!");
//
//        String userPageOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("reg-user-own-page/%s.jsp", o)).
//                orElse("test.jsp");
////                orElse("/WEB-INF/index.jsp");

//        boolean b = Optional.ofNullable(req.getSession().getAttribute("email"))
        boolean b = Optional.ofNullable(req.getParameter("email"))
                .map(o -> true)
                .orElse(false);


        String email = req.getParameter("email");

        String password = req.getParameter("password");

        String userIdString = req.getParameter("user_id");

        String photoalbumIdString = req.getParameter("photoalbum_id");


        int userId = userDao.getUserId(email);

//        int userId = parseInt(userIdString);
        int photoalbumId = parseInt(photoalbumIdString);

//        session.setAttribute("email", email);
        req.setAttribute("user_id", req.getParameter("user_id"));
        req.setAttribute("email", email);

//        req.setAttribute(WELCOME_KEY, s);

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
//        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
//        req.setAttribute(ALL_PRIVATE_MESSAGES_KEY, privateMessageDao.getAll());
//        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
        req.setAttribute(USER_PHOTOS_KEY, photoDao.getUserPhotosInThisPhotoalbum(userId, photoalbumId));

//        HttpSession session = req.getSession();
//        session.setAttribute("user_id", req.getParameter("user_id"));
//        session.setAttribute("email", req.getParameter("email"));

        if (b & !(req.getParameter("email").equals("null"))) {req.getRequestDispatcher("reg-user-photos.jsp")
                .forward(req, resp);
        }
        else {req.getRequestDispatcher("unreg-user-photos.jsp")
                .forward(req, resp);
        }

//        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

//        req.getRequestDispatcher("reg-user-photos.jsp")
//                .forward(req, resp);
    }
}
