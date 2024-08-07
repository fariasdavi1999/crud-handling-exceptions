package br.com.davi.api.dto;

import br.com.davi.api.entities.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

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

}
