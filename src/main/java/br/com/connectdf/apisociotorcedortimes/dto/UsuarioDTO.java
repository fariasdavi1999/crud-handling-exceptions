package br.com.connectdf.apisociotorcedortimes.dto;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String documentoIdentidade;
    private String dataNascimento;
    private String genero;

    private String cpf;
    private String dataExpedicao;
    private String naturalidade;
    private String registro;
    private String dataValidade;
    private String categoriaHabilitacao;
    private String dataEmissao;
    private String estadoEmissor;
    private String orgaoEmissor;

    private String email;
    private String celular;
    private String cnpj;

    private String nomeEsposa;

    private String cpfEsposa;

    private String emailEsposa;

    private String celularEsposa;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
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
}
