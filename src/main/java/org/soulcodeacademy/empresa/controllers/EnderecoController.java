package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/enderecos")
    public List<Endereco> listarEndereco(){
        return this.enderecoService.listarEndereco();
    }

    @GetMapping("/enderecos/{idEndereco}")
    public Endereco getEndereco(@PathVariable Integer idEndereco){
        return this.enderecoService.getEndereco(idEndereco);
    }

    @PostMapping("/enderecos")
    public Endereco salvarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO){
       return this.enderecoService.salvarEndereco(enderecoDTO);
    }

    @PutMapping("/enderecos/{idEndereco}")
    public Endereco enderecoAtualizado(@PathVariable Integer idEndereco, @Valid @RequestBody  EnderecoDTO enderecoDTO){
        return this.enderecoService.atualizarEndereco(idEndereco, enderecoDTO);
    }

    @DeleteMapping("/enderecos/{idEndereco}")
    public void deletarEndereco(@PathVariable Integer idEndereco){
        this.enderecoService.deletarEndereco(idEndereco);
    }
}
