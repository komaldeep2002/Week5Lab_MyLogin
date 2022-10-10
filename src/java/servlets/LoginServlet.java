package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String logout = request.getParameter("logout");

        //logging out users
        //message "You have successfully logged out"
        if (logout != null) {
            session.invalidate();
            request.setAttribute("res", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (username != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the username, pw 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        //validate if text is empty
        if (username == null || password == null || username.equals("") || password.equals("")) {
            request.setAttribute("res", "Invalid login.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        //pass name, pw to the class
        //return not-null->store name as session var and redirect home
        //return invalid->store previous enter and forward login
        AccountService as = new AccountService();
        if (as.login(username, password) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home");
        } else {
            request.setAttribute("res", "Failed authentication");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }
}