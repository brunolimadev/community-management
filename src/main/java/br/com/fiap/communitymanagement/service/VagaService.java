package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.controller.exception.ControllerNotFoundException;
import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.entities.VagaEntity;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            vaga.setTipoVaga(vagaDto.tipoVaga());
            vaga = vagaRepository.save(vaga);
            return this.toVagaDto(vaga);
        }  catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Vaga não encontrada");
        }

    }

    public void delete(UUID id) {
        vagaRepository.deleteById(id);
    }

    private VagaDto toVagaDto(VagaEntity vagaEntity) {
        return new VagaDto(vagaEntity.getTipoVaga(),
                vagaEntity.getDataInicioLocacao().toString(),
                vagaEntity.getDataFimLocacao().toString(),
                vagaEntity.getAgenciaRecebimento(),
                vagaEntity.getContaRecebimento(),
                vagaEntity.getChavePixRecebimento());
    }

    private VagaEntity toVagaEntity(VagaDto vagaDto) {
        VagaEntity vagaEntity = new VagaEntity();
        vagaEntity.setTipoVaga(vagaDto.tipoVaga());
        vagaEntity.setDataInicioLocacao(LocalDate.parse(vagaDto.dataInicioLocacao(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        vagaEntity.setDataFimLocacao(LocalDate.parse(vagaDto.dataFimLocacao(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        vagaEntity.setAgenciaRecebimento(vagaDto.agenciaRecebimento());
        vagaEntity.setContaRecebimento(vagaDto.contaRecebimento());
        vagaEntity.setChavePixRecebimento(vagaDto.chavePixRecebimento());
        return vagaEntity;
    }
}