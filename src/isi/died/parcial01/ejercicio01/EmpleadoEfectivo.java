package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class EmpleadoEfectivo implements Empleado {

	private Integer dni;
	private String nombre;
	private LocalDate fechaContratacion;
	private String email;
	private List<Gasto> gastos;

	public EmpleadoEfectivo(Integer dni, String nombre, LocalDate fechaContratacion, String correo) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaContratacion = fechaContratacion;
		this.email = correo;

		this.gastos = List.copyOf(null);
	}

	@Override
	public Integer getDni() {
		return this.dni;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public LocalDate getFechaContratacion() {
		// TODO Auto-generated method stub
		return this.fechaContratacion;
	}

	@Override
	public void addGasto(Gasto g) {
		this.gastos.add(g);

	}

	@Override
	public void aprobarGasto(Gasto g) {
		this.gastos.stream().filter(gasto -> gasto.equals(g)).findFirst().ifPresent(gasto -> gasto.setAprobado());
	}

	@Override
	public Double calcularSueldo() {		
		
		Double totalGastosAprobados = this.gastos.stream()
												 .filter(g -> g.aprobado())
												 .mapToDouble(g -> g.getCosto())				
												 .sum();
		
		return ((this.SueldoBasico*0.86) + totalGastosAprobados);	

	}

}
