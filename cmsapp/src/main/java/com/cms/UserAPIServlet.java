package com.cms;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.models.User;
import com.cms.services.UserService;

@WebServlet("/users")
public class UserAPIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserService userService = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdParam = request.getParameter("id");
        
        if (userIdParam != null) {
            int userId = Integer.parseInt(userIdParam);
            User user = userService.getUser(userId);
            if (user != null) {
                response.getWriter().write(user.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.getWriter().write(userService.getAllUsers().toString());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        if (name != null && email != null) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            userService.addUser(newUser);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

