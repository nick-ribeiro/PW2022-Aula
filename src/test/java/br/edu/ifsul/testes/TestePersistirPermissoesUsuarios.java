package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissoesUsuarios {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "Joaozinho");
        Permissao pUsuario = em.find(Permissao.class, "USUARIO");
        Permissao pAdmin = em.find(Permissao.class, "ADMNISTRADOR");
        u.getPermissao().add(pAdmin);
        u.getPermissao().add(pUsuario);
        em.getTransaction().begin();
        em.persist(pUsuario);
        em.persist(pAdmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
