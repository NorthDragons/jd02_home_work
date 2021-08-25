package by.it_academy.home_work3.service;/* created by Kaminskii Ivan
 */

import by.it_academy.home_work3.service.api.BaseStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionService extends BaseStorage {

    public SessionService(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }


    @Override
    public String get(String key) {
        String val = req.getParameter(key);

        if (val == null) {
            HttpSession session = req.getSession();
            if (!session.isNew()) {
                val = (String) session.getAttribute(key);
            }
        }
        if (val == null) {
            throw new IllegalArgumentException("Не передан требуемый параметр");
        }
        return val;
    }

    @Override
    public void save(String key, String value) {
        HttpSession session = req.getSession();
        session.setAttribute(key, value);
    }
}
