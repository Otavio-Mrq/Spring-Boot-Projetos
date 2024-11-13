package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.municipioDto;
import com.senai.ThymeLeaf.services.municipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarmunicipio")
public class atualizarMunicipioController {
    
    @Autowired
    municipioService municipioService;
    
    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id){               
        
        municipioDto municipio = municipioService.obterMunicipio(id);
                
        model.addAttribute("municipio", municipio);
        
        if (municipio.getId() > 0){
            return "atualizarmunicipio";
        }
        
        return "redirect:/listaMunicipios";
    }
}
