package servlets;

import dao.PhotoAlbumDao;
import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;
import model.PhotoStatus;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import static java.lang.Integer.parseInt;


@WebServlet("/create_users_photoalbum")
@MultipartConfig
public class CreateUsersPhotoalbum extends HttpServlet {

    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";
    public static final String USER_PHOTOALBUMS_KEY = "UserPhotoalbums";

    private UserDao userDao;
    private PhotoDao photoDao;
    private PhotoAlbumDao photoAlbumDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int userId;
        String email = String.valueOf(session.getAttribute("email"));
//        int userId = userDao.getUserId(email);
//        String userIdString = String.valueOf(userId);
        String userIdString = String.valueOf(session.getAttribute("user_id"));

        if ((userIdString == null) | (userIdString.equals("null"))){
            userId = userDao.getUserId(email);
        }

        else {
            userId = parseInt(userIdString);
        }

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        String photoAlbumName = request.getParameter("photoalbum_name");

        String photoAlbumDescription = request.getParameter("description");

        PhotoStatus photoAlbumStatus = PhotoStatus.PUBLIC;

        if (request.getPart("upfile") == null){
            photoAlbumDao.createWithDefaultPicture(photoAlbumName, userId, photoAlbumDescription, timestamp, photoAlbumStatus);
        }
        else {
            photoAlbumDao.createWithUserPicture(photoAlbumName, userId, request.getPart("upfile"), photoAlbumDescription, timestamp, photoAlbumStatus);
        }


        request.setAttribute("user_id", userIdString);
        request.setAttribute("email", request.getParameter("email"));

        System.out.println("In CreateUsersPhotoalbum: user_id - " + String.valueOf(userId) + "," +
                " email - " + request.getParameter("email") + ", " +
                "photoalbum_name - " + request.getParameter("photoalbum_name") + "," +
                " description - " + request.getParameter("description"));

        request.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
        request.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
        request.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));
        request.setAttribute(USER_PHOTOALBUMS_KEY, photoAlbumDao.getUserPhotoAlbums(userId));


//        request.getRequestDispatcher("reg-user-photoalbums.jsp").forward(request, response);
        request.getRequestDispatcher("reg-user-own-page.jsp").forward(request, response);
//        request.getRequestDispatcher("my-page").forward(request, response);

    }

}
