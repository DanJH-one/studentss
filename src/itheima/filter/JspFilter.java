package itheima.filter;

import itheima.domin.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.File;
import java.io.IOException;

@WebFilter(filterName = "JspFilter",value = {"/updae.jsp","/show.jsp","/login.jsp","/add.jsp"})
public class JspFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        User user = (User) request.getSession().getAttribute("userService");
        if (user==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
