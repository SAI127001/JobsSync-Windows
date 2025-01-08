package com.ty.entity;


import java.util.Date;

public class job_entity {
	private int id;
	private String com_name;
	private String job_role;
	private String job_desc;
	private double a_exp;
	private double job_package;
	private double bond;
	private int vacancy;
	private Date last_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getJob_role() {
		return job_role;
	}
	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}
	public String getJob_desc() {
		return job_desc;
	}
	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}
	public double getA_exp() {
		return a_exp;
	}
	public void setA_exp(double a_exp) {
		this.a_exp = a_exp;
	}
	public double getJob_package() {
		return job_package;
	}
	public void setJob_package(double job_package) {
		this.job_package = job_package;
	}
	public double getBond() {
		return bond;
	}
	public void setBond(double bond) {
		this.bond = bond;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	
	
	
	

}

