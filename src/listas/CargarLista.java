package listas;

import java.util.ArrayList;

import logica.Objeto;

public class CargarLista {
	
	//a dolar
	//a euros
	// a libras esterlinas
	// a yen japones
	//a won sul-coreano
	
	private static Lista monedas(){
		Lista lm= new Lista("valores");
		lm.agregar(new Objeto("Peso", "Pesos Argentinos", 1));
		lm.agregar(new Objeto("Dolar", "Dolares",0.00365));
		lm.agregar(new Objeto("Euro", "Euros",0.00284));
		lm.agregar(new Objeto("Libra", "Libras Esterlinas", 0.00332));
		lm.agregar(new Objeto("Yen", "Yenes", 0.5157));
		lm.agregar(new Objeto("Won", "Wons", 4.65));
		return lm;
	}
	
	private static Lista distancias(){
		Lista d= new Lista("distancia");
		d.agregar(new Objeto("metro", "metros", 1));
		d.agregar(new Objeto("milimetro", "milimetros", 1000));
		d.agregar(new Objeto("decimetro", "decimetros", 10));
		d.agregar(new Objeto("centimetro", "centimeros", 100));
		d.agregar(new Objeto("decametro", "decametros", 0.1));
		d.agregar(new Objeto("kilometro", "kilimetros", 0.001));
		return d;
	}
	
	private ArrayList<Lista>listado;
	
	public CargarLista() {
		listado = new ArrayList();
		listado.add(monedas());
		listado.add(distancias());
	}
	
	public Lista getLista(int i) {
		return listado.get(i);
	}
	
	
	
	
	
	

}
