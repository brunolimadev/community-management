package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record ComunidadeDto (
        UUID id,
        String nome
) { }