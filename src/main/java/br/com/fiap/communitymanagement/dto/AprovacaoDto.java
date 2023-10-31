package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record AprovacaoDto(
        UUID id,
        String statusAprovacao
) { }