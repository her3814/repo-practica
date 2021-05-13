package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;
import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws InscribirAlumnoCursadaDbException, DocenteNoDictaMateriaException {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		
		if(m.getDocentes().contains(d))
			throw new DocenteNoDictaMateriaException(d,m);
		
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);

		try {
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			throw new InscribirAlumnoCursadaDbException(e);
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	
	public void retistrarNota(Alumno a, Examen e, Integer nota) {		
		e.setNota(nota);		
		
		Inscripcion i = a.getLastInscripcion(e.getMateria());
		
		if(nota >= 6)
			i.setEstado(Estado.PROMOCIONADO);
	}


	@Override
	public Double promedioAprobados(Materia m) {
		Predicate<Examen> examenAprobado = (examen) -> (examen.getNota() >= 6);	
		
		return m.getExamenes().stream()
							  .filter(e -> e.getMateria().equals(m))
							  .filter(examenAprobado)
							  .mapToDouble(e -> e.getNota())
							  .average()
							  .getAsDouble();
	}


	@Override
	public List<Alumno> inscriptos(Materia m, Integer ciclo) {
		return m.getInscripciones().stream()
							.filter(i-> i.getCicloLectivo().equals(ciclo))
							.map(i -> i.getInscripto())
							.sorted((a,b) -> a.getNombre().compareTo(b.getNombre()))
							.collect(Collectors.toList());	

	}
	

}
