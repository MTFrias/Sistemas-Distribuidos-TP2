/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "utilizadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizadores.findAll", query = "SELECT u FROM Utilizadores u"),
    @NamedQuery(name = "Utilizadores.findByIdUtilizador", query = "SELECT u FROM Utilizadores u WHERE u.idUtilizador = :idUtilizador"),
    @NamedQuery(name = "Utilizadores.findByNome", query = "SELECT u FROM Utilizadores u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utilizadores.findByEmail", query = "SELECT u FROM Utilizadores u WHERE u.email = :email"),
    @NamedQuery(name = "Utilizadores.findByPassword", query = "SELECT u FROM Utilizadores u WHERE u.password = :password"),
    @NamedQuery(name = "Utilizadores.findBySalt", query = "SELECT u FROM Utilizadores u WHERE u.salt = :salt"),
    @NamedQuery(name = "Utilizadores.findByDataRegisto", query = "SELECT u FROM Utilizadores u WHERE u.dataRegisto = :dataRegisto")})
public class Utilizadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilizador")
    private Integer idUtilizador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_registo")
    @Temporal(TemporalType.DATE)
    private Date dataRegisto;

    public Utilizadores() {
    }

    public Utilizadores(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Utilizadores(Integer idUtilizador, String nome, String email, String password, String salt, Date dataRegisto) {
        this.idUtilizador = idUtilizador;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.dataRegisto = dataRegisto;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Date dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizadores)) {
            return false;
        }
        Utilizadores other = (Utilizadores) object;
        if ((this.idUtilizador == null && other.idUtilizador != null) || (this.idUtilizador != null && !this.idUtilizador.equals(other.idUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utilizadores[ idUtilizador=" + idUtilizador + " ]";
    }
    
}
