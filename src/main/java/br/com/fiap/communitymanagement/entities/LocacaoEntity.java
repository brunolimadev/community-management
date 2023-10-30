package br.com.fiap.communitymanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tbl_locacao_vaga")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LocacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID vagaId;
    private UUID usuarioId;
    private UUID usuarioLocatarioId;
    private String status;
    private int periodoLocacao;
}