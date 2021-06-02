package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-02T20:58:52")
@StaticMetamodel(Produtos.class)
public class Produtos_ { 

    public static volatile SingularAttribute<Produtos, Float> preçoCompra;
    public static volatile SingularAttribute<Produtos, Integer> idProduto;
    public static volatile SingularAttribute<Produtos, Integer> stockMin;
    public static volatile SingularAttribute<Produtos, String> nome;
    public static volatile SingularAttribute<Produtos, Integer> stock;
    public static volatile SingularAttribute<Produtos, Float> preçoFinal;
    public static volatile SingularAttribute<Produtos, byte[]> enviarMsg;
    public static volatile SingularAttribute<Produtos, String> descricao;
    public static volatile SingularAttribute<Produtos, Date> validade;

}