/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.caua.OsApi.Application.domain.service;

/**
 *
 * @author digma
 */
import br.caua.OsApi.domain.model.OrdemServico;
import br.caua.OsApi.domain.model.StatusOrdemServico;
import br.caua.OsApi.domain.repository.OrdemServicoRepository;
import br.caua.OsApi.domain.model.OrdemServico;
import br.caua.OsApi.domain.model.StatusOrdemServico;
import br.caua.OsApi.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico criar(OrdemServico ordemServico) {
        // Define o status inicial como ABERTA
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        
        // Define a data de abertura como o horário atual do sistema
        ordemServico.setDataAbertura(LocalDateTime.now());

        // Salva no banco de dados através do Repository
        return ordemServicoRepository.save(ordemServico);
    }
    
}
