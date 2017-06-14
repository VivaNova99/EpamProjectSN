package controllers;

import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;

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
import static model.User.LOGIN_KEY;


@WebServlet("/smb-page")
public class SmbPageController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
////    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
////    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
////    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_SOME_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_SOME_USER_PHOTOS_KEY = "Last5ForUserPhotos";
    public static final String SOME_USER_INFO_KEY = "SomeUserPage";


    private UserDao userDao;
//    private ForumThemeDao forumThemeDao;
//    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;
//    private PrivateMessageDao privateMessageDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
//        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
//        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String someUserIdString = req.getParameter("some_user_id");

        int someUserId = parseInt(someUserIdString);

        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);

        req.setAttribute(SOME_USER_INFO_KEY, userDao.getUser(someUserId));
        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
        req.setAttribute(USER_INFO_KEY, userDao.getUser());
        req.setAttribute(LAST_10_FOR_SOME_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(someUserId));
        req.setAttribute(LAST_5_FOR_SOME_USER_PHOTOS_KEY, photoDao.getLast5(someUserId));


        if (b && !((String.valueOf(session.getAttribute("email"))).equals("null"))) {
            req.getRequestDispatcher("/reg-user-smb-page.jsp")
                .forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/unreg-smb-page.jsp")
                    .forward(req, resp);
        }

    }
}
