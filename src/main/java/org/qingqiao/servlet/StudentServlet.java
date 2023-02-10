package org.qingqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.qingqiao.bean.Course;
import org.qingqiao.bean.Student;
import org.qingqiao.service.StudentService;
import org.qingqiao.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hj
 * @data 2023/2/9 14:17
 */
@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
    StudentService service = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        String m = req.getParameter("m");
        if ("queryAll".equals(m)){
            queryAll(req,resp);
        } else if ("getCourse".equals(m)){
            getCourse(req,resp);
        } else if ("insert".equals(m)){
            insert(req,resp);
        } else if ("queryById".equals(m)){
            queryById(req,resp);
        } else if ("update".equals(m)){
            update(req,resp);
        } else if ("delete".equals(m)){
            delete(req,resp);
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int i = service.delete(id);
        resp.getWriter().print(i > 0);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String[] cids = req.getParameterValues("cids");
        Student student = new Student(Integer.parseInt(id),name,sex,Integer.parseInt(age),null);
        int i = service.update(student,cids);
        resp.getWriter().print(i > 0);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Student student = service.queryById(id);
        String s = JSON.toJSONString(student);
        resp.getWriter().print(s);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String[] cids = req.getParameterValues("cids");
        Student student = new Student(null,name,sex,Integer.parseInt(age),null);
        int i = service.insert(student,cids);
        resp.getWriter().print(i > 0);
    }

    private void getCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Course> list = service.getCourse();
        String s = JSON.toJSONString(list);
        resp.getWriter().print(s);
    }

    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = service.queryAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("student/list.jsp").forward(req, resp);
    }
}
