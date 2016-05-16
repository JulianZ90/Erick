package edu.curso.java.hibernate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.curso.java.hibernate.model.Persona;

public class PersonaDao
        extends HibernateDaoSupport {

    public Long guardarPersona(Persona persona) {
        super.getHibernateTemplate().save(persona);
        return persona.getId();
    }

    public void actualizarPersona(Persona persona) {
        super.getHibernateTemplate().update(persona);
    }

    public void borrarPersona(Long idPersona) {
        Persona persona = (Persona) super.getHibernateTemplate().load(
                Persona.class, idPersona);
        super.getHibernateTemplate().delete(persona);
    }

    public Persona recuperarPersonaPorId(Long iCliente) {
        Persona persona = (Persona) super.getHibernateTemplate().load(
                Persona.class, iCliente);
        return persona;
    }

}
