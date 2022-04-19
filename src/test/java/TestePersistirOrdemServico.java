
import br.edu.ifsul.pw.petshop_pw2022.Funcionario;
import br.edu.ifsul.pw.petshop_pw2022.OrdemServico;
import br.edu.ifsul.pw.petshop_pw2022.Pessoa;
import br.edu.ifsul.pw.petshop_pw2022.Pet;
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
public class TestePersistirOrdemServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop_PW2022");
        EntityManager em = emf.createEntityManager();
        OrdemServico os = new OrdemServico();
        os.setData(Calendar.getInstance());
        os.setDescricao("Banho e Tosa");
        os.setFuncionario(em.find(Funcionario.class, 5));
        os.setPessoa(em.find(Pessoa.class, 5));;
        os.setPet(em.find(Pet.class, 2));
        os.setValorTotal(120.00);
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
