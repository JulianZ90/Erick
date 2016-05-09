package com.ealvarez.asignacionAlumnos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("Inicializando HomeController()");
	}
	@RequestMapping(value = {"home", "/"})
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}
