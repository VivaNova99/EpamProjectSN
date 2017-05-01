package servlets;

import dao.PhotoDao;

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


@WebServlet("/photo_picture")
public class PhotoPicture extends HttpServlet {

    private PhotoDao photoDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String photoPictureIdString = request.getParameter("photo_id");

//        String photoPictureIdString = Optional.ofNullable(request.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("%s", o)).
//                        orElse("1");

        response.setContentType("image/jpg");

        int photoPictureId = parseInt(photoPictureIdString);

        ResultSet photoPictureResultSet = photoDao.transferPhotoPicture(photoPictureId);

        byte[] buffer = new byte[1];
        int read = 0;
        InputStream inputStream = null;
        try {
            inputStream = photoPictureResultSet.getBinaryStream(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = response.getOutputStream();

        while ((read = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, read);
        }

        outputStream.flush();
        outputStream.close();


    }

}
