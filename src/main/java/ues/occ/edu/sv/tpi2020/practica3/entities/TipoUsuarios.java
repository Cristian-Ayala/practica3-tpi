/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.tpi2020.practica3.entities;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tipo_usuarios", catalog = "practica3", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoUsuarios.findAll", query = "SELECT t FROM TipoUsuarios t"),
    @NamedQuery(name = "TipoUsuarios.findByIdTipoUsuario", query = "SELECT t FROM TipoUsuarios t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TipoUsuarios.findByTipoUsuario", query = "SELECT t FROM TipoUsuarios t WHERE t.tipoUsuario = :tipoUsuario")})
public class TipoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_usuario", nullable = false)
    private Integer idTipoUsuario;
    @Size(max = 25)
    @Column(name = "tipo_usuario", length = 25)
    private String tipoUsuario;
    @OneToMany(mappedBy = "idTipoUsuario")
    private List<Usuarios> usuariosList;

    public TipoUsuarios() {
    }

    public TipoUsuarios(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @JsonbTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuarios)) {
            return false;
        }
        TipoUsuarios other = (TipoUsuarios) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.tpi2020.practica3.entities.TipoUsuarios[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
