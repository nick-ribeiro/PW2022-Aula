package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirUsuario {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setAtivo(true);
        u.setEmail("joao@ifsul.com");
        u.setNome("Joao");
        u.setNomdUsuario("Joaozinho");
        u.setSenha("12345");
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
