package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Time;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirTime {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Time t = new Time();
        t.setNome("Gaucho de Passo Fundo");
        t.setDataFundacao(Calendar.getInstance());
        t.setHistoria("Time da cidade de Passo Fundo");
        t.setCidade(em.find(Cidade.class, 2));
        t.setUsuario(em.find(Usuario.class, "Joaozinho"));
        t.setTecnico(em.find(Pessoa.class, 1));
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
