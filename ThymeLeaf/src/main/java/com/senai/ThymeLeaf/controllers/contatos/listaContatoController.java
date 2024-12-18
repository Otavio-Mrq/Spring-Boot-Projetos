/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.ThymeLeaf.controllers.contatos;


import com.senai.ThymeLeaf.services.ContatoService;
import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class listaContatoController {
    
    @Autowired
    ContatoService contatoService;
    
    @GetMapping("/listacontato")
    public String exibirListaUsuarios(Model model){
                     
        model.addAttribute("contatos",contatoService.obterListaContatos());
        
        //--template : retorna o nome do arquivo html localizado lá na pasta templates.
        return "listacontato";
}
}
