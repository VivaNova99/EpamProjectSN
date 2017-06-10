package servlets;

import dao.PhotoAlbumDao;
import dao.PhotoDao;
import dao.UserDao;
import dao.WallMessageDao;
import model.PhotoAlbum;
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
import java.time.LocalDate;
import java.util.Date;

import static java.lang.Integer.parseInt;


@WebServlet("/upload_users_photo_picture")
@MultipartConfig
public class UploadUsersPhotoPicture extends HttpServlet {

    public static final String USER_INFO_KEY = "UserInfo";
    public static final String LAST_10_FOR_USER_WALL_MESSAGES_KEY = "Last10ForUserWallMessages";
    public static final String LAST_5_FOR_USER_PHOTOS_KEY = "Last5ForUserPhotos";

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

        //TODO: создать encoding filter
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userIdString = request.getParameter("user_id");
        String photoAlbumIdString = request.getParameter("photo_album_id");

        int userId = parseInt(userIdString);
//        int photoAlbumId = parseInt(photoAlbumIdString);

        //временно, потом сделать выбор из списка фотоальбомов
//        int photoAlbumId = 1;

        int photoAlbumId = photoAlbumDao.getPhotoalbumId(request.getParameter("photoalbum_name"));

        Date date = new Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        String photoDescription = request.getParameter("description");

        PhotoStatus photoStatus = PhotoStatus.PUBLIC;

        System.out.println(request.getParameter("photoalbum_name"));


        photoDao.insertUploadedPictureIntoUserPhotos(userId, photoAlbumId, request.getPart("upfile"), photoDescription, timestamp, photoStatus);


        request.setAttribute(USER_INFO_KEY, userDao.getUser(userId));
        request.setAttribute(LAST_10_FOR_USER_WALL_MESSAGES_KEY, wallMessageDao.getLast10ForUser(userId));
        request.setAttribute(LAST_5_FOR_USER_PHOTOS_KEY, photoDao.getLast5(userId));


        request.getRequestDispatcher("reg-user-own-page.jsp").forward(request, response);

    }

}
