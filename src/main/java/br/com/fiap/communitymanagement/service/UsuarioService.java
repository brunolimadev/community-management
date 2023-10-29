package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.entities.UsuarioEntity;
import br.com.fiap.communitymanagement.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public void save() {
        for (int i = 1; i <= 4; i++) {
            repository.save(createAdmMock());
        }
    }

    private UsuarioEntity createAdmMock() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        UUID id = UUID.randomUUID();
        String mockId = id.toString();
        usuarioEntity.setId(id);
        usuarioEntity.setCpf("444.555.674-01");
        usuarioEntity.setNome("Adm mock " + mockId);
        usuarioEntity.setEmail("mockAdm" + mockId + "@gmail.com");
        usuarioEntity.setTipoUsuario("A");
        usuarioEntity.setComunidadeId(id);
        return usuarioEntity;
    }
}