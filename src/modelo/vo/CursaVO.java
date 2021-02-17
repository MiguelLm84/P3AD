package modelo.vo;

public class CursaVO {

	private String anho;
	private float nota;
	private String dni;
	private int idModulo;
	
	public CursaVO(String anho, float nota,String dni, int idModulo) {
		this.anho=anho;
		this.nota=nota;
		this.dni=dni;
		this.idModulo=idModulo;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public CursaVO() {
		
	}
	
	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}


	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
}

	