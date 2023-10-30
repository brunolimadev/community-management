package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record LocacaoDto(
        UUID id,
        UUID vagaId,
        UUID usuarioId,
        UUID usuarioLocatarioId,
        String status,
        int periodoLocacao
) {
}