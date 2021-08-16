/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.resource;

import com.henrique.algamoney.api.model.Lancamento;
import com.henrique.algamoney.api.repository.LancamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joaoh
 */
@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
    @Autowired
    LancamentoRepository lancamentoRepository;
    
    @GetMapping
    public List<Lancamento> listarLancamentos(){
        return lancamentoRepository.findAll();
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity <?> listarLancamento(@PathVariable Long codigo){
        Optional<Lancamento> lancamento = lancamentoRepository.findById(codigo);
        if (lancamento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(lancamento);
    }
    
}
