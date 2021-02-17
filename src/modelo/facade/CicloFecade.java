package modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.CicloVO;

public class CicloFecade {
	
	public CicloFecade() {
		
	}

	public static void nuevoCiclo(CicloVO ciclo) throws SQLException, ClassNotFoundException {
			
		Connection conexion=ConexionBD.getConexion();
		Statement sentencia=conexion.createStatement();
		sentencia.executeUpdate("INSERT INTO escuela.ciclo (idModulo,nombre,nivel,curso) VALUES ("+ciclo.getId()+",'"+ciclo.getNombre()+"',"+ciclo.getNivel()+","+ciclo.getCurso()+")");
		sentencia.close();
		conexion.close();
	}
			
			
	public static List<CicloVO> listarCiclo() throws SQLException, ClassNotFoundException {
			
		List<CicloVO> ciclos=new ArrayList<CicloVO>();
		Connection conexion=ConexionBD.getConexion();
		Statement sentencia=conexion.createStatement();
		ResultSet resultado=sentencia.executeQuery("SELECT idCiclo,nombre,nivel,curso FROM escuela.ciclo ORDER BY nombre");
		while(resultado.next()) {
			CicloVO ciclo=new CicloVO();
			ciclo.setId(resultado.getInt("idCiclo"));
			ciclo.setNombre(resultado.getString("nombre"));
			ciclo.setNombre(resultado.getString("nivel"));
			ciclo.setNombre(resultado.getString("curso"));
			ciclos.add(ciclo);
		}
		sentencia.close();
		conexion.close();
		
		return ciclos;			
	}
		
	public static void actualizarAlumno(CicloVO ciclo) throws ClassNotFoundException, SQLException {
			
		Connection conexion=ConexionBD.getConexion();
		Statement sentencia=conexion.createStatement();
		sentencia.executeUpdate("UPDATE escuela.ciclo SET nombre="+ciclo.getNombre()+" WHERE idCiclo="+ciclo.getId());
		sentencia.close();
		conexion.close();
	}
		
	public static void eliminarAlumno(CicloVO ciclo) throws ClassNotFoundException, SQLException {
			
		Connection conexion=ConexionBD.getConexion();
		Statement sentencia=conexion.createStatement();
		sentencia.executeUpdate("DELETE FROM WHERE idCiclo="+ciclo.getId());
		sentencia.close();
		conexion.close();
	}			
}
