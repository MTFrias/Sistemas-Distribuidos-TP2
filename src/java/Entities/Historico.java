/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h"),
    @NamedQuery(name = "Historico.findByIdHistorico", query = "SELECT h FROM Historico h WHERE h.idHistorico = :idHistorico"),
    @NamedQuery(name = "Historico.findByIdUtilizador", query = "SELECT h FROM Historico h WHERE h.idUtilizador = :idUtilizador"),
    @NamedQuery(name = "Historico.findByIdProduto", query = "SELECT h FROM Historico h WHERE h.idProduto = :idProduto"),
    @NamedQuery(name = "Historico.findByData", query = "SELECT h FROM Historico h WHERE h.data = :data"),
    @NamedQuery(name = "Historico.findByTotal", query = "SELECT h FROM Historico h WHERE h.total = :total")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historico")
    private Integer idHistorico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utilizador")
    private int idUtilizador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private int idProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;

    public Historico() {
    }

    public Historico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Historico(Integer idHistorico, int idUtilizador, int idProduto, Date data, double total) {
        this.idHistorico = idHistorico;
        this.idUtilizador = idUtilizador;
        this.idProduto = idProduto;
        this.data = data;
        this.total = total;
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorico != null ? idHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.idHistorico == null && other.idHistorico != null) || (this.idHistorico != null && !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Historico[ idHistorico=" + idHistorico + " ]";
    }
    
}
