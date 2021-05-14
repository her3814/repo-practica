package isi.died.parcial01.ejercicio02.db;

public class BaseDeDatosExcepcion extends Exception {

	public BaseDeDatosExcepcion() {
		super("Hubo un problema al guardar el dato en la base de datos");
	}

	public BaseDeDatosExcepcion(Object o) {
		super("Hubo un problema al guardar el dato en la base de datos >>> " + o.toString());
	}
}
