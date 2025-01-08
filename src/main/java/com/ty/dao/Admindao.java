package com.ty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ty.entity.job_entity;


public class Admindao {


	  public static int insert(job_entity je) throws SQLException {
		  
		  Connection connection=ConnectionPool.getConnectionObject();
		  String ins="insert into admin_job values(?,?,?,?,?,?,?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(ins);
		  preparedStatement.setInt(1, je.getId());
		  preparedStatement.setString(2,je.getCom_name());
		  preparedStatement.setString(3, je.getJob_role());
		  preparedStatement.setString(4, je.getJob_desc());
		  preparedStatement.setDouble(5, je.getA_exp());
		  preparedStatement.setDouble(6, je.getJob_package());
		  preparedStatement.setDouble(7, je.getBond());
		  preparedStatement.setInt(8, je.getVacancy());
		  Date date=je.getLast_date();
		  java.sql.Date date2=new java.sql.Date(date.getTime());
		  preparedStatement.setDate(9,date2);
		 int i= preparedStatement.executeUpdate();
		  ConnectionPool.receiveConnectionObject(connection);
		 return i;
	  }
	  
	  public static List<job_entity> read() throws SQLException{
		  Connection connection=ConnectionPool.getConnectionObject();
		  List<job_entity> list=new ArrayList<job_entity>();
		  String sel="select * from  admin_job";
		  PreparedStatement preparedStatement=connection.prepareStatement(sel);
		  ResultSet resultSet=preparedStatement.executeQuery();
		  while(resultSet.next()){
			  job_entity entity=new job_entity();
            entity.setId(resultSet.getInt(1));
            entity.setCom_name(resultSet.getString(2));
            entity.setJob_role(resultSet.getString(3));
            entity.setJob_desc(resultSet.getString(4));
            entity.setA_exp(resultSet.getDouble(5));
            entity.setJob_package(resultSet.getDouble(6));
            entity.setBond(resultSet.getDouble(7));
            entity.setVacancy(resultSet.getInt(8));
            entity.setLast_date(resultSet.getDate(9));
            list.add(entity);
           
		  }
		  ConnectionPool.receiveConnectionObject(connection);
		  return list;
	  }
	  
	  public static job_entity getselectbyid(int id) throws SQLException {
		   Connection connection=ConnectionPool.getConnectionObject();
		   String sel="select * from admin_job where id=?";
		   PreparedStatement preparedStatement=connection.prepareStatement(sel);
		   preparedStatement.setInt(1, id);
		   job_entity entity=new job_entity();
		   ResultSet resultSet=preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   entity.setId(resultSet.getInt(1));
	            entity.setCom_name(resultSet.getString(2));
	            entity.setJob_role(resultSet.getString(3));
	            entity.setJob_desc(resultSet.getString(4));
	            entity.setA_exp(resultSet.getDouble(5));
	            entity.setJob_package(resultSet.getDouble(6));
	            entity.setBond(resultSet.getDouble(7));
	            entity.setVacancy(resultSet.getInt(8));
	            entity.setLast_date(resultSet.getDate(9));
	           }
		   ConnectionPool.receiveConnectionObject(connection);
		   return entity;
				   
	  }
	  
	  public static int update(job_entity ue) throws SQLException {
		  Connection connection=ConnectionPool.getConnectionObject();
		  String ins="update admin_job set com_name=?,job_role=?,job_desc=?,a_exp=?,package=?,bond=?,vacancy=?,last_date=? where id=?";
		  
		  PreparedStatement preparedStatement=connection.prepareStatement(ins);
		  preparedStatement.setString(1,ue.getCom_name());
		  preparedStatement.setString(2, ue.getJob_role());
		  preparedStatement.setString(3, ue.getJob_desc());
		  preparedStatement.setDouble(4, ue.getA_exp());
		  preparedStatement.setDouble(5, ue.getJob_package());
		  preparedStatement.setDouble(6,ue.getBond());
		  preparedStatement.setInt(7, ue.getVacancy());
		  Date date=ue.getLast_date();
		  java.sql.Date date2=new java.sql.Date(date.getTime());
		  preparedStatement.setDate(8,date2);
		  preparedStatement.setInt(9, ue.getId());
		 int i= preparedStatement.executeUpdate();
		  ConnectionPool.receiveConnectionObject(connection);
		 return i;
	  }
	  
	  public static int delete(int id) throws SQLException {
		  Connection connection=ConnectionPool.getConnectionObject();
		  String del="delete from admin_job where id=?";
		  PreparedStatement preparedStatement=connection.prepareStatement(del);
		  preparedStatement.setInt(1, id);
		 int i= preparedStatement.executeUpdate();
		 return i;
	  }
	  
}
