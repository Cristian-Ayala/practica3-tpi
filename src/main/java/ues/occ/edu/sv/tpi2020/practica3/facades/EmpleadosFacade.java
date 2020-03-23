package ues.occ.edu.sv.tpi2020.practica3.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.tpi2020.practica3.entities.Empleados;

/**
 *
 * @author cristian
 */
@Stateless
@LocalBean
public class EmpleadosFacade extends AbstractFacade<Empleados> implements GenericLocalInterface<Empleados> {

    @PersistenceContext(unitName = "practica3")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }    
}
