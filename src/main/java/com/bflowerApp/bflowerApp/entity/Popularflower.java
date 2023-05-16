package com.bflowerApp.bflowerApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="MyPopular")
public class Popularflower {

	@Id 
	private int id;
	private String fname;
	private String fprice;
	private String fdesc;
	public Popularflower(int id, String fname, String fprice, String fdesc) {
		super();
		this.id = id;
		this.fname = fname;
		this.fprice = fprice;
		this.fdesc = fdesc;
	}
	public Popularflower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFprice() {
		return fprice;
	}
	public void setFprice(String fprice) {
		this.fprice = fprice;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
}
