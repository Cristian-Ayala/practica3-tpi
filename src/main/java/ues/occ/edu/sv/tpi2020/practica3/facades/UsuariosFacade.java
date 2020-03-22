/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.practica3.facades;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ues.occ.edu.sv.tpi2020.practica3.entities.Usuarios;

/**
 *
 * @author cristian
 */
@Stateless
@LocalBean
public class UsuariosFacade extends AbstractFacade<Usuarios> implements GenericLocalInterface<Usuarios> {

    @PersistenceContext(unitName = "practica3")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public boolean verificar(String user, String Pass) {
        try {
            Query q = getEntityManager().createQuery("SELECT n FROM Usuarios n WHERE n.password=:pass AND n.usuario=:user").setParameter("pass", Pass).setParameter("user", user);
            if (!q.getResultList().isEmpty() && q.getResultList().size() == 1) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return false;
    }

}
