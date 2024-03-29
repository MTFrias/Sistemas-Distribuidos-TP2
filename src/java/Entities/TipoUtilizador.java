/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "tipo_utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUtilizador.findAll", query = "SELECT t FROM TipoUtilizador t"),
    @NamedQuery(name = "TipoUtilizador.findByIdTipo", query = "SELECT t FROM TipoUtilizador t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TipoUtilizador.findByTipo", query = "SELECT t FROM TipoUtilizador t WHERE t.tipo = :tipo")})
public class TipoUtilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;

    public TipoUtilizador() {
    }

    public TipoUtilizador(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoUtilizador(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUtilizador)) {
            return false;
        }
        TipoUtilizador other = (TipoUtilizador) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoUtilizador[ idTipo=" + idTipo + " ]";
    }
    
}
