package servlets;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@WebServlet("/photoalbums_list")
public class BuildPhotoAlbumsList extends HttpServlet{

    public static final String USER_PHOTOALBUMS_KEY = "UserPhotoalbums";

    private UserDao userDao;
    private PhotoAlbumDao photoAlbumDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
//        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String userIdString = req.getParameter("user_id");

//        System.out.println("user id = " + userIdString);

        int userId = parseInt(userIdString);


//        String jUserLogin = req.getParameter("j_username");
//
//        String jUserPassword = req.getParameter("j_password");
//
//        String jUserId = req.getParameter("j_id");
//
//
//        int userId = userDao.getUserId(jUserLogin);
//
//        session.setAttribute("j_username", jUserLogin);
//

        req.setAttribute("user_id", String.valueOf(userId));
        req.setAttribute("email", req.getParameter("email"));

        req.setAttribute(USER_PHOTOALBUMS_KEY, photoAlbumDao.getUserPhotoAlbums(userId));

        req.getRequestDispatcher("user-upload-photo-form.jsp").forward(req, resp);


    }
}