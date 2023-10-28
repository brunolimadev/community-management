package br.com.fiap.communitymanagement.entitie;

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
    private String nomeComunidade;
    private AdministradorComunidadeEntity administradorComunidadeEntity;
    private List<MoradorComunidadeEntity> moradorComunidadeEntityList;
}