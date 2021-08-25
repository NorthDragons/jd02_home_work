package by.it_academy.home_work3.service;/* created by Kaminskii Ivan
 */

import by.it_academy.home_work3.service.api.BaseStorage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CookieService extends BaseStorage {


    public CookieService(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }


    @Override
    public String get(String key) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return null;
        }
        String value = req.getParameter(key);
        if (value != null) {
            byte[] bytes = value.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
        value = Arrays.stream(cookies).filter(c -> key.equalsIgnoreCase(c.getName()))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(null);

        if (value != null) {
            return URLDecoder.decode(value, StandardCharsets.UTF_8);
        }
        return value;
    }

    @Override
    public void save(String key, String value) {
        Cookie myCookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));

        myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));

        resp.addCookie(myCookie);
    }


}
