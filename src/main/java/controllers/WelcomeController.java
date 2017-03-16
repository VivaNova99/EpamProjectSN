package controllers;

import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

import static model.User.FIRST_NAME_KEY;

@WebServlet("/")
public class WelcomeController extends HttpServlet {

    public static String WELCOME_KEY = "Welcome";

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = Optional.ofNullable(req.getSession().getAttribute(FIRST_NAME_KEY))
                .map(o -> String.format("Здравствуйте, %s", o))
                .orElse("Здравствуйте!");

        req.setAttribute(WELCOME_KEY, s);

//        Context initContext = new InitialContext();
//        Context envContext  = (Context)initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
//        Connection conn = ds.getConnection();



        req.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(req, resp);
    }
}
