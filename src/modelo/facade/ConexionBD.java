package modelo.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
	
	private final static String CADENA_CONEXION="jdbc:mysql://localhost:3306/escuela";
	private final static String USUARIO="root";
	private final static String CONTRASENA="Psa23540";
	
	private static Connection conexion=null;
	
	public static Connection getConexion() throws ClassNotFoundException, SQLException {
		if(conexion==null||conexion.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENA);
		}
		return conexion;
	}
}
