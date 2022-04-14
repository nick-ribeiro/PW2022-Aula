package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissao {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Permissao pUsuario = new Permissao();
        pUsuario.setNome("USUARIO");
        pUsuario.setDescricao("Usuario Simples");
        Permissao pAdmin = new Permissao();
        pAdmin.setNome("ADMNISTRADOR");
        pAdmin.setDescricao("Usuario Admin");
        em.getTransaction().begin();
        em.persist(pUsuario);
        em.persist(pAdmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
