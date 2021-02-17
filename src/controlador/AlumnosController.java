package controlador;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import modelo.facade.AlumnoFacade;
import modelo.facade.CursaFacade;
import modelo.vo.AlumnoVO;
import modelo.vo.CursaVO;
import vista.AlumnosUI;

public class AlumnosController extends AlumnosUI{
	

	public AlumnosController(int idModulo) {
		super(idModulo);
		
	}

	@Override
	protected void agregarAlumno(String dni, String nom, String ap1, String ap2, int telefono, Date fechaNaci) {

		AlumnoVO alumno = new AlumnoVO(dni, nom, ap1, ap2, telefono,fechaNaci);

		try {
			AlumnoFacade.nuevoAlumno(alumno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void editarAlumno(String dni, String nom, String ap1, String ap2, int telefono, Date fechaNaci) {

		AlumnoVO alumno = new AlumnoVO(dni, nom, ap1, ap2, telefono, fechaNaci);

		try {
			AlumnoFacade.actualizarAlumno(alumno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarAlumno(String dni) {

		
		try {
			AlumnoFacade.eliminarAlumno(dni);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	protected List<AlumnoVO> transformarListaVO() {

		List<AlumnoVO> listaAlumnos = null;
		try {
			listaAlumnos = AlumnoFacade.listarAlumno();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
	}
	
	@Override
	protected void agregarCursa(String anho, float nota, String dni, int idModulo) {

		CursaVO cursa = new CursaVO(anho, nota, dni, idModulo);

		try {
			CursaFacade.nuevoCursa(cursa);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void editarCursa(String anho, float nota, String dni, int idModulo) {

		CursaVO cursa = new CursaVO(anho, nota, dni, idModulo);

		try {
			CursaFacade.actualizarCursa(cursa);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarCursa(int idModulo, String dni) {

		try {
			CursaFacade.eliminarCursa(idModulo, dni);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	protected List<CursaVO> listarCursa() {

		List<CursaVO> listaCursa = null;
		try {
			listaCursa = CursaFacade.listarCursa();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listaCursa;
	}
}
