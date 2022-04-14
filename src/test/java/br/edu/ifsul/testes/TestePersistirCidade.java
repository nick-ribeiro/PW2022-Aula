package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirCidade {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Estado e = em.find(Estado.class, 1);
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        c.setEstado(e);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}
