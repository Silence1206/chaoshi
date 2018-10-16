package com.accp.shop.pojo;

public class CargoListPojo {
private  String cargo_id;
private String cargo_name;
private String cargo_type;
private int sell_num;
private double sell_price;

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
public int getSell_num() {
	return sell_num;
}
public void setSell_num(int sell_num) {
	this.sell_num = sell_num;
}
public double getSell_price() {
	return sell_price;
}
public void setSell_price(double sell_price) {
	this.sell_price = sell_price;
}
}
