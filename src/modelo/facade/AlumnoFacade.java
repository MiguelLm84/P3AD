package modelo.facade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.AlumnoVO;

public class AlumnoFacade {

	public AlumnoFacade() {

	}

	public static void nuevoAlumno(AlumnoVO alumno) throws SQLException, ClassNotFoundException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("INSERT INTO escuela.alumno (dni,nombre,apellido1,apellido2,telefono,fecha_naci) VALUES ('" + alumno.getDni() + "','" + alumno.getNombre() + "' ,'"
				+ alumno.getApellido1() + "','" + alumno.getApellido2() + "'," + alumno.getTelefono() + ",'"
				+ new Date(alumno.getFechaNaci().getTime()) + "')");
		sentencia.close();
		conexion.close();
	}

	public static List<AlumnoVO> listarAlumno() throws SQLException, ClassNotFoundException {

		List<AlumnoVO> alumnos = new ArrayList<AlumnoVO>();
		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery(
				"SELECT dni,nombre,apellido1,apellido2,telefono,fecha_naci FROM escuela.alumno ORDER BY nombre");
		while (resultado.next()) {
			AlumnoVO alu = new AlumnoVO();

			alu.setDni(resultado.getString("dni"));
			alu.setNombre(resultado.getString("nombre"));
			alu.setApellido1(resultado.getString("apellido1"));
			alu.setApellido2(resultado.getString("apellido2"));
			alu.setTelefono(resultado.getInt("telefono"));
			alu.setFechaNaci(resultado.getDate("fecha_naci"));
			alumnos.add(alu);
		}
		sentencia.close();
		conexion.close();

		return alumnos;
	}

	public static void actualizarAlumno(AlumnoVO alumno) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("UPDATE escuela.alumno SET nombre='" + alumno.getNombre() + "', apellido1='"
				+ alumno.getApellido1() + "', apellido2='" + alumno.getApellido2() + "', telefono=" + alumno.getTelefono()
				+ ", fecha_naci='" + new Date(alumno.getFechaNaci().getTime()) + "' WHERE dni='" + alumno.getDni()+"'");
		sentencia.close();
		conexion.close();
	}

	public static void eliminarAlumno(String dni) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM WHERE dni='" + dni+"'");
		sentencia.close();
		conexion.close();
	}
}
