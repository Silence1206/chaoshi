package com.accp.shop.servlet;
import com.accp.shop.dao.*;
import com.accp.shop.pojo.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckServlet() {
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

		String Emp_ID=request.getParameter("Emp_ID");
		EmpDAO dao=new EmpDAO();
		Employee emp=dao.Check(Emp_ID);
		String id=emp.getEmp_ID();
		String name=emp.getEmp_Name();
		String sex=emp.getEmp_Sex();
		String age=emp.getEmp_Age();
		String time=emp.getEmp_Date();
		String address=emp.getEmp_Address();
//		System.out.println(address);
		String tel=emp.getEmp_Tel();
		String dep=emp.getDep_ID();
		if(Emp_ID.equals(id)){
			//System.out.println("dfdfd");
			request.setAttribute("id",id);
			request.setAttribute("name",name);
			request.setAttribute("sex",sex);
			request.setAttribute("age", age);
			request.setAttribute("time", time);
			request.setAttribute("address", address);
			request.setAttribute("tel", tel);
			request.setAttribute("dep", dep);
			this.getServletContext().getRequestDispatcher("/ModifyInfo.jsp").forward(request,response);	
		}
		else{
			//System.out.println("Else");
			PrintWriter out = response.getWriter();
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
