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
public class ShowPhotoAlbumPicture extends HttpServlet {

    private PhotoAlbumDao photoAlbumDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String photoalbumPictureIdString = request.getParameter("photoalbum_id");

        response.setContentType("image/jpg");

        int photoalbumPictureId = parseInt(photoalbumPictureIdString);

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
        }


    }

}
