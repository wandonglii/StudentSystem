/**
 * 
 */
package com.gem.student.entity;

import java.util.Date;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月25日 上午8:49:16
 * @Description: 
 */
public class Student {
	private Integer id;
	private String sname;
	private String sage;
	private String sgender;
	private Date birthday;
	public Student() {
		super();
	}
	
	public Student(Integer id, String sname, String sage, String sgender, Date birthday) {
		super();
		this.id = id;
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.birthday = birthday;
	}

	public Student(String sname, String sage, String sgender, Date birthday) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sage=" + sage + ", sgender=" + sgender + ", birthday="
				+ birthday + "]";
	}
}
