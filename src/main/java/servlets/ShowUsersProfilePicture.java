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
public class ShowUsersProfilePicture extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setContentType("image/jpg");

        String usersProfilePictureIdString = request.getParameter("users_profile_picture_id");
        int usersProfilePictureId = parseInt(usersProfilePictureIdString);

        try (InputStream inputStream = userDao.transferUsersProfilePicture(usersProfilePictureId)) {

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
