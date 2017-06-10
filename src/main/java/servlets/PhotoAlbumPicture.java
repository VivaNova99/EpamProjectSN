package servlets;

import dao.PhotoAlbumDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;


@WebServlet("/photoalbum_picture")
public class PhotoAlbumPicture extends HttpServlet {

    private PhotoAlbumDao photoAlbumDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
//        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String photoalbumPictureIdString = request.getParameter("photoalbum_id");

//        String photoalbumPictureIdString = Optional.ofNullable(request.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("%s", o)).
//                        orElse("1");

        response.setContentType("image/jpg");

//        photoalbumPictureIdString = (String) request.getSession().getAttribute("photoalbum_id");
//        int photoalbumPictureId = (Integer) request.getSession().getAttribute("photoalbum_id");

        int photoalbumPictureId = parseInt(photoalbumPictureIdString);

//        System.out.println("photoalbum_id !!!  = " + request.getSession().getAttribute("photoalbum_id"));
//        int photoalbumPictureId = parseInt(request.getParameter("photoalbum_id") != "" ? request.getParameter("photoalbum_id"): "4");
//        System.out.println("photoalbum_id after= " + photoalbumPictureId);

        ResultSet photoalbumPictureResultSet = photoAlbumDao.transferPhotoalbumPicture(photoalbumPictureId);

        byte[] buffer = new byte[1];
            int read = 0;
        InputStream inputStream = null;
        try {
            inputStream = photoalbumPictureResultSet.getBinaryStream(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (OutputStream outputStream = response.getOutputStream()) {

            if (inputStream != null) {
                while ((read = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, read);
                }
            }

            outputStream.flush();
//            outputStream.close();
        }


    }

}
