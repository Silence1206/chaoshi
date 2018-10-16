package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.StorageDAO;

public class AddSell_new extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddSell_new() {
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

		//获取上个页面传过来的商品编号，商品名称，商品类型，上架数量，上架的价格，库存数量
		String id=request.getParameter("id");
		String cargoName=request.getParameter("name");
		String cargoType=request.getParameter("type");
		String sell_Num=request.getParameter("addNum");
		int addNum=Integer.parseInt(sell_Num);
		
		String sell_Price=request.getParameter("price");
		double price=Double.parseDouble(sell_Price);
		String num=request.getParameter("storageNum");
		int storageNum=Integer.parseInt(num);
		StorageDAO storage=new StorageDAO();
		storage.idNotExistOnSell(id,cargoName,cargoType,addNum,price,storageNum);
//		System.out.println(id);
//		System.out.println(cargoName);
//		System.out.println(cargoType);
//		System.out.println(addNum);
//		System.out.println(price);
//		System.out.println(storageNum);
		this.getServletContext().getRequestDispatcher("/CargoListConf").forward(request, response);
		
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
