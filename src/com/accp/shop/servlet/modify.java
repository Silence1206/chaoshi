package com.accp.shop.servlet;

import com.accp.shop.dao.*;
import com.accp.shop.pojo.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modify extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public modify() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		emp.setEmp_ID(request.getParameter("id"));
		emp.setEmp_Name(request.getParameter("name"));
		emp.setEmp_Sex(request.getParameter("sex"));
		emp.setEmp_Age(request.getParameter("age"));
		emp.setEmp_Date(request.getParameter("time"));
		emp.setEmp_Address(request.getParameter("address"));
		emp.setEmp_Tel(request.getParameter("tel"));
		emp.setDep_ID(request.getParameter("dep"));
		try{
			EmpDAO dao=new EmpDAO();
			dao.modifyinfo(emp);
			this.getServletContext().getRequestDispatcher("/EmployeeServlet").forward(request, response);
//			System.out.println("close()");
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
