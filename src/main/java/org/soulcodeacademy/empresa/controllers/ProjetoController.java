package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/projetos")
    public List<Projeto> listarProjeto(){
        return this.projetoService.listarProjeto();
    }

    @GetMapping("/projetos/{idProjeto}")
    public Projeto getProjeto(@PathVariable Integer idProjeto){
        return this.projetoService.getProjeto(idProjeto);
    }

    @PostMapping("/projetos")
    public Projeto salvarProjeto(@Valid @RequestBody ProjetoDTO projetoDTO){
        return this.projetoService.salvarProjeto(projetoDTO);
    }

    @PutMapping("/projetos/{idProjeto}")
    public Projeto atualizarProjeto(@PathVariable Integer idProjeto, @Valid @RequestBody ProjetoDTO projetoDTO){
        Projeto atualizado = this.projetoService.atualizarProjeto(idProjeto, projetoDTO);

        return atualizado;
    }

    @DeleteMapping("/projetos/{idProjeto}")
    public void deletarProjeto(@PathVariable Integer idProjeto){
        this.projetoService.deletarProjeto(idProjeto);
    }
}
