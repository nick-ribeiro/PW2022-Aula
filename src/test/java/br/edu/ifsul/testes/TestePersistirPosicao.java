package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Posicao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPosicao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Posicao p1 = new Posicao();
        p1.setNome("Goleiro");
        Posicao p2 = new Posicao();
        p2.setNome("Zagueiro");
        Posicao p3 = new Posicao();
        p3.setNome("Atacante");
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}
