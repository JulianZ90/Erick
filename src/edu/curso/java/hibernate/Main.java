package edu.curso.java.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.hibernate.dao.PersonaDao;
import edu.curso.java.hibernate.dao.TabletDao;
import edu.curso.java.hibernate.model.Persona;
import edu.curso.java.hibernate.model.Tablet;

public class Main {

    private static ApplicationContext ctx = null;

    private static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext(
                    new String[] { "classpath:/applicationContext.xml" });
        }
        return ctx;
    }

    public static void main(String[] args) {

        PersonaDao personaDao = (PersonaDao) getContext().getBean("personaDao");
        TabletDao tabletDao = (TabletDao) getContext().getBean("tabletDao");

        Persona persona = new Persona("Jean Carles Puyol", "1546845487",
                "Reconquista 2332");

        Tablet tablet = new Tablet("iPad", "ultimate generation", 499.99,
                "Android", "4GB");

        List < Tablet > tablets = new ArrayList < Tablet >();
        tablets.add(tablet);

        Long idPersona = personaDao.guardarPersona(persona);

        System.out.println("_______________________________________________");
        System.out.println("Se guardo la persona " + persona.getName()
                + " con el ID" + idPersona);
        System.out.println("_______________________________________________");

        Long idTablet = tabletDao.guardarTablet(tablet);

        System.out.println("_______________________________________________");
        System.out.println("Se guardo la tablet " + tablet.getName()
                + " con el ID " + idTablet);
        System.out.println("_______________________________________________");

        persona.setTablets(tablets);
        personaDao.actualizarPersona(persona);

        System.out.println("_______________________________________________");
        for (Tablet tablet2 : tablets) {
            System.out.println("Se actualizo la persona " + persona.getName()
                    + " con la table " + tablet2.getName());
        }
        System.out.println("_______________________________________________");

        personaDao.borrarPersona(idPersona);

        System.out.println("_______________________________________________");
        System.out.println("Se borro la persona con el id:" + idPersona);
        System.out.println("_______________________________________________");

    }
}
