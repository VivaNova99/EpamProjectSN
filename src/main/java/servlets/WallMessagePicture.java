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
public class WallMessagePicture extends HttpServlet {

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

//        //Проверить, что параметр передается в сессии - не передается
        HttpSession session = request.getSession();
//        String jUserId = request.getParameter("j_id");
//        System.out.println("User with Id, userId="+jUserId);
//        session.setAttribute("j_id", jUserId);

        String wallMessagePictureIdString = request.getParameter("wall_message_picture_id");

//        String photoPictureIdString = Optional.ofNullable(request.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("%s", o)).
//                        orElse("1");

        response.setContentType("image/jpg");

        int wallMessagePictureId = parseInt(wallMessagePictureIdString);

        ResultSet wallMessagePictureResultSet = wallMessageDao.transferWallMessagePicture(wallMessagePictureId);

        byte[] buffer = new byte[1];
        int read = 0;
        InputStream inputStream = null;
        try {
            inputStream = wallMessagePictureResultSet.getBinaryStream(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (OutputStream outputStream = response.getOutputStream()) {

            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }

            outputStream.flush();
            outputStream.close();
        }


    }

}
