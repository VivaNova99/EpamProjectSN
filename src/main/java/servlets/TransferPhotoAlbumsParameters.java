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

import static java.lang.Integer.parseInt;

//@WebServlet("/photoalbums_parameters")
public class TransferPhotoAlbumsParameters extends HttpServlet{

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

//        String email = req.getParameter("email");
//
//        int userId = userDao.getUserId(email);
//
//        String userIdString = String.valueOf(userId);
//
//        req.setAttribute("user_id", userIdString);
//        req.setAttribute("email", req.getParameter("email"));

//        System.out.println("In TransferPhotoAlbumParameter: user_id - " + req.getParameter("user_id") + "," +
//                " email - " + req.getParameter("email") + ", " +
//                "photoalbum_name - " + req.getParameter("photoalbum_name") + "," +
//                " description - " + req.getParameter("description"));


        req.getRequestDispatcher("user-create-photoalbum-form.jsp").forward(req, resp);


    }
}