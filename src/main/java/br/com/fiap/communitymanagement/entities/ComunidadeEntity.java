package br.com.fiap.communitymanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "tbl_comunidade")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComunidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
}