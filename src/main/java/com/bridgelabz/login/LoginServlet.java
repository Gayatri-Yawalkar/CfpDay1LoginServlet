package com.bridgelabz.login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
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
		String password="(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&-+=()]).{8,}";
		if(Pattern.matches(userId, user) && Pattern.matches(password, pwd)) {
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