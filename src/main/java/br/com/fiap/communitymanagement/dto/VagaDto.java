package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record VagaDto (
        UUID id,
        String description
) {}
