package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

public class Gasto {
	private Long nroComprobante;
	private String descripcion;
	private boolean gastoAprobado;
	private Double totalGasto;
	private LocalDate fechaGasto;

	public Gasto(Long nroComprobante, String descripcion, Double totalGasto) {
		this.nroComprobante = nroComprobante;
		this.descripcion = descripcion;
		this.gastoAprobado = false;
		this.totalGasto = totalGasto;
		this.fechaGasto= LocalDate.now();
	}

	public void setAprobado() {
		this.gastoAprobado = true;
	}

	public boolean aprobado() {
		return this.gastoAprobado;
	}

	public Double getCosto() {
		return this.totalGasto;
	}

	@Override
	public String toString() {
		return "Gasto N° " + this.nroComprobante + ": " + this.descripcion + " por un costo de: " + this.totalGasto;
	}
	
	public LocalDate getFechaGasto() {
		return this.fechaGasto;
	}

}
