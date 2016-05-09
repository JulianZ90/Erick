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

import com.ealvarez.asignacionAlumnos.dao.AlumnoDAO;
import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;
import com.ealvarez.asignacionAlumnos.util.HibernateUtil;

/**
 * @author Erik Alvarez
 * @version 1.0
 */

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	public AlumnoDAOImpl() {
		System.out.println("AlumnoDAOImpl");
	}

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long anadirAlumno(Alumno alumno) {
		return (Long) hibernateUtil.create(alumno);
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return hibernateUtil.update(alumno);
	}

	@Override
	public void eliminarAlumno(long legajo) {
		Alumno alumno = new Alumno();
		alumno.setLegajo(legajo);
		hibernateUtil.delete(alumno);
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return hibernateUtil.fetchAll(Alumno.class);
	}

	@Override
	public Alumno getAlumno(long legajo) {
		return hibernateUtil.fetchById(legajo, Alumno.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> getAllAlumnos(String nombreAlumno) {
		String query = "SELECT e.* FROM ALUMNO e WHERE e.nombre like '%" + nombreAlumno + "%'";
		List<Object[]> objetosAlumno = hibernateUtil.fetchAll(query);
		List<Alumno> alumnos = new ArrayList<Alumno>();
		for (Object[] objetoAlumno : objetosAlumno) {
			Alumno alumno = new Alumno();
			long legajo = ((BigInteger) objetoAlumno[0]).longValue();
			String apellido = (String) objetoAlumno[1];
			String carrera = (String) objetoAlumno[2];
			String nombre = (String) objetoAlumno[3];
			alumno.setLegajo(legajo);
			alumno.setNombre(nombre);
			alumno.setApellido(apellido);
			alumno.setCarrera(carrera);
			alumnos.add(alumno);
		}
		System.out.println(alumnos);
		return alumnos;
	}

	@Override
	public Set<Curso> getCursosAsignados(long legajo) {
		return getAlumno(legajo).getCursos();
	}

}