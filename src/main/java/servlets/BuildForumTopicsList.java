package servlets;

import dao.ForumThemeDao;
import dao.PhotoAlbumDao;
import dao.UserDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/forum_topics_list")
public class BuildForumTopicsList extends HttpServlet{

    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";

    private ForumThemeDao forumThemeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");

//        String userIdString = String.valueOf(session.getAttribute("user_id"));
//
//        int userId = parseInt(userIdString);

        req.setAttribute("wall_message_text", req.getParameter("wall_message_text"));

        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAllForumThemeNames());

        req.getRequestDispatcher("user-create-wall-message-form.jsp").forward(req, resp);


    }
}