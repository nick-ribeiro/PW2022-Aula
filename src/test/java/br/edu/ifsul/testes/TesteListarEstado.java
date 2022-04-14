package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListarEstado {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Estado> lista = em.createQuery("from Estado order by id").getResultList();
        for (Estado e : lista) {
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome() + " UF: " 
                    + e.getUf());
        }
         em.close();
        emf.close();
        
        
    }

}
