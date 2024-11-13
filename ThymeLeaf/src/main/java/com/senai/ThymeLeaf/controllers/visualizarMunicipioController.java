/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.municipioDto;
import com.senai.ThymeLeaf.services.municipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author inhom
 */
@Controller
@RequestMapping("/visualizarmunicipio")
public class visualizarMunicipioController {
    
    @Autowired
    municipioService service;
    
    @GetMapping("/{id}")
    public String exibirVisualizarContato(Model model, @PathVariable Long id){

        municipioDto estado = service.obterMunicipio(id);
                
        model.addAttribute("estado", estado);
        
        if (estado.getId() > 0){
            return "visualizarmunicipio";
        }
        
        return "redirect:/listaMunicipios";
        
    }
}
