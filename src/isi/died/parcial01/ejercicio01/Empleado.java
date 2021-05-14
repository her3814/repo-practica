package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public abstract interface Empleado {
	final Double SueldoBasico = 20000.00;
	
	abstract Integer getDni();

	abstract String getNombre();

	abstract String getEmail();

	abstract LocalDate getFechaContratacion();

	abstract void addGasto(Gasto g);

	abstract void aprobarGasto(Gasto g);

	abstract Double calcularSueldo();

}
