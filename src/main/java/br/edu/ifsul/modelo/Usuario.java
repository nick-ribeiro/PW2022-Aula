package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    @Id
    @NotBlank(message = "O nome de usuário deve ser informado")
    @Length(max = 20, message = "O usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomdUsuario;
    
    @NotBlank(message = "A senha deve ser informado")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
    
    @Email(message = "O email deve ser informado")
    private String email;
    
    @NotBlank(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informado")
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @ManyToMany
            //@JoinTable(name = "permissoes", joinColumns = @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false),
              //      inverseJoinColumns = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    Set<Permissao> permissao = new HashSet<>();

    public Set<Permissao> getPermissao() {
        return permissao;
    }

    public void setPermissao(Set<Permissao> permissao) {
        this.permissao = permissao;
    }
    
    public Usuario () {dataCadastro = Calendar.getInstance();}

    public String getNomdUsuario() {
        return nomdUsuario;
    }

    public void setNomdUsuario(String nomdUsuario) {
        this.nomdUsuario = nomdUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nomdUsuario);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nomdUsuario, other.nomdUsuario);
    }
    
}
