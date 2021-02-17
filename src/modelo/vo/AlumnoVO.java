package modelo.vo;

import java.util.Date;

public class AlumnoVO {
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono;
	private Date fechaNaci;
	
	public AlumnoVO() {
		
	}
	
	public AlumnoVO(String dni, String nom, String ap1, String ap2, int telefono, Date fechaNaci) {
		
		this.dni=dni;
		this.nombre=nom;
		this.apellido1=ap1;
		this.apellido2=ap2;
		this.telefono=telefono;
		this.fechaNaci=fechaNaci;
	}
	
	public Date getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(Date fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
