package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.CadastroContatoDto;
import com.senai.ThymeLeaf.dtos.CadastroDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CadastrarContatoController {
    
    @GetMapping("/cadastrarcontato")
    public String exibirListaContato(Model model){
        
        CadastroContatoDto cadastroDto = new CadastroContatoDto();
        
        model.addAttribute("contatoDto", cadastroDto);
        
        return "cadastrarcontato";
    }
}
