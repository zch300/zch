package top.soft.bookonline.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 可以删除或注释掉这个方法，因为它与父类方法相同
    }

    @Override
    public void destroy() {
        // 可以删除或注释掉这个方法，因为它与父类方法相同
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setContentType("text/html;charset=utf-8");

        String[] urls = {"/images", "/css", "login.html", "login.page", "/login"};
        String requestUrl = httpRequest.getRequestURI();

        for (String url : urls) {
            if (requestUrl.contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }

        HttpSession session = httpRequest.getSession();
        Object loginUser = session.getAttribute("user");
        if (loginUser == null) {
            request.getRequestDispatcher("/login.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
