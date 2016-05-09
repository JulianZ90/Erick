/**
 * 
 */
package com.ealvarez.asignacionAlumnos.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ealvarez.asignacionAlumnos.dao.CursoDAO;
import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;
import com.ealvarez.asignacionAlumnos.util.HibernateUtil;

/**
 * @author Erik Alvarez
 * @version 1.0
 */

@Repository
public class CursoDAOImpl implements CursoDAO {

	public CursoDAOImpl() {
		System.out.println("CursoDAOImpl");
	}

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long anadirCurso(Curso curso) {
		return (Long) hibernateUtil.create(curso);
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		return hibernateUtil.update(curso);
	}

	@Override
	public void eliminarCurso(long nroCurso) {
		Curso curso = new Curso();
		curso.setNroCurso(nroCurso);
		hibernateUtil.delete(curso);
	}

	@Override
	public List<Curso> getAllCursos() {
		return hibernateUtil.fetchAll(Curso.class);
	}

	@Override
	public Curso getCurso(long nroCurso) {
		return hibernateUtil.fetchById(nroCurso, Curso.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> getAllCursos(String nombreCursoBusqueda) {
		String query = "SELECT e.* FROM CURSO e WHERE e.nombreCurso like '%" + nombreCursoBusqueda + "%'";
		List<Object[]> objetosCurso = hibernateUtil.fetchAll(query);
		List<Curso> cursos = new ArrayList<Curso>();
		for (Object[] objetoCurso : objetosCurso) {
			Curso curso = new Curso();
			long nroCurso = ((BigInteger) objetoCurso[0]).longValue();
			int capacidad = (int) objetoCurso[1];
			String descripcionCurso = (String) objetoCurso[2];
			String nombreCurso = (String) objetoCurso[3];

			curso.setNroCurso(nroCurso);
			curso.setNombreCurso(nombreCurso);
			curso.setDescripcionCurso(descripcionCurso);
			curso.setCapacidad(capacidad);
			cursos.add(curso);
		}
		System.out.println(cursos);
		return cursos;
	}

	@Override
	public Set<Alumno> getAlumnosAsignados(long nroCurso) {
		return getCurso(nroCurso).getAlumnos();
	}

}