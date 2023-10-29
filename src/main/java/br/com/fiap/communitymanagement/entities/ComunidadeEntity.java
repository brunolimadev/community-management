package br.com.fiap.communitymanagement.entities;

import lombok.*;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComunidadeEntity {
    private UUID id;
    private String nome;
    private List<UsuarioEntity> usuarioEntityList;
}