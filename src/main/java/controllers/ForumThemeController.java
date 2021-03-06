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


@WebServlet("/forum-this-theme")
public class ForumThemeController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String THIS_THEME_WALL_MESSAGES_KEY = "ThisThemeWallMessages";


    private UserDao userDao;
    private ForumThemeDao forumThemeDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String thisForumThemeIdOrderString = req.getParameter("this_forum_theme_order");

        int thisForumThemeOrder = parseInt(thisForumThemeIdOrderString);

//        boolean b = Optional.ofNullable(req.getParameter(String.valueOf("email")))
        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);

//        req.setAttribute("user_id", req.getParameter("user_id"));
//        req.setAttribute("email", req.getParameter("email"));

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
        req.setAttribute(THIS_THEME_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTheme(thisForumThemeOrder));


        if (b && !((req.getParameter("email")).equals("null")) ) {
            req.getRequestDispatcher("/reg-user-forum-this-theme.jsp")
                .forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/unreg-forum-this-theme.jsp")
                .forward(req, resp);
        }

    }
}
