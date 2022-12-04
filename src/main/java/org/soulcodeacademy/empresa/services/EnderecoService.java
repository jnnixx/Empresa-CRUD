package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.reporsitories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEndereco() {
        return this.enderecoRepository.findAll();
    }

    public Endereco getEndereco(Integer idEndereco) {
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);
        if (endereco.isEmpty()) {
            throw new RuntimeException("Empregado não foi encontrado");
        } else {
            return endereco.get();
        }
    }

    public Endereco salvarEndereco(EnderecoDTO enderecoDTO){

        Endereco enderecoNovo = new Endereco(null, enderecoDTO.getCidade(), enderecoDTO.getUf());

        return this.enderecoRepository.save(enderecoNovo);
    }

    public Endereco atualizarEndereco(Integer idEndereco, EnderecoDTO enderecoDTO){

        Endereco enderecoAtualizado = this.getEndereco(idEndereco);

        enderecoAtualizado.setCidade(enderecoDTO.getCidade());
        enderecoAtualizado.setUf(enderecoDTO.getUf());

        return this.enderecoRepository.save(enderecoAtualizado);
    }

    public void deletarEndereco(Integer idEndereco){
        Endereco endereco = this.getEndereco(idEndereco);

        this.enderecoRepository.delete(endereco);
    }
}