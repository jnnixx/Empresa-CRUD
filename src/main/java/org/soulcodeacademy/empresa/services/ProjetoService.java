package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.reporsitories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

   public List<Projeto> listarProjeto(){
       return this.projetoRepository.findAll();
   }

   public Projeto getProjeto(Integer idProjeto){
       Optional <Projeto> projeto = this.projetoRepository.findById(idProjeto);
       if(projeto.isEmpty()){
           throw new RuntimeException("Projeto não encontrado");
       }else{
           return projeto.get();
       }
   }

   public Projeto salvarProjeto(ProjetoDTO projetoDTO){
       Projeto novoProjeto = new Projeto(null,projetoDTO.getNome(),projetoDTO.getOrcamento(),projetoDTO.getDescricao());
       return this.projetoRepository.save(novoProjeto);
   }
   public Projeto atualizarProjeto(Integer idProjeto, ProjetoDTO projetoDTO){
       Projeto projetoAtual = this.getProjeto(idProjeto);

       projetoAtual.setNome(projetoDTO.getNome());
       projetoAtual.setOrcamento(projetoDTO.getOrcamento());
       projetoAtual.setDescricao(projetoDTO.getDescricao());

       return  this.projetoRepository.save(projetoAtual);
   }

   public void deletarProjeto(Integer idProjeto){
       Projeto projeto = this.getProjeto(idProjeto);
       this.projetoRepository.delete(projeto);
   }
}
