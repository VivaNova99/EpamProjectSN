package controllers;

import dao.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
//                .map(o -> String.format("Здравствуйте, %s", o))
//                .orElse("Здравствуйте!");
//
//        String userPageOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("reg-user-own-page/%s.jsp", o)).
//                orElse("test.jsp");
////                orElse("/WEB-INF/index.jsp");

//        String userOrNot = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(LOGIN_KEY)))
//                .map(o -> String.format("my-page?j_username=%s", o)).
//                        orElse("unreg-forum.jsp");

        String thisForumThemeIdOrderString = req.getParameter("this_forum_theme_order");

        int thisForumThemeOrder = parseInt(thisForumThemeIdOrderString);

        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf(LOGIN_KEY)))
                .map(o -> true)
                .orElse(false);

//        req.setAttribute(WELCOME_KEY, s);

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
        req.setAttribute(THIS_THEME_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTheme(thisForumThemeOrder));

        if (b) {req.getRequestDispatcher("/reg-user-forum-this-theme.jsp")
                .forward(req, resp);
        }
        else {req.getRequestDispatcher("/unreg-forum-this-theme.jsp")
                .forward(req, resp);
        }

//        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

//        req.getRequestDispatcher("/WEB-INF/index.jsp")
//                .forward(req, resp);

//        req.getRequestDispatcher(userOrNot).forward(req, resp);

    }
}
