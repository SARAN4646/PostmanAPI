package com.cms;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cms.models.Group;
import com.cms.services.GroupService;

@WebServlet("/groups")
public class GroupAPIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private GroupService groupService = new GroupService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupIdParam = request.getParameter("id");
        
        if (groupIdParam != null) {
            int groupId = Integer.parseInt(groupIdParam);
            Group group = groupService.getGroup(groupId);
            if (group != null) {
                response.getWriter().write(group.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.getWriter().write(groupService.getAllGroups().toString());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        
        if (name != null) {
            Group newGroup = new Group();
            newGroup.setName(name);
            groupService.addGroup(newGroup);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
