package isi.died.parcial01.ejercicio02.app;

import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;

public class InscribirAlumnoCursadaDbException extends Exception {
	
	private static final long serialVersionUID = 7584215343812248858L;

	public InscribirAlumnoCursadaDbException(BaseDeDatosExcepcion o) {
		super("Hubo un problema al inscribir el alumno en la base de datos >>> "+o.toString());
	}
}
