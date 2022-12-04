package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.reporsitories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @Autowired
    EnderecoService enderecoService;

    public List<Empregado> listarEmpregados(){
        return this.empregadoRepository.findAll();
    }

    public Empregado getEmpregado(Integer idEmpregado){
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

        if (empregado.isEmpty()){
            throw new RuntimeException ("Empregado não foi encontrado!");
        } else {
            return empregado.get();
        }
    }

    public Empregado salvarEmpregado(EmpregadoDTO empregadoDTO){

        Endereco enderecoAtual = this.enderecoService.getEndereco(empregadoDTO.getIdEndereco());

        Empregado novoEmpregado = new Empregado(null, empregadoDTO.getNome(), empregadoDTO.getEmail(), empregadoDTO.getSalario());
        novoEmpregado.setEndereco(enderecoAtual);

        Empregado empregadoSalvo = this.empregadoRepository.save(novoEmpregado);

        return empregadoSalvo;
    }

    public Empregado atualizarEmpregado(Integer idEmpregado, EmpregadoDTO empregadoDTO){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        Endereco endereco = this.enderecoService.getEndereco(empregadoDTO.getIdEndereco());

        empregadoAtual.setNome(empregadoDTO.getNome());
        empregadoAtual.setEmail(empregadoDTO.getEmail());
        empregadoAtual.setSalario(empregadoDTO.getSalario());

        return this.empregadoRepository.save(empregadoAtual);
    }

    public void deletarEmpregado(Integer idEmpregado) {
        Empregado empregado = this.getEmpregado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }
}
