package entities;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-04T12:12:25")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends User_ {

    public static volatile SingularAttribute<Cliente, String> pessoaContacto;
    public static volatile SingularAttribute<Cliente, List> configuracoes;
    public static volatile SingularAttribute<Cliente, String> morada;

}