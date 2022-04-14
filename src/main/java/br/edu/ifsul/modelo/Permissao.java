package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{
    
    @Id
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @NotBlank(message = "A descrição deve ser informado")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;
    
    public Permissao() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
