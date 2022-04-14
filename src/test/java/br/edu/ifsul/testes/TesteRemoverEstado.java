package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteRemoverEstado {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Estado e = em.find(Estado.class, 3);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}
