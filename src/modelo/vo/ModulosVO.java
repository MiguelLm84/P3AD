package modelo.vo;

import java.util.ArrayList;
import java.util.List;

public class ModulosVO {
    private List<ModuloVO> modulos = new ArrayList<>();

    public List<ModuloVO> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloVO> modulos) {
        this.modulos = modulos;
    }

    public void agregarModulo(ModuloVO modulo) {
    	modulos.add(modulo);
	}
}
