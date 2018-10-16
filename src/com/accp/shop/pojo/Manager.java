package com.accp.shop.pojo;

/**
 * @author ad
 *
 */
public class Manager implements java.io.Serializable{
	
	/**
	 *构造函数 
	 */
	public Manager()
	{
		super();
	}
	
	/**
	 * manager表中的字段
	 */
	private String mana_name;
	private String mana_pwd;
	private String popedom;
	private String mana_sex;
	private String mana_age;
	private String mana_dep;
	private String mana_tel;
	private String mana_address;
	public String getMana_address() {
		return mana_address;
	}
	public void setMana_address(String mana_address) {
		this.mana_address = mana_address;
	}
	public String getMana_age() {
		return mana_age;
	}
	public void setMana_age(String mana_age) {
		this.mana_age = mana_age;
	}
	public String getMana_dep() {
		return mana_dep;
	}
	public void setMana_dep(String mana_dep) {
		this.mana_dep = mana_dep;
	}
	public String getMana_name() {
		return mana_name;
	}
	public void setMana_name(String mana_name) {
		this.mana_name = mana_name;
	}
	public String getMana_pwd() {
		return mana_pwd;
	}
	public void setMana_pwd(String mana_pwd) {
		this.mana_pwd = mana_pwd;
	}
	public String getMana_sex() {
		return mana_sex;
	}
	public void setMana_sex(String mana_sex) {
		this.mana_sex = mana_sex;
	}
	public String getMana_tel() {
		return mana_tel;
	}
	public void setMana_tel(String mana_tel) {
		this.mana_tel = mana_tel;
	}
	public String getPopedom() {
		return popedom;
	}
	public void setPopedom(String popedom) {
		this.popedom = popedom;
	}
	
	
	

}
