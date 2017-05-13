package security;

import dao.UserDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


//@WebServlet("j_security_check") - срабатывает некорректно
public class SecurityCheckController extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jUserLogin = req.getParameter("j_username");

        String userPassword = req.getParameter("j_password");
        String userLogin = jUserLogin.replace("%40", "@");

        // TODO: добавить логику по проверке пароля

//        req.setAttribute(THIS_TOPIC_WALL_MESSAGES_KEY, wallMessageDao.getThisForumTopic(thisForumTopicId));

        String userPageOrNot = Optional.ofNullable(userDao.getUserId(userLogin))
                .map(o -> String.format("reg-user-own-page/?=%s.jsp", o)).
                        orElse("test.jsp");

        req.getRequestDispatcher(userPageOrNot).forward(req, resp);

    }

}
