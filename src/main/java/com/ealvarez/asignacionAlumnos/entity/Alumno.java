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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Erik Alvarez
 * @version 1.0
 * 
 */
@Entity
@Table(name = "ALUMNO")
public class Alumno implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "legajo")
	private long legajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "carrera")
	private String carrera;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "ALUMNOCURSA", joinColumns = { @JoinColumn(name = "legajo") }, inverseJoinColumns = {
			@JoinColumn(name = "nroCurso") })
	private Set<Curso> cursos;

	public Alumno() {
	}

	/**
	 * @return the legajo
	 */
	public long getLegajo() {
		return legajo;
	}

	/**
	 * @param legajo
	 *            the legajo to set
	 */
	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 *            the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the cursos
	 */
	public Set<Curso> getCursos() {
		return cursos;
	}

	/**
	 * @param cursos
	 *            the cursos to set
	 */
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", carrera=" + carrera
				+ "]";
	}

}