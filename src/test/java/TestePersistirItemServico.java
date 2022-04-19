
import br.edu.ifsul.pw.petshop_pw2022.ItemServico;
import br.edu.ifsul.pw.petshop_pw2022.OrdemServico;
import br.edu.ifsul.pw.petshop_pw2022.Servico;
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
public class TestePersistirItemServico {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        ItemServico is = new ItemServico();
        is.setQuantidade(30.00);
        is.setServico(em.find(Servico.class, 1));
        is.setValorTotal(300.00);
        is.setValorUnitario(150.00);
        is.setOrdemServico(em.find(OrdemServico.class, 1));
        em.getTransaction().begin();
        em.persist(is);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
