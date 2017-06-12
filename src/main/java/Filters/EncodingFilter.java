package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements HttpFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // чтение кодировки из запроса
        String encoding = request.getCharacterEncoding();

        // установка UTF-8, если не установлена
        if (!"UTF-8".equals(encoding))
            request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);

//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        chain.doFilter(request, response);

    }

}
