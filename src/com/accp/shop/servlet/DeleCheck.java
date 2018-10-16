package com.accp.shop.servlet;

import com.accp.shop.dao.*;
import com.accp.shop.pojo.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleCheck extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleCheck() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	EmpDAO dao=null;
	Employee emp=null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Emp_ID=request.getParameter("Emp_ID");
		System.out.println(Emp_ID);
		dao=new EmpDAO();
		emp=dao.Check(Emp_ID);
		String emp_ID=emp.getEmp_ID();
		if(Emp_ID.equals(emp_ID)){
			//request.setAttribute("name",name);
			//this.getServletContext().getRequestDispatcher("/DeleServlet").forward(request, response);
			emp=new Employee();
			emp.setEmp_ID(Emp_ID);
			dao=new EmpDAO();
			dao.deleinfo(emp);
			this.getServletContext().getRequestDispatcher("/EmployeeServlet").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.println("不存在此员工！");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
