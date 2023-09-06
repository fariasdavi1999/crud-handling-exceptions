package br.com.connectdf.apisociotorcedortimes.entities;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getDocumentoIdentidade() {
        return documentoIdentidade;
    }

    public void setDocumentoIdentidade(String documentoIdentidade) {
        this.documentoIdentidade = documentoIdentidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCategoriaHabilitacao() {
        return categoriaHabilitacao;
    }

    public void setCategoriaHabilitacao(String categoriaHabilitacao) {
        this.categoriaHabilitacao = categoriaHabilitacao;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getEstadoEmissor() {
        return estadoEmissor;
    }

    public void setEstadoEmissor(String estadoEmissor) {
        this.estadoEmissor = estadoEmissor;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getDocumentoFrente() {
        return documentoFrente;
    }

    public void setDocumentoFrente(String documentoFrente) {
        this.documentoFrente = documentoFrente;
    }

    public String getDocumentoVerso() {
        return documentoVerso;
    }

    public void setDocumentoVerso(String documentoVerso) {
        this.documentoVerso = documentoVerso;
    }

    public String getDocumentoRetrato() {
        return documentoRetrato;
    }

    public void setDocumentoRetrato(String documentoRetrato) {
        this.documentoRetrato = documentoRetrato;
    }

    public String getDocumentoAssinatura() {
        return documentoAssinatura;
    }

    public void setDocumentoAssinatura(String documentoAssinatura) {
        this.documentoAssinatura = documentoAssinatura;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEsposa() {
        return nomeEsposa;
    }

    public void setNomeEsposa(String nomeEsposa) {
        this.nomeEsposa = nomeEsposa;
    }

    public String getCpfEsposa() {
        return cpfEsposa;
    }

    public void setCpfEsposa(String cpfEsposa) {
        this.cpfEsposa = cpfEsposa;
    }

    public String getEmailEsposa() {
        return emailEsposa;
    }

    public void setEmailEsposa(String emailEsposa) {
        this.emailEsposa = emailEsposa;
    }

    public String getCelularEsposa() {
        return celularEsposa;
    }

    public void setCelularEsposa(String celularEsposa) {
        this.celularEsposa = celularEsposa;
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
