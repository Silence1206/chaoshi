package com.accp.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.shop.dao.StorageDAO;

public class AddSell_Num extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddSell_Num() {
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
		String id=request.getParameter("cargo_id");
		//获取价格，在架商品数量，增加数量，库存数量
		String pri=request.getParameter("price");
		double price=Double.parseDouble(pri);
		
		String SellNum=request.getParameter("sell_num");
		int onSellNum=Integer.parseInt(SellNum);
		
		String num=request.getParameter("num");
		int addNum=Integer.parseInt(num);
		
		String storage=request.getParameter("storage_num");
		int storageNum=Integer.parseInt(storage);
		
//		String sql="update sell set Sell_Num="+"'"+onSellNum+addNum+"'"+",Sell_Price="+"'"+price+"'"+"where id="+"'"+id+"'";
//		out.print("update sell set Sell_Num="+"'"+onSellNum+addNum+"'"+",Sell_Price="+"'"+price+"'"+"where id="+"'"+id+"'");
		StorageDAO addsell=new StorageDAO();
		addsell.addSell_Num(id, onSellNum, price, addNum,storageNum);
		this.getServletContext().getRequestDispatcher("/StorageList").forward(request, response);
		
//		out.print(id+"<br>");
//		out.print(price+"<br>");
//		out.print(num+"<br>");
//		out.print(cargo_num+"<br>");
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
