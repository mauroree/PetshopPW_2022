
import br.edu.ifsul.pw.petshop_pw2022.Raca;
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
public class TesteExcluirRaca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
