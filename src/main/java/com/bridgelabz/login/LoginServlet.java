package com.bridgelabz.login;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);	
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		String userId=getServletConfig().getInitParameter("user");
		String password=getServletConfig().getInitParameter("password");
		if(userId.equals(user) && password.equals(pwd)) {
			req.setAttribute("user",user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		} else {
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out=resp.getWriter();
			out.println("<font color=red>Either User name or Password is Wrong.</font>");
	 		rd.include(req, resp);
		}
	}
}