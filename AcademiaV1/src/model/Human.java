package model;

import java.io.Serializable;
import java.util.Date;

public class Human implements Serializable {
	private String name;
	private String surname;
	private Date bornDate;
	private String dni;
	
	public Human(String name, String surname, Date bornDate, String dni) {
		super();
		this.name = name;
		this.surname = surname;
		this.bornDate = bornDate;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + "]";
	}

}
