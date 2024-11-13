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
@RequestMapping("/atualizarestado")
public class atualizarEstadoController {
    
    @Autowired
    estadoService estadoService;
    
    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id){               
        
        estadoDto estado = estadoService.obterEstado(id);
                
        model.addAttribute("estado", estado);
        
        if (estado.getId() > 0){
            return "atualizarestado";
        }
        
        return "redirect:/listaEstados";
    }
}
