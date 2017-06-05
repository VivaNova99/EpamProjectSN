package controllers;

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
public class ChangeUserInfoController extends HttpServlet {

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

        HttpSession session = req.getSession(true);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

//        String firstName = new String((req.getParameter("first_name")).getBytes("UTF-8"), "UTF-8");

        String idString = req.getParameter("id");

        int userId = parseInt(idString);

//        System.out.println("user id = " + userId +
//                req.getParameter("first_name") +
//                req.getParameter("last_name") +
//                LocalDate.parse(req.getParameter("date_of_birth")) +
//                AccessLevel.STANDARD_USER +
//                req.getParameter("email") +
//                req.getParameter("password") +
//                req.getParameter("status") +
//                req.getParameter("city"));

        User user = new User(
                userId,
//                StandardCharsets.UTF_8.decode(Charset.forName("UTF-8").encode(req.getParameter("first_name"))).toString(),
                req.getParameter("first_name"),
                req.getParameter("last_name"),
                LocalDate.parse(req.getParameter("date_of_birth")),
                AccessLevel.STANDARD_USER,
                req.getParameter("email"),
                req.getParameter("password"),
                req.getParameter("status"),
                req.getParameter("city"));

        userDao.update(user);

        session.setAttribute("j_username", req.getParameter("email"));
        req.setAttribute("j_username", req.getParameter("email"));

//        req.setAttribute(USER_INFO_KEY, userDao.getUserTest(userId));


//        req.getRequestDispatcher("/WEB-INF/test-pages/test-registration.jsp").forward(req, resp);
        req.getRequestDispatcher("/").forward(req, resp);


//        req.getRequestDispatcher("/my-page").forward(req, resp);






        //        HttpSession session = req.getSession();

//        String userPageOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("j_username")))
//                .map(o -> String.format("my-page?j_username=%s", o)).
//                orElse("error.jsp");

////        посмотреть, что создается кука с идентификатором сессии
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies){
//            System.out.println(cookie.getName() + " - " + cookie.getValue());
//        }



//        String jUserLogin = req.getParameter("j_username");
//
//        String jUserPassword = req.getParameter("j_password");
//
//        String jUserId = req.getParameter("j_id");


//        if (!(jUserId == null) && !(jUserId.equals(""))){
////        if (!(jUserId.equals("null"))){
////        if (jUserId==null){
//
//            // посмотреть, что Id есть в параметрах сессии
//            System.out.println("User with Id, userId="+jUserId);
//
//            int userId = parseInt(jUserId);
//            req.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
//            req.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
//            req.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));
//
//            session.setAttribute("j_id", jUserId);
//            //пока не работает
//            session.setAttribute("j_username", jUserLogin);
//            //пока не работает
//            session.setAttribute("j_password", jUserPassword);
//            //пока не работает
//
//            req.getRequestDispatcher("/reg-user-own-page.jsp")
//                    .forward(req, resp);
//
//            //TODO: добавить проверку пароля
//        }
//
//        else if (jUserLogin != null && jUserPassword != null){
//            System.out.println("userLogin="+jUserLogin);
////            String userLogin = jUserLogin.replace("%40", "@");
//            int userId = userDao.getUserId(jUserLogin);
//            jUserId = "" + userId;
//
//            // посмотреть, что Id правильно вытаскивается из базы
//            System.out.println("User with Login, userId="+jUserId);
//
//            req.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
//            req.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
//            req.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));
//
//            session.setAttribute("j_id", jUserId);
//            //пока не работает
//            session.setAttribute("j_username", jUserLogin);
//            //пока не работает
//            session.setAttribute("j_password", jUserPassword);
////            пока не работает
////            req.setAttribute("j_id", jUserId);
////            req.setAttribute("j_username", jUserLogin);
////            req.setAttribute("j_username", jUserLogin);
//
//
//            req.getRequestDispatcher("/reg-user-own-page.jsp")
//                    .forward(req, resp);
//
//            //TODO: добавить проверку пароля и страницу ошибки, если нет такого логина в базе
//        }
//
//        else {
//            session.setAttribute("j_id", jUserId);
//            //пока не работает
//            session.setAttribute("j_username", jUserLogin);
//            //пока не работает
//            session.setAttribute("j_password", jUserPassword);
//            //пока не работает
//
//            req.getRequestDispatcher("/user-login-form.jsp")
//                    .forward(req, resp);
//        }
//
////        session.setAttribute("j_id", jUserId);
////        //пока не работает
////        session.setAttribute("j_username", jUserLogin);
////        //пока не работает
////        session.setAttribute("j_password", jUserPassword);
////        //пока не работает




//        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> true)
//                .orElse(false);

//        req.setAttribute(WELCOME_KEY, s);

//        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
//        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
//        req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
//        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
//        req.setAttribute(ALL_PRIVATE_MESSAGES_KEY, privateMessageDao.getAll());
//        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());


//        if (b) {req.getRequestDispatcher("/WEB-INF/reg-user-own-page.jsp")
//                .forward(req, resp);
//        }
//        else {req.getRequestDispatcher("/WEB-INF/unreg-forum.jsp")
//                .forward(req, resp);
//        }

//        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

    }
}
