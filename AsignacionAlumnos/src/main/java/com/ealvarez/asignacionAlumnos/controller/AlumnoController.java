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
public class AlumnoController {

	private static final Logger logger = Logger.getLogger(AlumnoController.class);

	public AlumnoController() {
		System.out.println("AlumnoController()");
	}

	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private CursoService cursoService;

	@RequestMapping("anadirAlumno")
	public ModelAndView anadirAlumno(@ModelAttribute Alumno alumno) {
		logger.info("Aniadiendo Alumno. Data: " + alumno);
		return new ModelAndView("formularioAlumno");
	}

	@RequestMapping("actualizarAlumno")
	public ModelAndView actualizarAlumno(@RequestParam long legajo, @ModelAttribute Alumno alumno) {
		logger.info("Actualizando ALumno de legajo " + legajo);
		alumno = alumnoService.getAlumno(legajo);
		return new ModelAndView("formularioAlumno", "objetoAlumno", alumno);
	}

	@RequestMapping("guardarAlumno")
	public ModelAndView guardarAlumno(@ModelAttribute Alumno alumno) {
		logger.info("Guardando la informacion del alumno. Data : " + alumno);
		if (alumno.getLegajo() == 0) { // Si el ID es 0 hay que crear un nuevo
										// registro
			alumnoService.anadirAlumno(alumno);
		} else {
			alumnoService.actualizarAlumno(alumno);
		}
		return new ModelAndView("redirect:getAllAlumnos");
	}

	@RequestMapping("eliminarAlumno")
	public ModelAndView eliminarAlumno(@RequestParam long legajo) {
		logger.info("Eliminando el alumno con legajo : " + legajo);
		alumnoService.eliminarAlumno(legajo);
		return new ModelAndView("redirect:getAllAlumnos");
	}

	@RequestMapping(value = "getAllAlumnos")
	public ModelAndView getAllAlumnos() {
		logger.info("Buscando todos los alumnos.");
		List<Alumno> listaDeAlumnos = alumnoService.getAllAlumnos();
		return new ModelAndView("listaDeAlumnos", "listaDeAlumnos", listaDeAlumnos);
	}

	@RequestMapping("buscarAlumno")
	public ModelAndView buscarAlumno(@RequestParam("nombreBusqueda") String nombreBusqueda) {
		logger.info("Buscando al alumno con el nombre " + nombreBusqueda);
		List<Alumno> listaDeAlumnos = alumnoService.getAllAlumnos(nombreBusqueda);
		return new ModelAndView("listaDeAlumnos", "listaDeAlumnos", listaDeAlumnos);
	}

	@RequestMapping("pantallaCursoAlumno")
	public ModelAndView pantallaCursoAlumno(@RequestParam long legajo, @ModelAttribute Alumno alumno) {
		Map<String, Object> mapaObjetos = new HashMap<String, Object>();
		alumno = alumnoService.getAlumno(legajo);
		mapaObjetos.put("alumno", alumno);

		Set<Curso> listaDeCursosAsignados = alumnoService.getCursosAsignados(alumno.getLegajo());
		mapaObjetos.put("listaDeCursosAsignados", listaDeCursosAsignados);

		List<Curso> listaDeCursosSinAsignar = cursoService.getAllCursos();
		mapaObjetos.put("listaDeCursosSinAsignar", listaDeCursosSinAsignar);

		return new ModelAndView("formularioAsignacionAlumno", "mapaObjetos", mapaObjetos);
	}

	@RequestMapping("asignarCursoAlAlumno")
	public ModelAndView asignarCursoAlAlumno(@RequestParam long legajo, @RequestParam long nroCurso) {
		alumnoService.asignarCurso(legajo, nroCurso);
		return new ModelAndView("redirect:pantallaCursoAlumno?legajo=" + legajo);
	}

	@RequestMapping("desAsignarCursoAlAlumno")
	public ModelAndView desAsignarCursoAlAlumno(@RequestParam long legajo, @RequestParam long nroCurso) {
		alumnoService.desAsignarCurso(legajo, nroCurso);
		return new ModelAndView("redirect:pantallaCursoAlumno?legajo=" + legajo);
	}
}