
import br.edu.ifsul.pw.petshop_pw2022.Raca;
import java.util.List;
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
public class TesteListarRaca {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        List<Raca> lista
                = em.createQuery("from Raca order by id")
                        .setMaxResults(30).
                        setFirstResult(30).
                        getResultList();
        for (Raca r : lista) {
            System.out.println("ID: " + r.getId() + " Nome: " + r.getNome());
        }

        em.close();
        emf.close();
    }
}
