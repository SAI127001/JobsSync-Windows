package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Admindao;

@WebServlet("/a_delete")

public class A_delete  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			int id=Integer.parseInt(req.getParameter("id"));
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			try {
				int i=Admindao.delete(id);
				if(i>0) {
					resp.sendRedirect("<h1>Delete</h1>");
				}
				else {
					resp.sendRedirect("<h1>Delete</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
