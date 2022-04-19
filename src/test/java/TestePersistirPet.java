
import br.edu.ifsul.pw.petshop_pw2022.Pet;
import br.edu.ifsul.pw.petshop_pw2022.Raca;
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
public class TestePersistirPet {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        Pet p = new Pet();
        p.setNome("Bob");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(15.00);
        p.setEspecie("Cachorro");
        Raca r = em.find(Raca.class, 1);
        p.setRaca(r);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
