package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.shop.dao.StockDAO;
import com.accp.shop.dao.StorageDAO;

public class Stock extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Stock() {
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
		//获取进货页面传来的值
		String id=request.getParameter("id");
		String cargoName=request.getParameter("cargoName");
		String cargoType=request.getParameter("cargoType");
		String stock_Num=request.getParameter("stockNum");
		int stockNum=Integer.parseInt(stock_Num);
		String Price=request.getParameter("stockPrice");
		double stockPrice=Double.parseDouble(Price);
		String providerID=request.getParameter("providerID");
		
		HttpSession session=request.getSession();
		String manaName=(String)session.getAttribute("manager");
		
		StockDAO stock=new StockDAO();
		boolean exist=stock.checkCargoID(id);
		//判断是否是新的商品
		if(exist){
			int oldNum=new StorageDAO().getStorageNum(id);
			//跟新库存信息,将进货信息插入进货表
			stock.stockInf(id,oldNum,stockNum,stockPrice, providerID,manaName);
			
			this.getServletContext().getRequestDispatcher("/StorageList").forward(request, response);
			return;
		}else{
			//是新的商品，将商品信息添加到cargo、storage、stock表中
			stock.newStockInf(id, cargoName, cargoType, stockNum, stockPrice, providerID, manaName);
			this.getServletContext().getRequestDispatcher("/StorageList").forward(request, response);
			
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
