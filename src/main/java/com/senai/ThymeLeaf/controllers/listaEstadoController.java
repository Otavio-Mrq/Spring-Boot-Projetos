package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.services.estadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class listaEstadoController {
    @Autowired
    estadoService estadoService;
    
    @GetMapping("/listaEstados")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("estado",estadoService.obterListaEstados());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listaEstados";
    }
}
