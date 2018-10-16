package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.CargoListDAO;

public class SearchInf extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchInf() {
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

		String tj=request.getParameter("tiaojian");
		String inf=request.getParameter("keyword");
//		System.out.println(Integer.parseInt(tj));
		CargoListDAO cargo=new CargoListDAO();
		if("mohu".equals(tj)){
			ArrayList list=cargo.blurSearch(inf);
			request.setAttribute("array", list);
			this.getServletContext().getRequestDispatcher("/CargoList.jsp").forward(request, response);
			return;
			
		}else if("key".equals(tj)){
			String kyw=request.getParameter("guanjian");
			System.out.println(kyw);
			System.out.println(inf);
			System.out.println("Select cargo.Cargo_ID, cargo.Cargo_Name, cargo.Cargo_Type, sell.Sell_Num, sell.Sell_Price From cargo, sell Where cargo.Cargo_ID = sell.Cargo_ID and "+kyw+"="+"'"+inf+"'");
			ArrayList list=cargo.rigourSearch(kyw, inf);
			request.setAttribute("array", list);
			this.getServletContext().getRequestDispatcher("/CargoList.jsp").forward(request, response);
			return;
			
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
