/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.manytoone.controllers;

import com.senai.manytoone.services.estadoService;
import com.senai.manytoone.services.municipioService;
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
