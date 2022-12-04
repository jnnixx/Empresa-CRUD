package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listarDependentes(){
        return this.dependenteService.listarDependentes();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return this.dependenteService.getDependete(idDependente);
    }

    @PostMapping("/dependentes")
    public Dependente salvarDependente(@Valid @RequestBody DependenteDTO dependenteDTO){
        return  this.dependenteService.salvarDependente(dependenteDTO);
    }

    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizarDependente(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dependenteDTO){
        return this.dependenteService.atualizarDependente(idDependente, dependenteDTO);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public void deletarDependente(@PathVariable Integer idDependete){
        this.dependenteService.deletarDependente(idDependete);
    }
}
