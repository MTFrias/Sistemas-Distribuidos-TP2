/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controller;

import Beans.HistoricoFacade;
import Beans.NotificacoesFacade;
import Beans.ProdutosFacade;
import Entities.Historico;
import Entities.Notificacoes;
import Entities.Produtos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "ProdutosController")
@ViewScoped

public class ProdutosController implements Serializable {

 Produtos produto = new Produtos();
 int quantidade;
@EJB
private ProdutosFacade prod;

@EJB
private HistoricoFacade his;



@EJB
private NotificacoesFacade noti;
private Notificacoes notificacoes;

public void create() {
    produto.setValidade(new Date());
    this.prod.create(produto);
    Historico newHistorico = new Historico();
    newHistorico.setData(new Date());
    newHistorico.setIdProduto(produto.getIdProduto());
    newHistorico.setTotal(produto.getStock());
    his.create(newHistorico);
}

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    @PersistenceContext(unitName = "Trabalho_SDPU")
    private EntityManager em;

public void comprarProduto(int id){
    if(id != 0 && quantidade > 0){
        Produtos list = prod.find(id);
        if(list.getStock() >= quantidade){
            list.setStock(list.getStock()-quantidade);
            prod.edit(list);
            quantidade = 0;
            
            Historico newHistorico = new Historico();
            newHistorico.setData(new Date());
            newHistorico.setIdProduto(id);

            newHistorico.setTotal(-quantidade);
            his.create(newHistorico);
            
            if(list.getStock() <= list.getStockMin()){
                notificacoes = new Notificacoes();
                notificacoes.setDate(new Date().toString());
                notificacoes.setMsg("Stock do produto " + list.getNome() + " está em no limite!");
                notificacoes.setStatus(false);
                noti.create(notificacoes);
            }
        }
        //em.createNamedQuery("Produtos.sellItem").setParameter("idProduto", id).setParameter("stock", quantidade).executeUpdate();
    }
}


public List<Historico> getHistoricoList(){
    return his.findAll();
}

public List<Notificacoes> getReadNotificacoes() {
    return noti.findAll();
}

public List<Produtos> getReadBebida() {
    List<Produtos> list = new ArrayList<>();
    for(Produtos item: this.prod.findAll()){
        if(item.getIdCategoria() == 8){
            list.add(item);
        }
    }
    return list;
}

public List<Produtos> getReadLimpeza() {
    List<Produtos> list = new ArrayList<>();
    for(Produtos item: this.prod.findAll()){
        if(item.getIdCategoria() == 7){
            list.add(item);
        }
    }
    return list;
}

public List<Produtos> getReadCarnes() {
    List<Produtos> list = new ArrayList<>();
    for(Produtos item: this.prod.findAll()){
        if(item.getStockMin() == 2){
            list.add(item);
        }
    }
    return list;
}

public List<Produtos> getReadMercearia() {
    List<Produtos> list = new ArrayList<>();
    for(Produtos item: this.prod.findAll()){
        if(item.getIdCategoria() == 9){
            list.add(item);
        }
    }
    return list;
}
 
public List<Produtos> getReadPeixes() {
    List<Produtos> list = new ArrayList<>();
    for(Produtos item: this.prod.findAll()){
        if(item.getIdCategoria() == 1){
            list.add(item);
        }
    }
    return list;
}

public List<Produtos> getRead() {
    return this.prod.findAll();
}

 public void updateForm(Produtos p) {
this.produto = p;
}

 public void update() {
this.prod.edit(produto);
this.produto = new Produtos();
}

 public void delete(Produtos p) {
this.prod.remove(p);
}

 public Produtos getProdutos() {
if (this.produto == null) {
return this.produto = new Produtos();
}
return produto;
}

 public void setProdutos(Produtos produto) {
this.produto = produto;
}
 
}