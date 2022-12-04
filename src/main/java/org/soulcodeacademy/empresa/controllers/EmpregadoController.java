package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listarEmpregados(){
        return this.empregadoService.listarEmpregados();
    }

    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado){
        return this.empregadoService.getEmpregado(idEmpregado);
    }

    @PostMapping("/empregados")
    public Empregado salvarEmpregado(@Valid @RequestBody EmpregadoDTO empregadoDTO){
       return this.empregadoService.salvarEmpregado(empregadoDTO);
    }

    @PutMapping("/empregados/{idEmpregado}")
    public Empregado atualizarEmpregado(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizarEmpregado(idEmpregado, dto);
        return atualizado;
    }

    @DeleteMapping("/empregados/{idEmpregado}")
    public void deletarEmpregado(@PathVariable Integer idEmpregado) {
        this.empregadoService.deletarEmpregado(idEmpregado);
    }
}
