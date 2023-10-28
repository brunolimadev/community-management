package br.com.fiap.communitymanagement.entitie;

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