package isi.died.parcial01.ejercicio01;

import java.time.YearMonth;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RRHH {

	public List<ReciboSueldo> LiquidarSueldos(List<Empleado> empleados){
		
		var r = new Random();
		
		return empleados.stream().map(e -> 
			new ReciboSueldo( r.nextLong(),e, YearMonth.now(), e.calcularSueldo())
		).collect(Collectors.toList());
	}
}
