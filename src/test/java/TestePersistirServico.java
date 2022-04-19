
import br.edu.ifsul.pw.petshop_pw2022.Funcionario;
import br.edu.ifsul.pw.petshop_pw2022.OrdemServico;
import br.edu.ifsul.pw.petshop_pw2022.Pessoa;
import br.edu.ifsul.pw.petshop_pw2022.Pet;
import br.edu.ifsul.pw.petshop_pw2022.Servico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mauro
 */
public class TestePersistirServico {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        Servico s = new Servico();
        s.setNome("Castração");
        s.setValor(250.00);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
