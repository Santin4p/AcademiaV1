package model.student;

import java.io.Serializable;
import java.util.Date;

import javax.rmi.CORBA.Util;
import javax.xml.crypto.Data;

import model.Human;

public class Student extends Human implements Serializable  {
	private String comments;
	private int id;
	
	
	public Student(String name, String surname, String dni,
			Date bornDate, String comments, int id) {
		super(name, surname, bornDate, dni);
		this.comments=comments;
		this.id=id;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
//	@Override
//	public String toString() {
//		return String.format("%s %s %s", id);
//	}
}
