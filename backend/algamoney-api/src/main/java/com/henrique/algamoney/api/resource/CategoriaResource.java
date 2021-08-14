/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.resource;

import com.henrique.algamoney.api.model.Categoria;
import com.henrique.algamoney.api.repository.CategoriaRepository;
import java.net.URI;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController //controlador Rest
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);
        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
}
