package Filters;


import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

@WebFilter("/*")
public class SessionFilter implements HttpFilter {

    private FilterConfig config = null;

//    private static String KEY = "key";

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = request.getSession(true);

        boolean boolUserId = Optional.ofNullable(request.getParameter(String.valueOf("user_id")))
                .map(o -> true)
                .orElse(false);

        boolean boolEmail = Optional.ofNullable(request.getParameter(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);

        String userIdString = request.getParameter("user_id");
        String email = request.getParameter("email");

        if (boolUserId && !(userIdString.equals("null"))){
            session.setAttribute("user_id", request.getParameter("user_id"));
        }

        if (boolEmail && !(email.equals("null"))){
            session.setAttribute("email", request.getParameter("email"));
        }

//        if (boolUserId){
//            session.setAttribute("user_id", request.getParameter("user_id"));
//        }
//
//        if (boolEmail){
//            session.setAttribute("email", request.getParameter("email"));
//        }

        chain.doFilter(request, response);



//        //        посмотреть, что создается кука с идентификатором сессии
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies){
//            System.out.println(cookie.getName() + " - " + cookie.getValue());
//        }


//        if (session.getAttribute(KEY) != null) {
//            chain.doFilter(request, response);
//        }
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        if (parameterMap.containsKey("j_password") && parameterMap.containsKey("j_username")) {
//            // TODO: 22/10/2016

//            Optional<User> authorize = authorize(parameterMap);
//            if (authorize.isPresent()) {
//                session.setAttribute(KEY, authorize.get());
//                chain.doFilter(request, response);
//            } else
//                request.getRequestDispatcher("/error.html").forward(request, response);

//        } else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
//            // TODO: 22/10/2016 посмотреть что можно сделать что бы не терять информацию о странице куда пользователь зашёл
//            requestDispatcher.forward(request, response);
//        }
    }

    public void destroy()
    {
        config = null;
    }

}