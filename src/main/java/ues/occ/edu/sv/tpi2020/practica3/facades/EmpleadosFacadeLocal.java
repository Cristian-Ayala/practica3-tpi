package ues.occ.edu.sv.tpi2020.practica3.facades;

import java.util.List;
import javax.ejb.Local;
import ues.occ.edu.sv.tpi2020.practica3.entities.Empleados;

/**
 *
 * @author cristian
 */
@Local
public interface EmpleadosFacadeLocal {

    void create(Empleados empleados);

    void edit(Empleados empleados);

    void remove(Empleados empleados);

    Empleados find(Object id);

    List<Empleados> findAll();

    List<Empleados> findRange(int[] range);

    int count();
    
}
