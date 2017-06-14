package servlets;

import dao.UserDao;
import model.AccessLevel;
import model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


@WebServlet("/change-user-info")
public class ChangeUserInfo extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
//    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
//    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
//    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

    private UserDao userDao;
//    private ForumThemeDao forumThemeDao;
//    private PhotoAlbumDao photoAlbumDao;
//    private PhotoDao photoDao;
//    private PrivateMessageDao privateMessageDao;
//    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
//        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
//        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
//        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
//        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");

        String userIdString = String.valueOf(session.getAttribute("user_id"));

        int userId = parseInt(userIdString);

        User user = new User(
                userId,
                req.getParameter("first_name"),
                req.getParameter("last_name"),
                LocalDate.parse(req.getParameter("date_of_birth")),
                AccessLevel.STANDARD_USER,
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("status"),
                req.getParameter("city"));

        userDao.update(user);

        req.getRequestDispatcher("/").forward(req, resp);

    }
}
