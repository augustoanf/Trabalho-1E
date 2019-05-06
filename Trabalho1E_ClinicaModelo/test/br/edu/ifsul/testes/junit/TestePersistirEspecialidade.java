
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Telmo Junior
 */
public class TestePersistirEspecialidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    @Before
    public void before(){
        
        emf = Persistence.createEntityManagerFactory("Trabalho_1EPU");
        em = emf.createEntityManager();    
        
    }
    
    @After
    public void after(){
        em.close();
        emf.close();
    }
    
    @Test
    public void test(){
        
        Especialidade obj = new Especialidade();
        obj.setDescricao("Oftalmologia");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();  
    }   
}
