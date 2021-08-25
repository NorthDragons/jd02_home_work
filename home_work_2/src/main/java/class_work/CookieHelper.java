package by.it_academy.home_work2.class_work;/* created by Kaminskii Ivan
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CookieHelper {

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

    protected static void saveCookie(HttpServletResponse resp, String key, String val) {

        Cookie myCookie = new Cookie(key, URLEncoder.encode(val, StandardCharsets.UTF_8));

        myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));

        resp.addCookie(myCookie);
    }


}
