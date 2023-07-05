package com.victordias.minhasfinancas.service.impl;

import com.victordias.minhasfinancas.model.entity.Usuario;
import com.victordias.minhasfinancas.model.repository.UsuarioRepository;
import com.victordias.minhasfinancas.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario validarEmail(String email) {
        return null;
    }
}
