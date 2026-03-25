package org.example; // Tùy vào package của bạn

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tinh-toan")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strA = request.getParameter("numA");
        String strB = request.getParameter("numB");
        String op = request.getParameter("op");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double res = 0;

        if ("add".equals(op)) res = a + b;
        else if ("sub".equals(op)) res = a - b;
        else if ("mul".equals(op)) res = a * b;
        else if ("div".equals(op)) res = a / b;

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Kết quả là: " + res + "</h1>");
        response.getWriter().println("<br><a href='index.html'>Quay lại</a>");
    }
}