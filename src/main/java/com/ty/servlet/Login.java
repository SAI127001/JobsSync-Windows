package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Userdao;


@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username=req.getParameter("username");
		String password= req.getParameter("pwd");
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		if(com.ty.dao.Login.isValidate(username, password)) {
		       req.getRequestDispatcher("aindex.html").forward(req, resp);
		}else if(Userdao.isValidate(username, password)) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Login Successfulyy');");  
			out.println("</script>");
  
         	req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		else {
			out.print("Make sure Username and Password is correct");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}


}
