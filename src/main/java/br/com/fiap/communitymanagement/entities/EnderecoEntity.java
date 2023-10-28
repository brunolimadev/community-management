package br.com.fiap.communitymanagement.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoEntity {
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
}