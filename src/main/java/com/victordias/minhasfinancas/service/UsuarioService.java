package com.victordias.minhasfinancas.service;

import com.victordias.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);
    Usuario salvarUsuario(Usuario usuario);
    Usuario validarEmail(String email);

}
