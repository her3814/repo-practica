package isi.died.parcial01.ejercicio02.app;

import java.util.List;

import isi.died.parcial01.ejercicio02.dominio.*;



public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d);
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 * @throws InscribirAlumnoCursadaDbException 
	 * @throws DocenteNoDictaMateriaException 
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo) throws InscribirAlumnoCursadaDbException, DocenteNoDictaMateriaException;

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m);
	
	/**
	 * 
	 * @param m
	 * @return calcula para una materia el promedio de todos los examenes, pero teniendo en cuenta solo aquellos que fueron aprobados.
	 */
	public Double promedioAprobados(Materia m);
	
	/**
	 * 
	 * @return lista de inscriptos anotados en una materia ordenada alfabeticamente
	 */
	List<Alumno> inscriptos(Materia m,Integer ciclo);
	
}
