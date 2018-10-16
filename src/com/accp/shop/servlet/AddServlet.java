package com.accp.shop.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.EmpDAO;
import com.accp.shop.pojo.Employee;


public class AddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp=new Employee();
		emp.setEmp_Name(request.getParameter("name"));
		emp.setEmp_Sex(request.getParameter("sex"));
		emp.setEmp_Age(request.getParameter("age"));
		emp.setEmp_Date(request.getParameter("time"));
		emp.setEmp_Address(request.getParameter("address"));
		emp.setEmp_Tel(request.getParameter("tel"));
		emp.setDep_ID(request.getParameter("dep"));
		try{
			//System.out.println("fdfsdfds");
			EmpDAO dao=new EmpDAO();
			dao.addinfo(emp);
			this.getServletContext().getRequestDispatcher("/EmployeeServlet").forward(request, response);
//			PrintWriter out=response.getWriter();
//			response.setContentType("text/html");
//			response.setCharacterEncoding("gb2312");
//			out.println("已成功加入一条记录！");
		}catch(Exception ex){
			ex.printStackTrace();
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
