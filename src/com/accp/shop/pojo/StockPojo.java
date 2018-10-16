package com.accp.shop.pojo;

import java.sql.Date;

public class StockPojo {
	private String cargo_id;
	private String cargo_name;
	private String cargo_type;
	private int stock_num;
	private double stock_price;
	private Date stock_date;
	private String pro_id;
	private String mana_name;
	public String getCargo_id() {
		return cargo_id;
	}
	public void setCargo_id(String cargo_id) {
		this.cargo_id = cargo_id;
	}
	public String getCargo_name() {
		return cargo_name;
	}
	public void setCargo_name(String cargo_name) {
		this.cargo_name = cargo_name;
	}
	public String getCargo_type() {
		return cargo_type;
	}
	public void setCargo_type(String cargo_type) {
		this.cargo_type = cargo_type;
	}
	public String getMana_name() {
		return mana_name;
	}
	public void setMana_id(String mana_name) {
		this.mana_name = mana_name;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public Date getStock_date() {
		return stock_date;
	}
	public void setStock_date(Date stock_date) {
		this.stock_date = stock_date;
	}
	public int getStock_num() {
		return stock_num;
	}
	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}
	public double getStock_price() {
		return stock_price;
	}
	public void setStock_price(double stock_price) {
		this.stock_price = stock_price;
	}
	
	

}
