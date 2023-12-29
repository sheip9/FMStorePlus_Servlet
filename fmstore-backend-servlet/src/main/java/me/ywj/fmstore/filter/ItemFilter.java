package me.ywj.fmstore.filter;
import me.ywj.fmstore.util.JWTUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/add", "/edit", "/del"})
public class ItemFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(! JWTUtil.verifyFromRequest((HttpServletRequest) request)) {
            ((HttpServletResponse) response).setStatus(401);
            return;
        }
        chain.doFilter(request, response);
    }
}
