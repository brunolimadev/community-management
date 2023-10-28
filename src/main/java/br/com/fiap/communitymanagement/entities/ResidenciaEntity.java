package br.com.fiap.communitymanagement.entities;

import lombok.*;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResidenciaEntity {
    private UUID id;
    private EnderecoEntity enderecoEntity;
}