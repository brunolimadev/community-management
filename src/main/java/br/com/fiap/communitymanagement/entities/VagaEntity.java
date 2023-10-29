package br.com.fiap.communitymanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_vaga")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VagaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String tipoVaga;
    private LocalDate dataInicioLocacao;
    private LocalDate dataFimLocacao;
    private String agenciaRecebimento;
    private String contaRecebimento;
    private String chavePixRecebimento;
    private UUID usuarioId;
}