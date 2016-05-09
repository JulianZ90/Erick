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
import com.ealvarez.asignacionAlumnos.service.AlumnoService;

/**
 * @author Erik Alvarez
 * @version 1.0
 */
@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	public AlumnoServiceImpl() {
		System.out.println("AlumnoServiceImpl()");
	}

	@Autowired
	private AlumnoDAO alumnoDAO;
	@Autowired
	private CursoDAO cursoDAO;

	@Override
	public long anadirAlumno(Alumno alumno) {
		return alumnoDAO.anadirAlumno(alumno);
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return alumnoDAO.actualizarAlumno(alumno);
	}

	@Override
	public void eliminarAlumno(long legajo) {
		alumnoDAO.eliminarAlumno(legajo);
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return alumnoDAO.getAllAlumnos();
	}

	@Override
	public Alumno getAlumno(long legajo) {
		return alumnoDAO.getAlumno(legajo);
	}

	@Override
	public List<Alumno> getAllAlumnos(String nombreAlumno) {
		return alumnoDAO.getAllAlumnos(nombreAlumno);
	}

	@Override
	public Set<Curso> getCursosAsignados(long legajo) {
		return alumnoDAO.getCursosAsignados(legajo);
	}

	@Override
	public List<Curso> getCursosNoAsignados(long legajo) {
		List<Curso> CursosNoAsignados = cursoDAO.getAllCursos();
		Set<Curso> cursosAsignados = getCursosAsignados(legajo);
		for (Curso cursoAsignado : cursosAsignados) {
			CursosNoAsignados.remove(cursoAsignado);
		}
		return CursosNoAsignados;

	}

	@Override
	public void asignarCurso(long legajo, long nroCurso) {
		Alumno alumno = alumnoDAO.getAlumno(legajo);
		Curso curso = cursoDAO.getCurso(nroCurso);
		if (!alumno.getCursos().contains(curso)) {
			alumno.getCursos().add(curso);
			alumnoDAO.actualizarAlumno(alumno);
		}
	}

	@Override
	public void desAsignarCurso(long legajo, long nroCurso) {
		Alumno alumno = alumnoDAO.getAlumno(legajo);
		Curso curso = cursoDAO.getCurso(nroCurso);
		alumno.getCursos().remove(curso);
		alumnoDAO.actualizarAlumno(alumno);
	}

}
