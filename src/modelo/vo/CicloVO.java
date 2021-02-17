package modelo.vo;


public class CicloVO {
	
	private Integer id;
    private String nombre;
    private int nivel;
    private String curso;

    public CicloVO() {

    }

    public CicloVO(Integer id, String nombre,  int nivel, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
