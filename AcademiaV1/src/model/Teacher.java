package model;

import java.io.Serializable;
import java.util.Date;

public class Teacher extends Human implements Serializable {
	private float sueldo;
	private int id;
	
	public Teacher(String name, String surname, Date bornDate, String dni, float sueldo) {
		super(name, surname, bornDate, dni);
		this.sueldo=sueldo;
		// TODO Auto-generated constructor stub
	}
	
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
