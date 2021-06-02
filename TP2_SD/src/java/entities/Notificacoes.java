/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "notificacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacoes.findAll", query = "SELECT n FROM Notificacoes n"),
    @NamedQuery(name = "Notificacoes.findByIdNotificacoes", query = "SELECT n FROM Notificacoes n WHERE n.idNotificacoes = :idNotificacoes"),
    @NamedQuery(name = "Notificacoes.findByIdTipo", query = "SELECT n FROM Notificacoes n WHERE n.idTipo = :idTipo"),
    @NamedQuery(name = "Notificacoes.findByDate", query = "SELECT n FROM Notificacoes n WHERE n.date = :date"),
    @NamedQuery(name = "Notificacoes.findByStatus", query = "SELECT n FROM Notificacoes n WHERE n.status = :status")})
public class Notificacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notificacoes")
    private Integer idNotificacoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo")
    private int idTipo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "msg")
    private String msg;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    public Notificacoes() {
    }

    public Notificacoes(Integer idNotificacoes) {
        this.idNotificacoes = idNotificacoes;
    }

    public Notificacoes(Integer idNotificacoes, int idTipo, String msg, boolean status) {
        this.idNotificacoes = idNotificacoes;
        this.idTipo = idTipo;
        this.msg = msg;
        this.status = status;
    }

    public Integer getIdNotificacoes() {
        return idNotificacoes;
    }

    public void setIdNotificacoes(Integer idNotificacoes) {
        this.idNotificacoes = idNotificacoes;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacoes != null ? idNotificacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacoes)) {
            return false;
        }
        Notificacoes other = (Notificacoes) object;
        if ((this.idNotificacoes == null && other.idNotificacoes != null) || (this.idNotificacoes != null && !this.idNotificacoes.equals(other.idNotificacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notificacoes[ idNotificacoes=" + idNotificacoes + " ]";
    }
    
}
