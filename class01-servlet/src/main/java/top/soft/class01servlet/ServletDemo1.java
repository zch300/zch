package top.soft.class01servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo1 implements Servlet {
    /**
     * Serviet 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServietDemo1 初始化");

    }

    /**
     * 获取 Serviet 配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行 Serviet 方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("servletDemo01 执行");
        System.out.println(" service执行 ");
    }

    /**
     * 获取 Serviet 信息
     * @return
     */

    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 执行销毁方法
     */

    @Override
    public void destroy() {
        System.out.println("销毁方法");

    }
}