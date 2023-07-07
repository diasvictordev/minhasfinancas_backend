package com.victordias.minhasfinancas.controller;

import com.victordias.minhasfinancas.api.dto.LancamentoDTO;
import com.victordias.minhasfinancas.model.entity.Lancamento;
import com.victordias.minhasfinancas.model.entity.Usuario;
import com.victordias.minhasfinancas.model.enums.TipoLancamento;
import com.victordias.minhasfinancas.service.LancamentoService;
import com.victordias.minhasfinancas.service.UsuarioService;
import com.victordias.minhasfinancas.service.exceptions.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    private LancamentoService service;
    private UsuarioService usuarioService;

    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody LancamentoDTO dto){
        try {
            Lancamento entidade = converter(dto);
            service.salvar(entidade);
            return new ResponseEntity(entidade, HttpStatus.CREATED);
        }
        catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody LancamentoDTO dto){
        return service.obterPorId(id).map(entity -> {
            try{
                Lancamento lancamento = converter(dto);
                lancamento.setId(entity.getId());
                service.atualizar(lancamento);
                return ResponseEntity.ok(lancamento);
            }catch(RegraNegocioException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        }).orElseGet(()->
                new ResponseEntity("Lançamento não encontrado na base de dados", HttpStatus.BAD_REQUEST));
    }

    private Lancamento converter(LancamentoDTO dto){
        Lancamento lancamento = new Lancamento();
        lancamento.setDescricao(dto.getDescricao());
        lancamento.setAno(dto.getAno());
        lancamento.setMes(dto.getMes());
        lancamento.setValor(dto.getValor());
        Usuario usuario = usuarioService.obterPorId(dto.getUsuario()).orElseThrow(()->
                new RegraNegocioException("Usuário não encontrado para o id informado!"));
        lancamento.setUsuario(usuario);
        lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
        return lancamento;
    }
}
