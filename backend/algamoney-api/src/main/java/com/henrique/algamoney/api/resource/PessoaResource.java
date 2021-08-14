/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.resource;

import com.henrique.algamoney.api.event.RecursoCriadoEvent;
import com.henrique.algamoney.api.model.Pessoa;
import com.henrique.algamoney.api.repository.PessoaRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author joaoh
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> listarPessoa(@PathVariable Long codigo) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);

        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoa);

    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);

    }
}
