/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.repository.lancamento;

import com.henrique.algamoney.api.model.Lancamento;
import com.henrique.algamoney.api.repository.filter.LancamentoFilter;
import com.henrique.algamoney.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author joaoh
 */
public interface LancamentoRepositoryQuery {
    public Page<Lancamento> filtrar (LancamentoFilter lancamentoFilter, Pageable pageable);
    public Page<ResumoLancamento> resumir (LancamentoFilter lancamentoFilter, Pageable pageable);
}
