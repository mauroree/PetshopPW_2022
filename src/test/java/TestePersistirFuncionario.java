
import br.edu.ifsul.pw.petshop_pw2022.Funcionario;
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
public class TestePersistirFuncionario {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        Funcionario f = new Funcionario();
        f.setNomeUsuario("MRX");
        f.setAtivo(Boolean.TRUE);
        f.setSenha("123456");
        f.setNome("Mauro Ré");
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
