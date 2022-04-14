package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "time")
public class Time implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_time", sequenceName = "seq_time_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_time", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)    
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de fundacao deve ser informada")
    @Column(name = "data_fundacao", nullable = false)
    private Calendar dataFundacao;
    
    @Column(name = "historia", columnDefinition = "text")
    private String historia;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "nome_usuario", nullable = false)
    private Usuario usuario;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tecnico", referencedColumnName = "id", nullable = false)
    private Pessoa tecnico;
    
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    List<Jogador> jogadores = new ArrayList<>();
    
    public Time() {
        
    }
    
    public void adicionarJogador(Jogador obj) {
        obj.setTime(this);
        this.getJogadores().add(obj);
    }
    
    public void removerJogador(int index) {
        this.jogadores.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Calendar dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pessoa getTecnico() {
        return tecnico;
    }

    public void setTecnico(Pessoa tecnico) {
        this.tecnico = tecnico;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Time other = (Time) obj;
        return Objects.equals(this.id, other.id);
    }
}
