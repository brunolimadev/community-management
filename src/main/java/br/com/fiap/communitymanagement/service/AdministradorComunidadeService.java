package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.entitie.AdministradorComunidadeEntity;
import br.com.fiap.communitymanagement.repository.AdministradorComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdministradorComunidadeService {
    @Autowired
    private AdministradorComunidadeRepository repository;

    public void save() {
        for (int i = 1; i <= 4; i++) {
            repository.save(createAdmMock());
        }
    }

    private AdministradorComunidadeEntity createAdmMock() {
        AdministradorComunidadeEntity administradorComunidade = new AdministradorComunidadeEntity();
        UUID id = UUID.randomUUID();
        String mockId = id.toString();
        administradorComunidade.setId(id);
        administradorComunidade.setCpf(mockId);
        administradorComunidade.setNome("Adm mock " + mockId);
        administradorComunidade.setResidenciaEntity(null);
        return administradorComunidade;
    }
}