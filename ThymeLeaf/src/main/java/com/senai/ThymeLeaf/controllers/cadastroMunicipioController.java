package com.senai.ThymeLeaf.controllers;


import com.senai.ThymeLeaf.dtos.municipioDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class cadastroMunicipioController {
    
    @GetMapping("/cadastroMunicipio")
    public String telaDeCadastro(Model model){
        
        municipioDto cadastrodDto = new municipioDto();
        
        model.addAttribute("municipio",cadastrodDto);
        return "cadastroMunicipio";
    }
}