/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.service;

import com.henrique.algamoney.api.model.Lancamento;
import com.henrique.algamoney.api.model.Pessoa;
import com.henrique.algamoney.api.repository.LancamentoRepository;
import com.henrique.algamoney.api.repository.PessoaRepository;
import com.henrique.algamoney.api.service.exception.PessoaInexistenteOuInativaException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joaoh
 */
@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).get();
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }

}
