package by.it_academy.home_work3.controllers.web.servlets;/* created by Kaminskii Ivan
 */

import by.it_academy.home_work3.model.PersonDto;
import by.it_academy.home_work3.service.NameService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "NameServlet", urlPatterns = "/registration")
public class NameServlet extends HttpServlet {

    private final NameService nameService;

    public NameServlet() {
        this.nameService = NameService.getInstance();
    }

    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String AGE_PARAM_NAME = "age";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //получаем значение из req о имени
        String firstName = nameService.getter(FIRST_NAME_PARAM_NAME,req,resp);
        String lastName = nameService.getter(LAST_NAME_PARAM_NAME, req, resp);
        int age = Integer.parseInt(nameService.getter(AGE_PARAM_NAME, req, resp));


        PersonDto person = new PersonDto(firstName, lastName, age);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        writePerson(person, resp);

    }


    private void writePerson(PersonDto person, HttpServletResponse resp) throws IOException {
        Writer writer = resp.getWriter();
        writer.write("<p><span style='color: rad;'>FirstName: " + person.getFirstName() + "</br>" +
                "LastName: " + person.getLastName() + "</br>" +
                "Age: " + person.getAge() + "</span></p>");
    }
}


//        String firstNameVal = CookieHelper.getSomeValue(req, FIRST_NAME_PARAM_NAME);
//        CookieHelper.saveCookie(resp, FIRST_NAME_PARAM_NAME, firstNameVal);
//
//        String lastNameVal = CookieHelper.getSomeValue(req, LAST_NAME_PARAM_NAME);
//        CookieHelper.saveCookie(resp, LAST_NAME_PARAM_NAME, lastNameVal);
//        SessionHelper.saveSession(req, FIRST_NAME_PARAM_NAME, firstNameVal);
//        SessionHelper.saveSession(req, LAST_NAME_PARAM_NAME, lastNameVal);
//    private IStorage getStorage(HttpServletRequest req, HttpServletResponse resp) {
//        String storageHeader = req.getHeader(STORAGE_TYPE_HEADER);
//        if (storageHeader == null) {
//            throw new IllegalArgumentException("storage not found");
//        }
//        switch (storageHeader) {
//            case COOKIE_STORAGE:
//                return new CookieStorage(req, resp);
//            case SESSION_STORAGE:
//                return new SessionStorage(req, resp);
//            default:
//                throw new IllegalArgumentException("storage not found");
//        }
//    }