package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jogador")
public class Jogador extends Pessoa implements Serializable{
    
    @Min(value = 0, message = "O peso nao pode ser negativo")
    @Column(name = "peso", nullable = false)
    @NotNull(message = "O peso deve ser informado")
    private Double peso;
    
    @Min(value = 0, message = "A altura nao pode ser negativa")
    @Column(name = "altura", nullable = false)
    @NotNull(message = "A altura deve ser informada")
    private Double altura;
    
    @NotNull(message = "A posicao deve ser informada")
    @ManyToOne
    @JoinColumn(name = "posicao", referencedColumnName = "id", nullable = false)
    private Posicao posicao;
    
    @NotNull(message = "O time deve ser informado")
    @ManyToOne
    @JoinColumn(name = "time_id", referencedColumnName = "id", nullable = false)
    private Time time;
    
    public Jogador() {
        
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
}
