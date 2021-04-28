package itheima.controller;

import itheima.domin.Student;
import itheima.dto.PageInfo;
import itheima.service.impl.StudentServiceIpml;
import itheima.util.XUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "StuController", value = "/StuController")
public class StuController extends HttpServlet {
    private StudentServiceIpml stuser = new StudentServiceIpml();
    private Integer pageSize = 10;//页面显示的条数

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> set = parameterMap.keySet();
        for (String s : set) {
            String[] strings = parameterMap.get(s);
            if (strings[0].equals("cshsj")) {
                showStu(req, resp);
                return;
            }
            if (strings[0].equals("tjsj")) {
                insertStudent(req, resp);
                return;
            }
            if (strings[0].equals("xzsj")) {
                Donlwd(req, resp);
                return;
            }
            if (strings[0].equals("sscz")) {
                findDanStu(req, resp);
                return;
            }
            if (strings[0].equals("me")) {
                delete(req, resp);
                return;
            }
            if (strings[0].equals("upde")) {
                updete(req, resp);
                return;
            }
            if (strings[0].equals("findAll")){
                findAll(req,resp);
                return;
            }
        }
    }

    //初始化数据方法
    public void showStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         stuser.showstuSer();
        findAll(req, resp);
        /*  req.getSession().setAttribute("list", list);*/
        /* resp.sendRedirect(req.getContextPath() + "/login.jsp");*/
    }

    //添加数据方法
    public void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String source = req.getParameter("source");
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        student.setSource(Integer.valueOf(source));
        UUID uuid = UUID.randomUUID();
        student.setSid(String.valueOf(uuid));
        stuser.inserStuService(student);
        /* List<Student> all = findAll();*/
        findAll(req, resp);
        /* req.getSession().setAttribute("list", all);*/
        /* resp.sendRedirect(req.getContextPath() + "/login.jsp");*/
    }

    //查询所有学生分页方法
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
   /*     String pageNum = req.getParameter("pageNum");
        Integer num = 1;
        List<Student> all = stuser.findAll();
        if (pageNum != null && !"".equals(pageNum)) {
            num=Integer.valueOf(pageNum);
        }
        if (all.size()>0){
            PageInfo list= XUtils.getCurrentPageData(num, pageSize, all);
            req.getSession().setAttribute("list", list);
        }

        resp.sendRedirect(req.getContextPath() + "/login.jsp");*/
        //获取参数
        String pageNumstr = request.getParameter("pageNum");
        //默认显示页码为1
        int pageNum = 1;
        if (pageNumstr != null && !"".equals(pageNumstr)) {
            pageNum = Integer.parseInt(pageNumstr);
            System.out.println(pageNum);
        }
        //查询所有数据
        List<Student> students = stuser.findAll();
        //如果文件不存在或者文件中没有数据
        if (students.size() > 0) {
            //获取到指定页面数据
            PageInfo pageInfo = XUtils.getCurrentPageData(pageNum, pageSize, students);
            //把分页数据保存在会话域
            HttpSession session = request.getSession();
            session.setAttribute("list", pageInfo);

        }
        //跳转到列表页面
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    //下载数据方法
    public void Donlwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UUID uuid = UUID.randomUUID();
        //3.设置响应消息头
        resp.setHeader("Content-Type", "application/octet-stream");//注意下载的时候，设置响应正文的MIME类型，用application/octet-stream
        resp.setHeader("Content-Disposition", "attachment;filename=" + uuid + ".txt");//告知浏览器以下载的方式打开
        List<Student> all = stuser.findAll();
        PrintWriter writer = resp.getWriter();
        for (Student student : all) {
            writer.write(student.getName() + "," + student.getAge() + "," + student.getSource());
            writer.write("<br>");
        }
    }

    //搜索方法
    public void findDanStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("pageNum");
        System.out.println(parameter);
        int num = 1;
        if (parameter != null && !"".equals(parameter)) {
            num = Integer.valueOf(parameter);
        }
        List<Student> all = stuser.findAll();
        String name = req.getParameter("ss");
        List<Student> listStu = new ArrayList<>();
        if (all != null && all.size() != 0) {
            for (Student student : all) {
                if (student.getName().contains(name)) {
                    Student student1 = new Student();
                    student1.setName(student.getName());
                    student1.setAge(student.getAge());
                    student1.setSource(student.getSource());
                    student1.setSid(student.getSid());
                    listStu.add(student1);
                }
            }
            PageInfo currentPageData = XUtils.getCurrentPageData(num, pageSize, listStu);
            req.getSession().setAttribute("list", currentPageData);
        }

       /* if (listStu == null || listStu.size() == 0) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }*/
      /*  PageInfo currentPageData = XUtils.getCurrentPageData(num, pageSize, listStu);
        req.getSession().setAttribute("list", currentPageData);*/
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    //删除方法
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dele = req.getParameter("dele");
       stuser.deleStu(dele);
        findAll(req, resp);
      /*  req.getSession().setAttribute("list", list);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");*/
    }

    //更新方法
    public void updete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String source = req.getParameter("source");
        /*if ("".equals(name) || "".equals(age) || "".equals(source)) {
            req.getRequestDispatcher("/updae.jsp").forward(req, resp);
            return;
        }*/
        String sid = req.getParameter("sid");
        stuser.updete(name, age, source, sid);
        findAll(req, resp);
    /*    req.getSession().setAttribute("listStu", list);
        resp.sendRedirect(req.getContextPath() + "/login.jsp");*/
    }
}
