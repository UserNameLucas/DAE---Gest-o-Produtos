package entities;

import entities.Estado;
import entities.Modulo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-01T19:24:33")
@StaticMetamodel(Configuracao.class)
public class Configuracao_ { 

    public static volatile SingularAttribute<Configuracao, String> nomeSoftware;
    public static volatile SingularAttribute<Configuracao, Integer> versaoBase;
    public static volatile SingularAttribute<Configuracao, Estado> estado;
    public static volatile SingularAttribute<Configuracao, Modulo> modulos;
    public static volatile SingularAttribute<Configuracao, Integer> id;
    public static volatile SingularAttribute<Configuracao, String> descricao;

}