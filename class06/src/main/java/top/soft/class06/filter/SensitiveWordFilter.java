package top.soft.class06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 11448
 * @description: 敏感词过滤过滤器
 * @date 2024/11/23 14:28
 */
@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SensitiveWordFilter.class.getName());
    List<String> list = new ArrayList<>();
    //执行方法名
    private final String methodName = "getParameter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realpath = servletContext.getRealPath("/WEB-INF/classes/敏感词.txt");
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(realpath), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                list.add(line);
            }
            LOGGER.log(Level.INFO, "敏感词文件读取成功，共读取 " + list.size() + " 个敏感词");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "敏感词文件读取失败", e);
        }
    }

    @Override
    public void destroy() {
        LOGGER.log(Level.INFO, "SensitiveWordFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        //通过代理增强 getParameter 方法
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodName.equals(method.getName())) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (value!= null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "*******");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
        });
        try {
            LOGGER.log(Level.INFO, "执行过滤器链");
            filterChain.doFilter(proxyRequest, servletResponse);
        } catch (ServletException | IOException e) {
            LOGGER.log(Level.SEVERE, "过滤器链执行失败", e);
        }
    }
}
