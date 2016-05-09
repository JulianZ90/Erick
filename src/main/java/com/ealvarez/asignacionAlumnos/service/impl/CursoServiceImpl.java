package com.ealvarez.asignacionAlumnos.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ealvarez.asignacionAlumnos.dao.AlumnoDAO;
import com.ealvarez.asignacionAlumnos.dao.CursoDAO;
import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;
import com.ealvarez.asignacionAlumnos.service.CursoService;

/**
 * @author Erik Alvarez
 * @version 1.0
 */
@Service
@Transactional
public class CursoServiceImpl implements CursoService {

	public CursoServiceImpl() {
		System.out.println("CursoServiceImpl()");
	}

	@Autowired
	private CursoDAO cursoDAO;
	@Autowired
	private AlumnoDAO alumnoDAO;

	@Override
	public long anadirCurso(Curso curso) {
		return cursoDAO.anadirCurso(curso);
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		return cursoDAO.actualizarCurso(curso);
	}

	@Override
	public void eliminarCurso(long nroCurso) {
		cursoDAO.eliminarCurso(nroCurso);
	}

	@Override
	public List<Curso> getAllCursos() {
		return cursoDAO.getAllCursos();
	}

	@Override
	public Curso getCurso(long nroCurso) {
		return cursoDAO.getCurso(nroCurso);
	}

	@Override
	public List<Curso> getAllCursos(String nombreCurso) {
		return cursoDAO.getAllCursos(nombreCurso);
	}

	@Override
	public Set<Alumno> getAlumnosAsignados(long nroCurso) {
		return cursoDAO.getAlumnosAsignados(nroCurso);
	}

	@Override
	public void asignarAlumno(long nroCurso, long legajo) {
		Alumno alumno = alumnoDAO.getAlumno(legajo);
		Curso curso = cursoDAO.getCurso(nroCurso);
		if (!alumno.getCursos().contains(curso)) {
			alumno.getCursos().add(curso);
			alumnoDAO.actualizarAlumno(alumno);
		}
	}

	@Override
	public void desAsignarAlumno(long nroCurso, long legajo) {
		Alumno alumno = alumnoDAO.getAlumno(legajo);
		Curso curso = cursoDAO.getCurso(nroCurso);
		alumno.getCursos().remove(curso);
		alumnoDAO.actualizarAlumno(alumno);
	}

}
