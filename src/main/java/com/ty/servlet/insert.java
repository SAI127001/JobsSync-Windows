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

import com.ty.dao.Userdao;
import com.ty.entity.user_entity;

@WebServlet("/Registration")

public class insert  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	user_entity entity =new user_entity();
    	entity.setName(req.getParameter("name"));
    	entity.setPassword(req.getParameter("pwd"));
    	entity.setEmail(req.getParameter("mail"));
    	entity.setMobile(Long.parseLong(req.getParameter("num")));
    	entity.setQualification(req.getParameter("qual"));
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
    	
    	PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
    	try {
    		Date date=dateFormat.parse(req.getParameter("yop"));
    		entity.setYop(date);
    		entity.setLocation(req.getParameter("loc"));
    		entity.setSkill(req.getParameter("skills"));
    		entity.setUser_exp(Double.parseDouble(req.getParameter("exp")));
    		
    		
    		
    		int i=Userdao.insert(entity);
    		if(i>0) {
    			out.println("<script type=\"text/javascript\">");  
    			out.println("alert('Register Successfulyy');");  
    			out.println("</script>");
    			 resp.sendRedirect("login.html");
    		}
    		else {
    			out.println("<script type=\"text/javascript\">");  
    			out.println("alert('Register not Successfulyy');");  
    			out.println("</script>");
    			req.getRequestDispatcher("register.html").include(req, resp);
    		}
    		

    	}  catch (SQLException e) {
			// TODO Auto-generated catch block
    		out.print("Duplicate data not inserted");
    		req.getRequestDispatcher("user_register.jsp").include(req, resp);
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    }
	
}
