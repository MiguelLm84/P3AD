package controlador;

import java.sql.SQLException;
import java.util.List;

import modelo.facade.ModuloFacade;
import modelo.vo.ModuloVO;
import vista.ModulosUI;

public class ModulosController extends ModulosUI {

	@Override
	protected void agregarModulo(String nom, int cur, int hrs, int idCiclo) {

		ModuloVO modulo = new ModuloVO(null, nom, cur, hrs, idCiclo);

		try {
			ModuloFacade.nuevoModulo(modulo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void editarModulo(Integer idModulo, String nom, int cur, int hrs, int idCiclo) {

		ModuloVO modulo = new ModuloVO(idModulo, nom, cur, hrs, idCiclo);

		try {
			ModuloFacade.actualizarModulo(modulo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarModulo(Integer idModulo) {

		try {
			ModuloFacade.eliminarModulo(idModulo);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	protected List<ModuloVO> transformarListaVO() {

		List<ModuloVO> listaModulos = null;
		try {
			listaModulos = ModuloFacade.listarModulo();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listaModulos;
	}
}
