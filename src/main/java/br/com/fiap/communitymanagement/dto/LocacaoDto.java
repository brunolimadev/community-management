package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record LocacaoDto(
        UUID id,
        UUID vagaId
) {
}