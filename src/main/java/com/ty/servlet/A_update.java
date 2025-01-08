package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.Admindao;
import com.ty.entity.job_entity;

@WebServlet("/a_update")

public class A_update  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		job_entity job = new job_entity();
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		job.setId(id1);
		job.setCom_name(req.getParameter("cname"));
		job.setJob_role(req.getParameter("jr"));
		job.setJob_desc(req.getParameter("jd"));
		job.setA_exp(Double.parseDouble(req.getParameter("exp")));
		job.setJob_package(Double.parseDouble(req.getParameter("package")));
		job.setBond(Double.parseDouble(req.getParameter("bond")));
		job.setVacancy(Integer.parseInt(req.getParameter("vac")));
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
	
			Date date;
			try {
				date = dateFormat.parse(req.getParameter("ld"));
				job.setLast_date(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			int i;
			try {
				i = Admindao.update(job);
				if(i>0) {
					resp.sendRedirect("read.jsp");
				}
				else {
					resp.sendRedirect("<h1>Data not update</h1>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}


	}
	

