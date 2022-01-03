package mk.ukim.finki.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath();

        String color = (String) request.getSession().getAttribute("color");

        if(!"/balloons".equals(path) && color == null && !"/h2".equals(path)
        && !path.contains("/balloons/edit-form") && !"/balloons/add".equals(path)
        && !path.contains("/balloons/delete") && !"/balloons/add-form".equals(path)){
            response.sendRedirect("/balloons");
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
