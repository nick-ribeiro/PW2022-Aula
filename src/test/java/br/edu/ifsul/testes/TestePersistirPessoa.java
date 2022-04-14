package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Jonas Brothers");
        p.setCpf("123.456.789-10");
        p.setNascimento(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
