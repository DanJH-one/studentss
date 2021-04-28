package itheima.controller;

import itheima.domin.User;
import itheima.service.Uservice;
import itheima.service.impl.UserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Ucontroller", value = "/Ucontroller")
public class Ucontroller extends HttpServlet {
    private UserviceImpl uservice = new UserviceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if ("".equals(name) || name == null || "".equals(password) || password == null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        } else {
            findUserController(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //判断用户是否存在
    public void findUserController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String remeber = req.getParameter("remeber");
        User userService = uservice.findUserService(name, password);
        if (userService != null) {
            Cookie cookie = null;
            Cookie cookie1 = null;
            Cookie cookie2 = null;
            if (remeber != null) {
                String s = "checked";
                cookie = new Cookie("remeber", s);
                cookie1 = new Cookie("name", userService.getName());
                cookie2 = new Cookie("pass", userService.getPassword());
                cookie.setMaxAge(3600);
                cookie1.setMaxAge(3600);
                cookie2.setMaxAge(3600);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            } else {
                String s = "checked";
                cookie = new Cookie("remeber", s);
                cookie1 = new Cookie("name", userService.getName());
                cookie2 = new Cookie("pass", userService.getPassword());
                cookie.setMaxAge(-1);
                cookie1.setMaxAge(-1);
                cookie2.setMaxAge(-1);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            req.getSession().setAttribute("userService",userService);
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
    }
}
