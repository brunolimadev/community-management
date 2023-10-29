package br.com.fiap.communitymanagement.dto;

import java.time.LocalDateTime;

public record VagaDto (
        String tipoVaga,
        String dataInicioLocacao,
        String dataFimLocacao,
        String agenciaRecebimento,
        String contaRecebimento,
        String chavePixRecebimento
) {}
