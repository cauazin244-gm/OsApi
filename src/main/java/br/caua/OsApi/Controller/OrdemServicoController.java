/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.caua.OsApi.Controller;

/**
 *
 * @author digma
 */
import br.caua.OsApi.Application.domain.dto.AtualizaStatusDTO;
import br.caua.OsApi.Application.domain.service.OrdemServicoService;
import br.caua.OsApi.domain.model.OrdemServico;
import br.caua.OsApi.domain.model.OrdemServico;
import br.caua.OsApi.Application.domain.service.OrdemServicoService;
import br.caua.OsApi.domain.model.StatusOrdemServico;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }
 
    @PutMapping("/atualiza-status/{ordemServicoID}")
    public ResponseEntity<OrdemServico> atualizaStatus(
            @PathVariable Long ordemServicoID,
            @Valid @RequestBody AtualizaStatusDTO statusDTO) {

        Optional<OrdemServico> optOS;
        optOS = ordemServicoService.atualizaStatus(
                ordemServicoID,
                StatusOrdemServico.valueOf(statusDTO.status())
        );

        if (optOS.isPresent()) {
            return ResponseEntity.ok(optOS.get());

        } else {
            return ResponseEntity.notFound().build();

        }

    }
    
}
