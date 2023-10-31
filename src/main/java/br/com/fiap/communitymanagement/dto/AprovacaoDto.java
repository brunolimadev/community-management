package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record AprovacaoDto(
        UUID id,
        UUID vagaId,
        UUID usuarioId,
        String statusAprovacao
) { }