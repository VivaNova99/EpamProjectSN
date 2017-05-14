package servlets;

import dao.PhotoDao;
import dao.UserDao;
import model.User;

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


@WebServlet("/users_profile_picture")
public class UsersProfilePicture extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //Проверить, что параметр передается в сессии - не передается
        HttpSession session = request.getSession();
//        String jUserId = request.getParameter("j_id");
//        System.out.println("User with Id, userId="+jUserId);
//        session.setAttribute("j_id", jUserId);

        String usersProfilePictureIdString = request.getParameter("user_id");

//        String photoPictureIdString = Optional.ofNullable(request.getSession().getAttribute(String.valueOf(ID_KEY)))
//                .map(o -> String.format("%s", o)).
//                        orElse("1");

        response.setContentType("image/jpg");

        int usersProfilePictureId = parseInt(usersProfilePictureIdString);

        ResultSet usersProfilePictureResultSet = userDao.transferUsersProfilePicture(usersProfilePictureId);

        byte[] buffer = new byte[1];
        int read = 0;
        InputStream inputStream = null;
        try {
            inputStream = usersProfilePictureResultSet.getBinaryStream(1);
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
