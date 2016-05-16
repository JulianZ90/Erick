package edu.curso.java.hibernate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.curso.java.hibernate.model.Tablet;
//Spring soporta Hibernate con la clase: HibernateDaoSupport
//Adentro de esta se encuentra la sesion.
//Da mucho soporte a la sesion de Hibernate (HibernateTemplate.FUNCIONES)
public class TabletDao
        extends HibernateDaoSupport {

    public Long guardarTablet(Tablet tablet) {
        super.getHibernateTemplate().save(tablet);
        return tablet.getId();
    }

    public void actualizarTablet(Tablet tablet) {
        super.getHibernateTemplate().update(tablet);
    }

    public void borrarTablet(Long idTablet) {
        Tablet tablet = (Tablet) super.getHibernateTemplate().load(
                Tablet.class, idTablet);
        super.getHibernateTemplate().delete(tablet);
    }

    public Tablet recuperarTabletPorId(Long iCliente) {
        Tablet tablet = (Tablet) super.getHibernateTemplate().load(
                Tablet.class, iCliente);
        return tablet;
    }

}
