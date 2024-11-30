package top.soft.bookonline.service.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import top.soft.bookonline.entity.User;

import top.soft.bookonline.service.impl.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author 11448
 * @description: TODO
 * @date 2024/10/26 14:48
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private Cookie usernameCookie;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        // 调用登录功能
        User user = userService.signIn(account, password);
        if (user != null) {
            // 登陆成功，将用户对象计入 session
            req.getSession().setAttribute("user", user);

            if (remember != null) {
                Cookie usernameCookie = new Cookie("username", account);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
            }

            // 重定向回到 /index，进入 indexServlet
            resp.sendRedirect("/index");
        } else {
            // 登陆失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('账号或密码错误');location.href='/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
