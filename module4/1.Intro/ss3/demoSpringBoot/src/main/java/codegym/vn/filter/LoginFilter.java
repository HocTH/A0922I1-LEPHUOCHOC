package codegym.vn.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Component
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();
        if (path.contains("login") || path.contains("css")) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession httpSession = req.getSession();
        String username = (String) httpSession.getAttribute("user");
        if (username == null || "".equals(username)) {
            res.sendRedirect("/login");
        }
        chain.doFilter(request, response);
    }
}
