package com.accp.shop.dao;
import java.sql.*;

import com.accp.shop.connection.*;
import com.accp.shop.pojo.Employee;
import java.util.*;

/**
 * @author ad
 *
 */
public class EmpDAO {


		/*连接数据库*/
        private	Connection con;
		String sql="select * from employee";
		String addsql="insert into employee(Emp_Name,Emp_Sex,Emp_Age,Emp_Date,Emp_Address,Emp_Tel,Dep_ID)values(?,?,?,?,?,?,?)";
		String modifysql="update employee set Emp_Name=?,Emp_Sex=?,Emp_Age=?,Emp_Date=?,Emp_Address=?,Emp_Tel=?,Dep_ID=? where Emp_ID=?";
		String checksql="select * from employee where Emp_ID=?";
		String delesql="delete from employee where Emp_ID=?";

		//构造方法
		public EmpDAO()
		{		
		}
	  /*
           CREATE TABLE `employee` (
           Emp_ID` int(4) NOT NULL auto_increment,
           Emp_Name` varchar(20) NOT NULL,
           Emp_Sex` char(2) NOT NULL,
           Emp_Age` int(4) NOT NULL,
  		   Emp_Date` date NOT NULL,
  		   Emp_Address` varchar(100) NOT NULL,
  		   Emp_Tel` varchar(10) default NULL,
 		   Dep_ID` char(4) NOT NULL,
  		   PRIMARY KEY  (`Emp_ID`))
	   */
		

	
		/**
		 * 检查用户名是否存在
		 * @param Emp_ID
		 * @return
		 */
		public Employee Check(String Emp_ID)
		{
			Employee employ=null;
			try{
				con=Connect.getConnection();
				}catch(Exception ex){
				ex.printStackTrace();
			}
			try{
				employ=new Employee();
				PreparedStatement ptmt=con.prepareStatement(checksql);
				ptmt.setString(1,Emp_ID);
				ResultSet rs=ptmt.executeQuery();
				if(rs.next())
				{
					employ.setEmp_ID(rs.getString(1));
					employ.setEmp_Name(rs.getString(2));
					employ.setEmp_Sex(rs.getString(3));
					employ.setEmp_Age(rs.getString(4));
					employ.setEmp_Date(rs.getString(5));
					employ.setEmp_Address(rs.getString(6));
					employ.setEmp_Tel(rs.getString(7));
					employ.setDep_ID(rs.getString(8));
					
				}
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				   try
				   {
				    if(con!=null)
				    con.close();
				   }
				   catch(Exception ex)
				   {
					   ex.printStackTrace();
				   }
			}
			return employ;
		}
		
		
		/**
		 * 用与修改已存在的员工信息
		 * @param employee
		 */
		public void modifyinfo(Employee employee)
		{	
			try{
				con=Connect.getConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try{
				PreparedStatement ptmt=con.prepareStatement(modifysql);
				ptmt.setString(1,employee.getEmp_Name());
				ptmt.setString(2, employee.getEmp_Sex());
				ptmt.setString(3, employee.getEmp_Age());
				ptmt.setString(4, employee.getEmp_Date());
				ptmt.setString(5, employee.getEmp_Address());
				ptmt.setString(6, employee.getEmp_Tel());
				ptmt.setString(7, employee.getDep_ID());
				ptmt.setString(8, employee.getEmp_ID());
//				System.out.println(employee.getDep_ID());
//				System.out.println(employee.getEmp_ID());
				ptmt.executeUpdate();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				try
				   {
				    if(con!=null)
				    con.close();
				   }
				   catch(Exception ex)
				   {
					   ex.printStackTrace();
				   }
			}
		}
		

		/**
		 * 用与删除员工信息
		 * @param employee
		 */
		public void deleinfo(Employee employee)
		{
			try{
				con=Connect.getConnection();
				//System.out.println("connection");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try{
				PreparedStatement ptmt=con.prepareStatement(delesql);
				ptmt.setString(1, employee.getEmp_ID());
				//System.out.println(employee.getEmpName());
				ptmt.executeUpdate();
				//System.out.println("ptmt");
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				try{
					if(con!=null)
					con.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		
		
		/**
		 * 用与处理增加员工信息
		 * @param employee
		 */
		public void addinfo(Employee employee)
		{
			try{
				con=Connect.getConnection();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			try{
				PreparedStatement ptmt=con.prepareStatement(addsql);
				ptmt.setString(1, employee.getEmp_Name());
				ptmt.setString(2,employee.getEmp_Sex());
				ptmt.setString(3,employee.getEmp_Age());
				ptmt.setString(4, employee.getEmp_Date());
				ptmt.setString(5, employee.getEmp_Address());
				ptmt.setString(6, employee.getEmp_Tel());
				ptmt.setString(7, employee.getDep_ID());
				ptmt.executeUpdate();
				con.close();
			
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			finally{
				try
				   {
				    if(con!=null)
				    con.close();
				   }
				   catch(Exception ex)
				   {
					   ex.printStackTrace();
				   }
			}
		}
		
		/**
		 * 有条件的选择员工
		 * @param field
		 * @param method
		 * @param key
		 * @return
		 */
		public ArrayList selectInfo(String field,String method,String key)
		{
			Employee employee=null;
			ArrayList list=new ArrayList();
			ResultSet rs=null;
			try{
				con=Connect.getConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println(method);
			if(method.equals("like")){
				//模糊查找
				try{
					PreparedStatement ptmt=con.prepareStatement("select * from employee where"+" "+field+" "+"like"+" "+"'%"+key+"%'");
//					ptmt.setString(1, key);
					rs=ptmt.executeQuery();
					while(rs.next()){
						employee=new Employee();
						employee.setEmp_ID(rs.getString(1));
						employee.setEmp_Name(rs.getString(2));
						employee.setEmp_Sex(rs.getString(3));
						employee.setEmp_Age(rs.getString(4));
						employee.setEmp_Date(rs.getString(5));
						employee.setEmp_Address(rs.getString(6));
						employee.setEmp_Tel(rs.getString(7));
						employee.setDep_ID(rs.getString(8));
						list.add(employee);
					}
					return list;
				}catch(Exception ex){
					ex.printStackTrace();
					return null;
				}
			}
			else{
				//精确查找
				try{
					PreparedStatement ptmt=con.prepareStatement("select * from employee where"+" "+field+"=?");
					ptmt.setString(1, key);
					rs=ptmt.executeQuery();
					while(rs.next()){
						employee=new Employee();
						employee.setEmp_ID(rs.getString(1));
						employee.setEmp_Name(rs.getString(2));
						employee.setEmp_Sex(rs.getString(3));
						employee.setEmp_Age(rs.getString(4));
						employee.setEmp_Date(rs.getString(5));
						employee.setEmp_Address(rs.getString(6));
						employee.setEmp_Tel(rs.getString(7));
						employee.setDep_ID(rs.getString(8));
						list.add(employee);
					}
					return list;
				}catch(Exception ex){
					ex.printStackTrace();
					return null;
				}finally{
					   try
					   {
					    if(con!=null)
					    con.close();
					   }
					   catch(Exception ex)
					   {
						   ex.printStackTrace();
					   }
				}
			}
		}
		
		
		/**
		 * 用与显示所有员工的基本信息
		 * @return
		 */
		public ArrayList  getInfo() 
		{
			Employee employee =null;
			ArrayList list=new ArrayList();
			ResultSet rs=null;
			try
			{
				con=Connect.getConnection();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			try{
				   PreparedStatement ptmt=con.prepareStatement(sql);
				   rs=ptmt.executeQuery();
				 
				  while(rs.next())
				   {
					  employee=new Employee();
					  employee.setEmp_ID(rs.getString(1));
					  employee.setEmp_Name(rs.getString(2));
					  employee.setEmp_Sex(rs.getString(3));
					  employee.setEmp_Age(rs.getString(4));
					  employee.setEmp_Date(rs.getString(5));
					  employee.setEmp_Address(rs.getString(6));
					  employee.setEmp_Tel(rs.getString(7));
					  employee.setDep_ID(rs.getString(8));
					  list.add(employee);
				   }
				  return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}
			finally{
				   try
				   {
				    if(con!=null)
				    con.close();
				   }
				   catch(Exception ex)
				   {
					   ex.printStackTrace();
				   }
			}
		}
	
	}
	

