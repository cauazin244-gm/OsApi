/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.caua.OsApi.domain.repository;

import br.caua.OsApi.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    
}
