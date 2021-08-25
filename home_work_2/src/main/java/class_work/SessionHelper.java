package by.it_academy.home_work2.class_work;/* created by Kaminskii Ivan
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class SessionHelper {

    protected static String getSomeValue(HttpServletRequest req, String key) {
        String val = req.getParameter(key);

        if (val == null) {
            Cookie[] cookies = req.getCookies();

            if (cookies != null) {
                val = Arrays.stream(cookies).filter(c -> key.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }
        if (val == null) {
            throw new IllegalArgumentException("Не передан требуемый параметр");
        }
        return val;
    }


    protected static void saveSession(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession(false);
        session.setAttribute(key, val);
    }

}
