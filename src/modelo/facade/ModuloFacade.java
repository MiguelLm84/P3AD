package modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.ModuloVO;

public class ModuloFacade {

	private ModuloFacade() {
	}

	public static void nuevoModulo(ModuloVO modulo) throws SQLException, ClassNotFoundException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("INSERT INTO escuela.modulo (nombre,curso,horas,idCiclo) VALUES ('" + modulo.getNombre()
				+ "'," + modulo.getCurso() + "," + modulo.getHoras() + "," + modulo.getIdCiclo() + ")");
		sentencia.close();
		conexion.close();
	}

	public static List<ModuloVO> listarModulo() throws SQLException, ClassNotFoundException {

		List<ModuloVO> modulos = new ArrayList<ModuloVO>();
		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia
				.executeQuery("SELECT idModulo,nombre,curso,horas,idCiclo FROM escuela.modulo ORDER BY nombre");
		while (resultado.next()) {
			int id = resultado.getInt("idModulo");
			String nombre = resultado.getString("nombre");
			int curso = resultado.getInt("curso");
			int horas = resultado.getInt("horas");
			int idCiclo = resultado.getInt("idCiclo");
			modulos.add(new ModuloVO(id, nombre, curso, horas, idCiclo));

		}
		sentencia.close();
		conexion.close();

		return modulos;

	}

	public static void actualizarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("UPDATE escuela.modulo SET nombre= '" + modulo.getNombre() + "', curso="
				+ modulo.getCurso() + ", horas=" + modulo.getHoras() + ", idCiclo=" + modulo.getIdCiclo()
				+ " WHERE idModulo=" + modulo.getId());
		sentencia.close();
		conexion.close();
	}

	public static void eliminarModulo(int idModulo) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM escuela.modulo WHERE idModulo=" + idModulo);
		sentencia.close();
		conexion.close();
	}
}
