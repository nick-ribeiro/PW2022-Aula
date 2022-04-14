package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirEstado {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Estado e = new Estado();
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}
