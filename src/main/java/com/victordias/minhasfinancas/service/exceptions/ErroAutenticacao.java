package com.victordias.minhasfinancas.service.exceptions;

public class ErroAutenticacao extends RuntimeException{
    public ErroAutenticacao(String mensagem){

        super(mensagem);
    }
}
