package servlets;

import dao.UserDao;
import dao.WallMessageDao;
import model.WallMessage;

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

import static java.lang.Integer.parseInt;


@WebServlet("/wall_message_picture")
public class ShowWallMessagePicture extends HttpServlet {

    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpg");

        String wallMessagePictureIdString = request.getParameter("wall_message_picture_id");
        int wallMessagePictureId = parseInt(wallMessagePictureIdString);

        try (InputStream inputStream = wallMessageDao.transferWallMessagePicture(wallMessagePictureId)) {

            byte[] buffer = new byte[1];
            int read = 0;

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

}
