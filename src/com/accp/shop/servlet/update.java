package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.providerDAO;
import com.accp.shop.pojo.provider;

public class update extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public update() {
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

		provider pro1=new provider();

		String id=request.getParameter("id");
		String typeViewId=request.getParameter("typeViewId");
	        pro1.setPro_Name(request.getParameter("name"));
	        pro1.setPro_Tel(request.getParameter("tel"));
	        pro1.setPro_Address(request.getParameter("address"));
	        pro1.setCargo_Type(request.getParameter("type"));
	      pro1.setPro_Date(request.getParameter("date"));
	        if(id!=null){
	  
	        try
	        {
	        	//实例话DAO
	         providerDAO proBean=new providerDAO();
	         //調用
	           proBean.update(pro1,id);
	        }
	        catch(Exception e)		
	        {
	        	e.printStackTrace();
	         request.setAttribute("errorMessage","在创建新用户时出错！可能因为用户已经存在，请重新再试。错误信息="+e.getMessage()+"!");
	        	
	        }
//	        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newProviders.jsp");
	        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("proLogin");
         requestDispatcher.forward(request,response);
	}
	        if(typeViewId!=null){
	      	  
		        try
		        {
		        	//实例话DAO
		         providerDAO proBean=new providerDAO();
		         //調用
		           proBean.update(pro1,typeViewId);
		        }
		        catch(Exception e)		
		        {
		        	e.printStackTrace();
		         request.setAttribute("errorMessage","在创建新用户时出错！可能因为用户已经存在，请重新再试。错误信息="+e.getMessage()+"!");
		        	
		        }
//		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newProviders.jsp");
		        javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("proTypeView");
	         requestDispatcher.forward(request,response);  
	        }}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
