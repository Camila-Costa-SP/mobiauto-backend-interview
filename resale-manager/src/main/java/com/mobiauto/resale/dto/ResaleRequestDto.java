package com.mobiauto.resale.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record ResaleRequestDto(
        @NotBlank
        @CNPJ(message = "CNPJ inválido. Por favor, forneça um CNPJ válido.")
        String cnpj,
        @NotBlank
        String socialName
){}