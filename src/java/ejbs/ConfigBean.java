/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

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
    
   @PostConstruct
    public void populateBD() {

        try {
            clienteBean.create("trav. daquela rua", "Jaquim", "FAzTudo", "userA", "userA", "usera@mail.com");
            clienteBean.create("trav. da outra rua", "Fernandim", "FezTudo", "userB", "userB", "userb@mail.com");
            clienteBean.create("trav. da outra rua mas do outro lado", "Zezim", "QuerFazer", "userC", "userC", "userc@mail.com");
            
            administradorBean.create("Presidente", "Filermindo", "adminA", "adminA", "adminA@mail.com");

        } catch(Exception e){
            logger.warning(e.getMessage());
        }
    }
    
}
