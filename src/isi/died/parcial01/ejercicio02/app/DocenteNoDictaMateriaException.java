package isi.died.parcial01.ejercicio02.app;

import isi.died.parcial01.ejercicio02.dominio.Docente;
import isi.died.parcial01.ejercicio02.dominio.Materia;

public class DocenteNoDictaMateriaException extends Exception {

	private static final long serialVersionUID = 7073076285732458931L;

	public DocenteNoDictaMateriaException(Docente d, Materia m) {
		super("El docente " + d.getNombre() + " no dicta la materia " + m.getNombre());
	}
}
