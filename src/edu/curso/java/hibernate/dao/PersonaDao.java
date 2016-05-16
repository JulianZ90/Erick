package edu.curso.java.hibernate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.curso.java.hibernate.model.Persona;

public class PersonaDao
        extends HibernateDaoSupport {
	private String mensaje;
	private Persona persona;


	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long guardarPersona(Persona persona) {
        super.getHibernateTemplate().save(persona);
     //   super.getSessionFactory();
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
    
    public String getMensaje() {
		return mensaje;
	}
    
    public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
