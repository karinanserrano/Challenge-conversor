package listas;

import java.util.ArrayList;

import logica.Objeto;

public class Lista {
	
	private ArrayList<Objeto> objs;
	private String nombre;
	
	public Lista(String nombre) {
		objs = new ArrayList();
		this.nombre=nombre;
	}
	
	public void agregar(Objeto o) {
		objs.add(o);
	}
	
	public int getTamanio() {
		return objs.size();
	}
	
	public Objeto obtenerObjeto(int i) {
		return objs.get(i);
	}
	
	public String obtenerNombreLista() {
		return this.nombre;
	}

}
