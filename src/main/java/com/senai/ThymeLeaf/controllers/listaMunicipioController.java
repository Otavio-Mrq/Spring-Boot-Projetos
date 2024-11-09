package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.services.municipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class listaMunicipioController {
    
    @Autowired
    municipioService municipioService1;
    
    @GetMapping("/listaMunicipios")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("municipio",municipioService1.obterListaMunicipios());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listaMunicipios";
    }
}
