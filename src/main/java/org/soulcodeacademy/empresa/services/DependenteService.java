package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.reporsitories.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository dependenteRepository;

    @Autowired
    EmpregadoService empregadoService;

    public List<Dependente> listarDependentes(){
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependete(Integer idDependente){
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

        if(dependente.isEmpty()) {
            throw new RuntimeException("O dependente não foi encontrado!");
        }else{
            return dependente.get();
        }
    }

    public Dependente salvarDependente(DependenteDTO dependenteDTO){

        Empregado responsavel = this.empregadoService.getEmpregado(dependenteDTO.getIdResponsavel());

        Dependente novoDependente = new Dependente(null, dependenteDTO.getNome(), dependenteDTO.getIdade());
        novoDependente.setResponsavel(responsavel);

        Dependente dependenteSalvo = this.dependenteRepository.save(novoDependente);

        return dependenteSalvo;
    }

    public Dependente atualizarDependente(Integer idDependente, DependenteDTO dependenteDTO){
        Dependente dependenteAtual = this.getDependete(idDependente);
        Empregado responsavel = this.empregadoService.getEmpregado(dependenteDTO.getIdResponsavel());

        dependenteAtual.setNome(dependenteDTO.getNome());
        dependenteAtual.setIdade(dependenteDTO.getIdade());

        return this.dependenteRepository.save(dependenteAtual);
    }

    public void deletarDependente(Integer idDependente){
        Dependente dependente = this.getDependete(idDependente);
        this.dependenteRepository.delete(dependente);
    }
}
