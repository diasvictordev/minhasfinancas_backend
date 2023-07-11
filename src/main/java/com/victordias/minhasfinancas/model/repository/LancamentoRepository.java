package com.victordias.minhasfinancas.model.repository;

import com.victordias.minhasfinancas.model.entity.Lancamento;
import com.victordias.minhasfinancas.model.enums.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query(value = "SELECT SUM(l.valor) FROM Lancamento l JOIN l.usuario u WHERE " +
            "u.Id = :idUsuario and l.tipo = :tipo GROUP BY u")
    BigDecimal obterSaldoPorTipoLancamentoeUsuario(@Param("idUsuario") Long idUsuario, @Param("tipo") TipoLancamento tipo);
}
