package com.victordias.minhasfinancas.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
}
