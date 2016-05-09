package com.ealvarez.asignacionAlumnos.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Erik Alvarez
 * @version 1.0
 * 
 */
@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nroCurso")
	private long nroCurso;

	@Column(name = "nombreCurso")
	private String nombreCurso;

	@Column(name = "descripcionCurso")
	private String descripcionCurso;

	@Column(name = "capacidad")
	private int capacidad;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "cursos")
	private Set<Alumno> Alumnos;

	public Curso() {
	}

	/**
	 * @return the nroCurso
	 */
	public long getNroCurso() {
		return nroCurso;
	}

	/**
	 * @param nroCurso
	 *            the nroCurso to set
	 */
	public void setNroCurso(long nroCurso) {
		this.nroCurso = nroCurso;
	}

	/**
	 * @return the nombreCurso
	 */
	public String getNombreCurso() {
		return nombreCurso;
	}

	/**
	 * @param nombreCurso
	 *            the nombreCurso to set
	 */
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	/**
	 * @return the descripcionCurso
	 */
	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	/**
	 * @param descripcionCurso
	 *            the descripcionCurso to set
	 */
	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad
	 *            the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the alumnos
	 */
	public Set<Alumno> getAlumnos() {
		return Alumnos;
	}

	/**
	 * @param alumnos
	 *            the alumnos to set
	 */
	public void setAlumnos(Set<Alumno> alumnos) {
		Alumnos = alumnos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Curso [nroCurso=" + nroCurso + ", nombreCurso=" + nombreCurso + ", descripcionCurso=" + descripcionCurso
				+ ", capacidad=" + capacidad + "]";
	}

}