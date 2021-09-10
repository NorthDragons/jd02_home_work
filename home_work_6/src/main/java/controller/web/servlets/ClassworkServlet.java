package controller.web.servlets;/* created by Kaminskii Ivan
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "classwork", urlPatterns = "/classwork")
public class ClassworkServlet extends HttpServlet {
    private final ObjectMapper mapper =new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employer employer= mapper.readValue(req.getInputStream(), Employer.class);
    }
}
