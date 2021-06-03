package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-03T11:30:41")
@StaticMetamodel(Produtos.class)
public class Produtos_ { 

    public static volatile SingularAttribute<Produtos, Integer> idProduto;
    public static volatile SingularAttribute<Produtos, Double> precoCompra;
    public static volatile SingularAttribute<Produtos, Integer> stockMin;
    public static volatile SingularAttribute<Produtos, Double> precoFinal;
    public static volatile SingularAttribute<Produtos, String> nome;
    public static volatile SingularAttribute<Produtos, Integer> stock;
    public static volatile SingularAttribute<Produtos, Integer> idCategoria;
    public static volatile SingularAttribute<Produtos, Boolean> enviarmsg;
    public static volatile SingularAttribute<Produtos, String> descricao;
    public static volatile SingularAttribute<Produtos, Date> validade;

}