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

@WebServlet("/a_Registration")


public class A_insert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		job_entity job = new job_entity();
		job.setId(Integer.parseInt(req.getParameter("id")));
		job.setCom_name(req.getParameter("cname"));
		job.setJob_role(req.getParameter("jr"));
		job.setJob_desc(req.getParameter("jd"));
		job.setJob_package(Double.parseDouble(req.getParameter("package")));
		job.setBond(Double.parseDouble(req.getParameter("bond")));
		job.setA_exp(Double.parseDouble(req.getParameter("exp")));
		job.setVacancy(Integer.parseInt(req.getParameter("vac")));
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date date=dateFormat.parse(req.getParameter("ld"));
			job.setLast_date(date);
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html");
			
			
			int i=Admindao.insert(job);
			if(i>0) {
				req.getRequestDispatcher("joblist.jsp").forward(req, resp);
			}
			else {
				out.print("<h1>Please try again/h1>");
				req.getRequestDispatcher("job.html").include(req, resp);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
