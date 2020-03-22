/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.practica3.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ues.occ.edu.sv.tpi2020.practica3.entities.TipoUsuarios;

/**
 *
 * @author cristian
 */
@Stateless
public class TipoUsuariosFacade extends AbstractFacade<TipoUsuarios> implements GenericLocalInterface<TipoUsuarios> {

    @PersistenceContext(unitName = "practica3")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuariosFacade() {
        super(TipoUsuarios.class);
    }
    
}
