package br.com.fiap.communitymanagement.entities;

import br.com.fiap.communitymanagement.enumerator.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "tbl_usuario_comunidade")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private String tipoUsuario;
    private UUID comunidadeId;
}