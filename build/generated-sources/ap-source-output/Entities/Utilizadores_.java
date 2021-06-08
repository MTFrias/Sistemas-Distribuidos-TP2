package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-04T11:27:38")
@StaticMetamodel(Utilizadores.class)
public class Utilizadores_ { 

    public static volatile SingularAttribute<Utilizadores, Integer> idUtilizador;
    public static volatile SingularAttribute<Utilizadores, String> password;
    public static volatile SingularAttribute<Utilizadores, String> salt;
    public static volatile SingularAttribute<Utilizadores, String> nome;
    public static volatile SingularAttribute<Utilizadores, Integer> idTipo;
    public static volatile SingularAttribute<Utilizadores, Date> dataRegisto;
    public static volatile SingularAttribute<Utilizadores, String> email;

}