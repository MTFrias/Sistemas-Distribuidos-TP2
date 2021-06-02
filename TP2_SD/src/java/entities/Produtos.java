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
import javax.persistence.Lob;
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
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdProduto", query = "SELECT p FROM Produtos p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtos.findByPre\u00e7oCompra", query = "SELECT p FROM Produtos p WHERE p.pre\u00e7oCompra = :pre\u00e7oCompra"),
    @NamedQuery(name = "Produtos.findByPre\u00e7oFinal", query = "SELECT p FROM Produtos p WHERE p.pre\u00e7oFinal = :pre\u00e7oFinal"),
    @NamedQuery(name = "Produtos.findByStock", query = "SELECT p FROM Produtos p WHERE p.stock = :stock"),
    @NamedQuery(name = "Produtos.findByStockMin", query = "SELECT p FROM Produtos p WHERE p.stockMin = :stockMin"),
    @NamedQuery(name = "Produtos.findByValidade", query = "SELECT p FROM Produtos p WHERE p.validade = :validade")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre\u00e7o_compra")
    private float preçoCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre\u00e7o_final")
    private float preçoFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_min")
    private int stockMin;
    @Column(name = "validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validade;
    @Lob
    @Column(name = "enviarMsg")
    private byte[] enviarMsg;

    public Produtos() {
    }

    public Produtos(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produtos(Integer idProduto, String nome, String descricao, float preçoCompra, float preçoFinal, int stock, int stockMin) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preçoCompra = preçoCompra;
        this.preçoFinal = preçoFinal;
        this.stock = stock;
        this.stockMin = stockMin;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreçoCompra() {
        return preçoCompra;
    }

    public void setPreçoCompra(float preçoCompra) {
        this.preçoCompra = preçoCompra;
    }

    public float getPreçoFinal() {
        return preçoFinal;
    }

    public void setPreçoFinal(float preçoFinal) {
        this.preçoFinal = preçoFinal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public byte[] getEnviarMsg() {
        return enviarMsg;
    }

    public void setEnviarMsg(byte[] enviarMsg) {
        this.enviarMsg = enviarMsg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produtos[ idProduto=" + idProduto + " ]";
    }
    
}
