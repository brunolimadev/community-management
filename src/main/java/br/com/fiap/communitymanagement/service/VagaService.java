package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.entitie.VagaEntity;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public VagaDto save(VagaDto vaga) {
        return toVagaDto(vagaRepository.save(toVagaEntity(vaga)));
    }

    private VagaDto toVagaDto(VagaEntity vaga) {
        return new VagaDto(vaga.getId(), vaga.getDescription());
    }

    private VagaEntity toVagaEntity(VagaDto vaga) {
        return new VagaEntity(vaga.id(), vaga.description());
    }
}