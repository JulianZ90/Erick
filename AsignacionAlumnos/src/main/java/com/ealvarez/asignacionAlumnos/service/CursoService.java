
package com.ealvarez.asignacionAlumnos.service;

import java.util.List;
import java.util.Set;

import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;

/**
 * @author Erik Alvarez
 * @version 1.0
 */
public interface CursoService {
	public long anadirCurso(Curso curso);

	public Curso actualizarCurso(Curso curso);

	public void eliminarCurso(long nroCurso);

	public List<Curso> getAllCursos();

	public Curso getCurso(long nroCurso);

	public List<Curso> getAllCursos(String nombreCurso);

	public Set<Alumno> getAlumnosAsignados(long nroCurso);

	public void asignarAlumno(long nroCurso, long legajo);

	public void desAsignarAlumno(long nroCurso, long legajo);
}
