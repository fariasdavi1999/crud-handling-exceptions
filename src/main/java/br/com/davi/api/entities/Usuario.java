package br.com.davi.api.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario extends RepresentationModel<Usuario> implements Serializable {

    @Serial
    private static final long serialVersionUID = 5935836358441880615L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String documentoIdentidade;
    private String dataNascimento;
    private String genero;

    @Column(unique = true)
    private String cpf;
    private String dataExpedicao;
    private String naturalidade;
    private String registro;
    private String dataValidade;
    private String categoriaHabilitacao;
    private String dataEmissao;
    private String estadoEmissor;
    private String orgaoEmissor;

    @Column(columnDefinition = "TEXT", name = "documento_frente")
    private String documentoFrente;
    @Column(columnDefinition = "TEXT", name = "documento_verso")
    private String documentoVerso;
    @Column(columnDefinition = "TEXT", name = "documento_retrato")
    private String documentoRetrato;
    @Column(columnDefinition = "TEXT", name = "documento_assinatura")
    private String documentoAssinatura;

    private String email;
    private String celular;
    private String cnpj;
    @Column(name = "nome_esposa")
    private String nomeEsposa;
    @Column(name = "cpf_esposa")
    private String cpfEsposa;
    @Column(name = "email_esposa")
    private String emailEsposa;
    @Column(name = "celular_esposa")
    private String celularEsposa;

    public Usuario() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

    public Usuario(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

}
