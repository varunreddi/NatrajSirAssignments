package com.varun.dto;

import java.io.Serializable;

public class CoronaPatientDTO implements Serializable{
	
	private Integer cpno;
	private String name;
	private String addr;
	private Double pdc;
	private Integer noofdays;
	
	public Integer getCpno() {
		return cpno;
	}
	public void setCpno(Integer cpno) {
		this.cpno = cpno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Double getPdc() {
		return pdc;
	}
	public void setPdc(Double pdc) {
		this.pdc = pdc;
	}
	public Integer getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(Integer noofdays) {
		this.noofdays = noofdays;
	}
	
	

}
