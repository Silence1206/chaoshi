package com.accp.shop.pojo;

public class Employee implements java.io.Serializable {

	// ¹¹Ôìº¯Êý
	public Employee() {
		super();
	}

	/* Private Fields */
	private String emp_ID;

	private String emp_Name;

	private String emp_Sex;

	private String emp_Age;

	private String emp_Date;

	private String emp_Address;

	private String emp_Tel;

	private String dep_ID;

	public String getDep_ID() {
		return dep_ID;
	}

	public void setDep_ID(String dep_ID) {
		this.dep_ID = dep_ID;
	}

	public String getEmp_Address() {
		return emp_Address;
	}

	public void setEmp_Address(String emp_Address) {
		this.emp_Address = emp_Address;
	}

	public String getEmp_Age() {
		return emp_Age;
	}

	public void setEmp_Age(String emp_Age) {
		this.emp_Age = emp_Age;
	}

	public String getEmp_Date() {
		return emp_Date;
	}

	public void setEmp_Date(String emp_Date) {
		this.emp_Date = emp_Date;
	}

	public String getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_Sex() {
		return emp_Sex;
	}

	public void setEmp_Sex(String emp_Sex) {
		this.emp_Sex = emp_Sex;
	}

	public String getEmp_Tel() {
		return emp_Tel;
	}

	public void setEmp_Tel(String emp_Tel) {
		this.emp_Tel = emp_Tel;
	}

}
