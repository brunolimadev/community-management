package br.com.fiap.communitymanagement.dto;


import java.util.UUID;

public record VagaDto (
        UUID id,
        String tipoVaga,
        String dataInicioLocacao,
        String dataFimLocacao,
        String agenciaRecebimento,
        String contaRecebimento,
        String chavePixRecebimento,
        String statusAprovacao
) {}
