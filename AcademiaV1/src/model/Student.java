package model;

import java.io.Serializable;
import java.util.Date;

import javax.rmi.CORBA.Util;
import javax.xml.crypto.Data;

public class Student implements Serializable {
	private String name;
	private String surname;
	private Date bornDate;
	private String comments;
	private String dni;
	private int id;
	
	
	public Student(String name, String surname, String dni,
			Date bornDate, String comments, int id) {
		super();
		this.name=name;
		this.surname=surname;
		this.dni=dni;
		this.bornDate=bornDate;
		this.comments=comments;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", name,surname,id);
	}
}
