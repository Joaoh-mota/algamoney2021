/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.event.listener;

import com.henrique.algamoney.api.event.RecursoCriadoEvent;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author joaoh
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();
        
        adicionarHeaderLocation(codigo, response);
    }

    private void adicionarHeaderLocation(Long codigo, HttpServletResponse response) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("location", uri.toASCIIString());
    }
    
}
