package br.com.fiap.communitymanagement.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MoradorComunidadeEntity {
    private String nome;
    private String cpf;
    private ResidenciaEntity residenciaEntity;
}