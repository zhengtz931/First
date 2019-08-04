package service;

import java.awt.GradientPaint;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import com.sun.xml.internal.bind.v2.runtime.Name;

import action.StudentLogin;
import action.ceshi;
import entity.user;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
	
		try {
			if(StudentLogin.login(number, password))
			{
				request.setCharacterEncoding("utf-8");
				System.out.println("登录成功");
				double[] grade = ceshi.grade(number);
				user u = new user();
				u.setGrade(grade);
				u.setNumber(number);
				request.getSession().setAttribute("reguser", u);
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
