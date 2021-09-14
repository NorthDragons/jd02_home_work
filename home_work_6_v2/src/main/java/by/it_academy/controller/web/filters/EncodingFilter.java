package by.it_academy.controller.web.filters;/* created by Kaminskii Ivan
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private static String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("encofing")!=null){
            encoding = filterConfig.getInitParameter("encoding");
        }else {
            encoding="UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if(encoding==null){
            throw new IllegalArgumentException("Ошибка EncodingFilter");
        }
        response.setCharacterEncoding(encoding);
        request.setCharacterEncoding(encoding);
        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }
}
