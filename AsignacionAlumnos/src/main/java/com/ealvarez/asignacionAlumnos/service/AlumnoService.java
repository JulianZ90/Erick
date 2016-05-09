
package com.ealvarez.asignacionAlumnos.service;

import java.util.List;
import java.util.Set;

import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;

/**
 * @author Erik Alvarez
 * @version 1.0
 */
public interface AlumnoService {
	public long anadirAlumno(Alumno alumno);

	public Alumno actualizarAlumno(Alumno alumno);

	public void eliminarAlumno(long legajo);

	public List<Alumno> getAllAlumnos();

	public Alumno getAlumno(long legajo);

	public List<Alumno> getAllAlumnos(String nombreAlumno);

	public Set<Curso> getCursosAsignados(long legajo);
	
	public List<Curso> getCursosNoAsignados(long legajo);

	public void asignarCurso(long legajo, long nroCurso);
	
	public void desAsignarCurso(long legajo, long nroCurso);
}
