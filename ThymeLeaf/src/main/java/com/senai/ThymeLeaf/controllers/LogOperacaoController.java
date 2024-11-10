package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.LogOperacao;
import com.senai.ThymeLeaf.services.LogOperacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auditoria")
public class LogOperacaoController {
    @Autowired
    private LogOperacaoService auditoriaServices;

    @GetMapping
    public String exibirAuditoria(Model model) {
        List<LogOperacao> auditorias = auditoriaServices.obterRevisoes();
        model.addAttribute("auditorias", auditorias);
        return "auditoria";
    }
}
