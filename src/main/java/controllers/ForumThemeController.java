package controllers;

import dao.*;
import model.WallMessage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
//    public static final String THIS_THEME_WALL_MESSAGES_KEY = "ThisThemeWallMessages";


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

//        List thisForumTheme = (List)wallMessageDao.getThisForumTheme(thisForumThemeOrder);
//        List<WallMessage> thisThemeWallMessages = new ArrayList<WallMessage>(thisForumTheme.size());
//        for (Object message : thisForumTheme){
//            WallMessage wallMessage = new WallMessage();
//            wallMessage.setId(message.get)
//        }

//        Collection<WallMessage> messages = (Collection<WallMessage>)wallMessageDao.getThisForumTheme(thisForumThemeOrder);
//        List<WallMessage> thisThemeWallMessages = new ArrayList<>(messages.size());
//        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("in ForumThemeController.java");
//        for (WallMessage message : messages) {
//            WallMessage wm = new WallMessage();
//            wm.setId(message.getId());
//            System.out.println("id - " + message.getId());
//            wm.setMessageHeader(message.getMessageHeader());
//            System.out.println("header - " + message.getMessageHeader());
////            wm.setSenderUserFirstNameAndLastName(message.getSenderUserFirstNameAndLastName());
//            try {
//                wm.setDateTime(simpleFormatter.parse(message.getDateTime()));
//                System.out.println("date - " + message.getDateTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

        req.setAttribute(ALL_USERS_KEY, userDao.getAll());
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_WALL_MESSAGES_KEY, wallMessageDao.getAll());
//        req.setAttribute(THIS_THEME_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTheme(thisForumThemeOrder));
//        req.setAttribute("thisThemeWallMessages", thisThemeWallMessages);
        req.setAttribute("thisThemeWallMessages1", wallMessageDao.getThisForumTheme(thisForumThemeOrder));


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
