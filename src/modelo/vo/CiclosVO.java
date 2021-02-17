package modelo.vo;

import java.util.ArrayList;
import java.util.List;


public class CiclosVO {
	
	private List<CicloVO> ciclos = new ArrayList<>();

    public List<CicloVO> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<CicloVO> ciclos) {
        this.ciclos = ciclos;
    }

    public void agregarCiclos(CicloVO ciclo) {
    	ciclos.add(ciclo);
	}
}
