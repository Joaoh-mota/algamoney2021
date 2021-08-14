/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.repository;

import com.henrique.algamoney.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joaoh
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
