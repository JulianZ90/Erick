package com.ealvarez.asignacionAlumnos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ealvarez.asignacionAlumnos.entity.Alumno;
import com.ealvarez.asignacionAlumnos.entity.Curso;
import com.ealvarez.asignacionAlumnos.service.AlumnoService;
import com.ealvarez.asignacionAlumnos.service.CursoService;

/**
 * @author Erik Alvarez
 * @version 1.0
 */
@Controller
public class CursoController {

	private static final Logger logger = Logger.getLogger(CursoController.class);

	public CursoController() {
		System.out.println("CursoController()");
	}

	@Autowired
	private CursoService cursoService;
	@Autowired
	private AlumnoService alumnoService;

	@RequestMapping("anadirCurso")
	public ModelAndView anadirCurso(@ModelAttribute Curso curso) {
		logger.info("Aniadiendo Curso. Data: " + curso);
		return new ModelAndView("formularioCurso");
	}

	@RequestMapping("actualizarCurso")
	public ModelAndView actualizarCurso(@RequestParam long nroCurso, @ModelAttribute Curso curso) {
		logger.info("ActualizandonroCurso " + nroCurso);
		curso = cursoService.getCurso(nroCurso);
		return new ModelAndView("formularioCurso", "objetoCurso", curso);
	}

	@RequestMapping("guardarCurso")
	public ModelAndView guardarCurso(@ModelAttribute Curso curso) {
		logger.info("Guardando la informacion del curso. Data : " + curso);
		if (curso.getNroCurso() == 0) { // Si el ID es 0 hay que crear un nuevo
										// registro
			cursoService.anadirCurso(curso);
		} else {
			cursoService.actualizarCurso(curso);
		}
		return new ModelAndView("redirect:getAllCursos");
	}

	@RequestMapping("eliminarCurso")
	public ModelAndView eliminarCurso(@RequestParam long nroCurso) {
		logger.info("Eliminando el curso con legajo : " + nroCurso);
		cursoService.eliminarCurso(nroCurso);
		return new ModelAndView("redirect:getAllCursos");
	}

	@RequestMapping(value = "getAllCursos")
	public ModelAndView getAllCursos() {
		logger.info("Buscando todos los cursos.");
		List<Curso> listaDeCursos = cursoService.getAllCursos();
		return new ModelAndView("listaDeCursos", "listaDeCursos", listaDeCursos);
	}

	@RequestMapping("buscarCurso")
	public ModelAndView buscarCurso(@RequestParam("nombreCursoBusqueda") String nombreCursoBusqueda) {
		logger.info("Buscando al curso con el nombre " + nombreCursoBusqueda);
		List<Curso> listaDeCursos = cursoService.getAllCursos(nombreCursoBusqueda);
		return new ModelAndView("listaDeCursos", "listaDeCursos", listaDeCursos);
	}

	@RequestMapping("pantallaAlumnosEnCursos")
	public ModelAndView pantallaAlumnosEnCursos(@RequestParam long nroCurso, @ModelAttribute Curso curso) {
		Map<String, Object> mapaObjetos = new HashMap<String, Object>();
		curso = cursoService.getCurso(nroCurso);
		mapaObjetos.put("curso", curso);

		Set<Alumno> listaDeAlumnosAsignados = cursoService.getAlumnosAsignados(curso.getNroCurso());
		mapaObjetos.put("listaDeAlumnosAsignados", listaDeAlumnosAsignados);

		List<Alumno> listaDeAlumnosSinAsignar = alumnoService.getAllAlumnos();
		mapaObjetos.put("listaDeAlumnosSinAsignar", listaDeAlumnosSinAsignar);

		return new ModelAndView("formularioAsignacionCurso", "mapaObjetos", mapaObjetos);
	}

	@RequestMapping("asignarAlumnoAlCurso")
	public ModelAndView asignarCursoAlAlumno(@RequestParam long nroCurso, @RequestParam long legajo) {
		cursoService.asignarAlumno(nroCurso, legajo);
		return new ModelAndView("redirect:pantallaAlumnosEnCursos?nroCurso=" + nroCurso);
	}

	@RequestMapping("desAsignarAlumnoDelCurso")
	public ModelAndView desAsignarCursoAlAlumno(@RequestParam long nroCurso, @RequestParam long legajo) {
		cursoService.desAsignarAlumno(nroCurso, legajo);
		return new ModelAndView("redirect:pantallaAlumnosEnCursos?nroCurso=" + nroCurso);
	}
}