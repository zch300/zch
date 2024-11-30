package top.soft.class06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/wordsServlet")
public class WordsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数时进行null检查
        String words = req.getParameter("words");
        if (words == null) {
            // 如果参数为null，进行相应处理，这里简单返回一个提示信息
            PrintWriter writer = resp.getWriter();
            writer.write("参数words为null");
            writer.close();
            writer.close();
            return;
        }
        // 如果参数不为null，继续正常处理
        PrintWriter writer = resp.getWriter();
        writer.write(words);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里直接调用doPost方法，假设GET和POST请求的处理逻辑相同
        doPost(req, resp);
    }
}