package security;


import Filters.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

//@WebFilter("/*")
public class SecurityFilter implements HttpFilter {

    private static String KEY = "key";

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute(KEY) != null) {
            chain.doFilter(request, response);
        }

//        Map<String, String[]> parameterMap = request.getParameterMap();
//        if (parameterMap.containsKey("j_password") && parameterMap.containsKey("j_username")){
//
//        }
//
//        else {
//
//        }
    }
}
