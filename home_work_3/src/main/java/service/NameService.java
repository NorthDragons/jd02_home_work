package by.it_academy.home_work3.service;/* created by Kaminskii Ivan
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameService {

    private static final NameService instance = new NameService();
    private GetService service;

    private NameService() {
        this.service = GetService.getInstance();
    }
    public String getter(String key, HttpServletRequest req, HttpServletResponse resp){
       return service.getParam(key, req,resp);
    }


    public static NameService getInstance() {
        return instance;
    }

    public GetService getService() {
        return service;
    }
}
