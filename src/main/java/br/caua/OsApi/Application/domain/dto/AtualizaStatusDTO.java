package br.caua.OsApi.Application.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AtualizaStatusDTO(
    @NotBlank(message = "O status não pode estar vazio")
    String status
) {}