package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Userdao;
import com.ty.entity.user_entity;

@WebServlet("/update")
public class update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user_entity employee=new user_entity();
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		employee.setId(id1);
		employee.setName(req.getParameter("name"));
		employee.setPassword(req.getParameter("pwd"));
		employee.setEmail(req.getParameter("mail"));
		employee.setMobile(Long.parseLong(req.getParameter("num")));
		employee.setQualification(req.getParameter("qual"));
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date date=dateFormat.parse(req.getParameter("yop"));
			employee.setYop(date);
			employee.setLocation(req.getParameter("loc"));
			employee.setSkill(req.getParameter("skills"));
			employee.setUser_exp(Double.parseDouble(req.getParameter("exp")));
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			int i=Userdao.update(employee);
			if(i>0) {
				resp.sendRedirect("u_Read.jsp");
			}
			else {
				resp.sendRedirect("index.jsp");
			}
			
		}catch (Exception e) {
			// TODO: handle exception

	}
}

	}
	

