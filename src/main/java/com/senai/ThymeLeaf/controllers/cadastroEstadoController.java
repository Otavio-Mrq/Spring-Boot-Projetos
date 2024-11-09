package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.estadoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastroEstadoController {
    
    @GetMapping("/cadastroEstado")
    public String telaDeCadastro(Model model){
        
        estadoDto cadastrodDto = new estadoDto();
        
        model.addAttribute("estado",cadastrodDto);
        return "cadastroEstado";
    }
}
