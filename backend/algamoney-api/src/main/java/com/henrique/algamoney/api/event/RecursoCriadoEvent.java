/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.algamoney.api.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author joaoh
 */
public class RecursoCriadoEvent extends ApplicationEvent{
    
    private HttpServletResponse response;
    private Long codigo;
    
    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
    
}
