package controllers;

import dao.ForumThemeDao;
import dao.PhotoAlbumDao;
import dao.PhotoDao;
import lombok.SneakyThrows;
import model.ForumTheme;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;

import static model.User.FIRST_NAME_KEY;

@WebServlet("/")
public class WelcomeController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";

    private ForumThemeDao forumThemeDao;
    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
    }





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Здравствуйте, %s", o))
                .orElse("Здравствуйте!");

        req.setAttribute(WELCOME_KEY, s);

//        Collection<ForumThemes> all = forumThemesDao.getAll(); - лучше сразу поместим в запрос
        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());

//        Context initContext = new InitialContext();
//        Context envContext  = (Context)initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
//        Connection conn = ds.getConnection();



        req.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(req, resp);
    }
}
