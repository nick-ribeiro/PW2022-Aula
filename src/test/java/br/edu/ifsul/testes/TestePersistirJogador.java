package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Posicao;
import br.edu.ifsul.modelo.Time;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirJogador {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Time-ModelPU");
        EntityManager em = emf.createEntityManager();
        Time t = em.find(Time.class, 3);
        Jogador j = new Jogador();
        j.setCpf("123.456.789-10");
        j.setPeso(80.0);
        j.setAltura(1.86);
        j.setNascimento(Calendar.getInstance());
        j.setNome("Lucas");
        j.setPosicao(em.find(Posicao.class, 1));
        t.adicionarJogador(j);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
