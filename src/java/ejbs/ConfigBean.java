/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Estado;
import entities.Modulo;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Lucas
 *      --------- ConfigBean != ConfiguracaoBean
 */

@Singleton
@Startup
public class ConfigBean {
    private static final Logger logger = Logger.getLogger("ejbs.ConfigBean");
     
    
    @EJB
    private ClienteBean clienteBean;
    @EJB
    private AdministradorBean administradorBean;
    @EJB
<<<<<<< HEAD
    private TemplateBean templateBean;
    
=======
    private ConfiguracaoBean configuracaoBean;
>>>>>>> maestro
    
   @PostConstruct
    public void populateBD() {

        try {
            clienteBean.create("trav. daquela rua", "Jaquim", "FAzTudo", "userA", "userA");
            clienteBean.create("trav. da outra rua", "Fernandim", "FezTudo", "userB", "userB");
            clienteBean.create("trav. da outra rua mas do outro lado", "Zezim", "QuerFazer", "userC", "userC");
            
            administradorBean.create("Presidente", "Filermindo", "adminA", "adminA", "adminA@mail.com");
            
<<<<<<< HEAD
            //templateBean.create
=======
            configuracaoBean.create(1, "ricado", Estado.ATIVA, "vai", 0, new Modulo("nomeMOdulo"));
>>>>>>> maestro

        } catch(Exception e){
            logger.warning(e.getMessage());
        }
    }
    
}
