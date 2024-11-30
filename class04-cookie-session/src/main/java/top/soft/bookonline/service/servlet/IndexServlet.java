package top.soft.bookonline.service.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.impl.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl() ;
        // 查询所有图书
        List<Book>books=bookService.getBooks();
        // 将数据保存到request域中
        req.setAttribute("bookList",books);
        //跳转到首页
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
