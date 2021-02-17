package modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.vo.CursaVO;

public class CursaFacade {

	public CursaFacade() {

	}

	public static void nuevoCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("INSERT INTO escuela.cursa (anho,nota,idModulo, dni) VALUES ('" + cursa.getAnho() + "',"
				+ cursa.getNota() + "," + cursa.getIdModulo() + ",'" + cursa.getDni() + "')");
		sentencia.close();
		conexion.close();
	}

	public static List<CursaVO> listarCursa() throws ClassNotFoundException, SQLException {

		List<CursaVO> cursan = new ArrayList<CursaVO>();
		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		ResultSet resultado = sentencia.executeQuery("SELECT anho,nota,dni,idModulo FROM escuela.cursa ORDER BY anho");
		while (resultado.next()) {
			CursaVO cursa = new CursaVO();
			cursa.setAnho(resultado.getString("anho"));
			cursa.setNota(resultado.getFloat("nota"));
			cursa.setDni(resultado.getString("dni"));
			cursa.setIdModulo(resultado.getInt("idModulo"));
			cursan.add(cursa);
		}
		sentencia.close();
		conexion.close();

		return cursan;

	}

	public static void actualizarCursa(CursaVO cursa) throws SQLException, ClassNotFoundException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("UPDATE escuela.cursa SET anho='" + cursa.getAnho() + "',nota=" + cursa.getNota()
				+ " WHERE idModulo=" + cursa.getIdModulo() + " AND dni='" + cursa.getDni() + "'");
		sentencia.close();
		conexion.close();

	}

	public static void eliminarCursa(int idModulo, String dni) throws ClassNotFoundException, SQLException {

		Connection conexion = ConexionBD.getConexion();
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM escuela.cursa WHERE idModulo=" + idModulo + " AND dni='" + dni + "'");
		sentencia.close();
		conexion.close();
	}
}
