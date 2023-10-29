package br.com.fiap.communitymanagement.dto;

import java.util.UUID;

public record UsuarioDto (
        UUID id,
        String nome,
        String email,
        String cpf,
        String tipoUsuario,
        UUID comunidadeId
) { }