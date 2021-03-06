package servlets;

import dao.H2.H2InsertPictureIntoDatabase;
import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

import static java.lang.Integer.parseInt;


@WebServlet("/upload_users_profile_picture")
@MultipartConfig
public class UploadUsersProfilePicture extends HttpServlet {

    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

    private UserDao userDao;
    private PhotoDao photoDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String userIdString = String.valueOf(session.getAttribute("user_id"));

        int userId = parseInt(userIdString);

        userDao.insertUploadedPictureIntoUserProfilePhoto(userId, request.getPart("upfile"));

        request.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
        request.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
        request.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));


        request.getRequestDispatcher("reg-user-own-page.jsp").forward(request, response);
//        request.getRequestDispatcher("my-page").forward(request, response);

    }

}
