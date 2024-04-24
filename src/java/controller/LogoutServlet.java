package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usuwa sesję użytkownika
        HttpSession session = request.getSession(false); // false oznacza, że nie tworzymy nowej sesji, jeśli nie istnieje
        if (session != null) {
            session.invalidate(); // unieważnia sesję, usuwając wszelkie atrybuty związane z sesją
        }
        response.sendRedirect("dashboard"); // przekierowuje na stronę logowania po wylogowaniu
    }
}
