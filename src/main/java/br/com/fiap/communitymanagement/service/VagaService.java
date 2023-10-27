package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.controller.exception.ControllerNotFoundException;
import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.entitie.VagaEntity;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public VagaDto save(VagaDto vaga) {
        return toVagaDto(vagaRepository.save(toVagaEntity(vaga)));
    }

    public Page<VagaDto>  findAll(Pageable pageable) {
        Page<VagaEntity> vagas = vagaRepository.findAll(pageable);
        return vagas.map(this::toVagaDto);
    }

    public VagaDto findById(UUID id) {
        VagaEntity vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Vaga não encontrada"));
        return this.toVagaDto(vaga);
    }

    public VagaDto update(UUID id, VagaDto vagaDto) {
        try {
            VagaEntity vaga = vagaRepository.getReferenceById(id);
            vaga.setDescription(vagaDto.description());
            vaga = vagaRepository.save(vaga);
            return this.toVagaDto(vaga);
        }  catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Vaga não encontrada");
        }

    }

    public void delete(UUID id) {
        vagaRepository.deleteById(id);
    }

    private VagaDto toVagaDto(VagaEntity vaga) {
        return new VagaDto(vaga.getId(), vaga.getDescription());
    }

    private VagaEntity toVagaEntity(VagaDto vaga) {
        return new VagaEntity(vaga.id(), vaga.description());
    }
}