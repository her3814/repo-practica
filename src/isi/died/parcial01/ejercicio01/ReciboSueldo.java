package isi.died.parcial01.ejercicio01;

import java.time.YearMonth;

public class ReciboSueldo {
	private Long numeroRecibo;
	private Empleado empleado;
	private YearMonth mesAnioLiquidacion;
	private Double MontoPago;

	
	public ReciboSueldo(Long numeroRecibo, Empleado e, YearMonth fechaLiq, Double monto) {
		this.numeroRecibo=numeroRecibo;
		this.empleado=e;
		this.mesAnioLiquidacion=fechaLiq;
		this.MontoPago=monto;
	}
	
}
