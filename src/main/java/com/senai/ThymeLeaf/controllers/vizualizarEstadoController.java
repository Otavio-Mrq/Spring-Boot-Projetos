/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.ThymeLeaf.controllers;


import com.senai.ThymeLeaf.dtos.estadoDto;
import com.senai.ThymeLeaf.services.estadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/visualizarestado")
public class vizualizarEstadoController {
    
    @Autowired
    estadoService estadoService;
    
    @GetMapping("/{id}")
    public String exibirVisualizarContato(Model model, @PathVariable Long id){

        estadoDto estado = estadoService.obterEstado(id);
                
        model.addAttribute("estado", estado);
        
        if (estado.getId() > 0){
            return "visualizarestado";
        }
        
        return "redirect:/listaEstados";
        
    }
}
