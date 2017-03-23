package controllers;

import dao.ForumThemeDao;
import dao.PhotoAlbumDao;
import dao.PhotoDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        req.setAttribute(ALL_FORUM_THEMES_KEY, forumThemeDao.getAll());
        req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
        req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());


        req.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(req, resp);
    }
}
