package com.ty.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.entity.user_entity;

public class Userdao {

	  public static int insert(user_entity ue) throws SQLException {
		  
		  Connection connection=ConnectionPool.getConnectionObject();
		  String ins="insert into user_register values(NEXTVAL('u_id'),?,?,?,?,?,?,?,?,?)";
		  PreparedStatement preparedStatement=connection.prepareStatement(ins);
		  preparedStatement.setString(1,ue.getName());
		  preparedStatement.setString(2, ue.getPassword());
		  preparedStatement.setString(3, ue.getEmail());
		  preparedStatement.setLong(4, ue.getMobile());
		  preparedStatement.setString(5, ue.getQualification());
		  Date date=ue.getYop();
		  java.sql.Date date2=new java.sql.Date(date.getTime());
		  preparedStatement.setDate(6,date2);
		  preparedStatement.setString(7, ue.getLocation());
		  preparedStatement.setString(8, ue.getSkill());
		  preparedStatement.setDouble(9, ue.getUser_exp());
		 int i= preparedStatement.executeUpdate();
		  ConnectionPool.receiveConnectionObject(connection);
		 return i;
	  }
	  
	  public static List<user_entity> read() throws SQLException{
		  Connection connection=ConnectionPool.getConnectionObject();
		  List<user_entity> list=new ArrayList<user_entity>();
		  String sel="select * from  user_register";
		  PreparedStatement preparedStatement=connection.prepareStatement(sel);
		  ResultSet resultSet=preparedStatement.executeQuery();
		  while(resultSet.next()){
			  user_entity entity=new user_entity();
              entity.setId(resultSet.getInt(1));
              entity.setName(resultSet.getString(2));
              entity.setPassword(resultSet.getString(3));
              entity.setEmail(resultSet.getString(4));
              entity.setMobile(resultSet.getLong(5));
              entity.setQualification(resultSet.getString(6));
              entity.setYop(resultSet.getDate(7));
              entity.setLocation(resultSet.getString(8));
              entity.setSkill(resultSet.getString(9));
              entity.setUser_exp(resultSet.getDouble(10));
              list.add(entity);
             
		  }
		  ConnectionPool.receiveConnectionObject(connection);
		  return list;
	  }
	  
	  public static user_entity getselectbyid(int id) throws SQLException {
		   Connection connection=ConnectionPool.getConnectionObject();
		   String sel="select * from user_register where id=?";
		   PreparedStatement preparedStatement=connection.prepareStatement(sel);
		   preparedStatement.setInt(1, id);
		   user_entity entity=new user_entity();
		   ResultSet resultSet=preparedStatement.executeQuery();
		   while(resultSet.next()) {
			      entity.setId(resultSet.getInt(1));
	              entity.setName(resultSet.getString(2));
	              entity.setPassword(resultSet.getString(3));
	              entity.setEmail(resultSet.getString(4));
	              entity.setMobile(resultSet.getLong(5));
	              entity.setQualification(resultSet.getString(6));
	              entity.setYop(resultSet.getDate(7));
	              entity.setLocation(resultSet.getString(8));
	              entity.setSkill(resultSet.getString(9));
	              entity.setUser_exp(resultSet.getDouble(10));
		   }
		   ConnectionPool.receiveConnectionObject(connection);
		   return entity;
				   
	  }
	  
	  public static int update(user_entity ue) throws SQLException {
		  Connection connection=ConnectionPool.getConnectionObject();
		  String ins="update user_register set name=?,password=?,email=?,mobile=?,qualification=?,yop=?,location=?,skill=?,u_exp=? where id=?";
		  
		  PreparedStatement preparedStatement=connection.prepareStatement(ins);
		  preparedStatement.setString(1,ue.getName());
		  preparedStatement.setString(2, ue.getPassword());
		  preparedStatement.setString(3, ue.getEmail());
		  preparedStatement.setLong(4, ue.getMobile());
		  preparedStatement.setString(5, ue.getQualification());
		  Date date=ue.getYop();
		  java.sql.Date date2=new java.sql.Date(date.getTime());
		  preparedStatement.setDate(6,date2);
		  preparedStatement.setString(7, ue.getLocation());
		  preparedStatement.setString(8, ue.getSkill());
		  preparedStatement.setDouble(9, ue.getUser_exp());
		  preparedStatement.setInt(10, ue.getId());
		 int i= preparedStatement.executeUpdate();
		  ConnectionPool.receiveConnectionObject(connection);
		 return i;
	  }
	  
	  public static int delete(int id) throws SQLException {
		  Connection connection=ConnectionPool.getConnectionObject();
		  String del="delete from user_register where id=?";
		  PreparedStatement preparedStatement=connection.prepareStatement(del);
		  preparedStatement.setInt(1, id);
		 int i= preparedStatement.executeUpdate();
		 return i;
	  }
	  
	  public static boolean isValidate(String username, String password) {
			boolean result= false;
			Connection connection= ConnectionPool.getConnectionObject();
			String sql= "select * from user_register where name=? and password=?";
			try {
				PreparedStatement ps= connection.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					result= true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
	  
}
