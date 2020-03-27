package ues.occ.edu.sv.tpi2020.practica3.facades;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void eliminarById(int ID) {
        try {
            getEntityManager().remove(getEntityManager().createQuery("SELECT n FROM Empleados n WHERE n.codigo =:id").setParameter("id", ID).getResultList().get(0));
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public boolean noCreated(Empleados emp) {
        return getEntityManager().createQuery("SELECT n FROM Empleados n WHERE n.nombre=:nombre AND n.apellidos=:apellidos AND n.telefono=:telefono").setParameter("nombre", emp.getNombre()).setParameter("apellidos", emp.getApellidos()).setParameter("telefono", emp.getTelefono()).getResultList().isEmpty();
    }
}
