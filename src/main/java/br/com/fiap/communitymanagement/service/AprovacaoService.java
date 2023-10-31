package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.controller.exception.ControllerNotFoundException;
import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.entities.AprovacaoEntity;
import br.com.fiap.communitymanagement.entities.VagaEntity;
import br.com.fiap.communitymanagement.repository.AprovacaoRepository;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprovacaoService {
    @Autowired
    private AprovacaoRepository aprovacaoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    public AprovacaoDto save(AprovacaoDto aprovacaoDto) {
        try {
            VagaEntity vaga = vagaRepository.getReferenceById(aprovacaoDto.vagaId());
            vaga.setStatusAprovacao(aprovacaoDto.statusAprovacao());
            vagaRepository.save(vaga);
        }  catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Vaga não encontrada");
        }
        return toAprovacaoDto(aprovacaoRepository.save(toAprovacaoEntity(aprovacaoDto)));
    }

    private AprovacaoEntity toAprovacaoEntity(AprovacaoDto aprovacaoDto) {
        AprovacaoEntity aprovacaoEntity = new AprovacaoEntity();
        aprovacaoEntity.setVagaId(aprovacaoDto.vagaId());
        aprovacaoEntity.setUsuarioId(aprovacaoDto.usuarioId());
        aprovacaoEntity.setStatusAprovacao(aprovacaoDto.statusAprovacao());

        return aprovacaoEntity;
    }

    private AprovacaoDto toAprovacaoDto(AprovacaoEntity aprovacaoEntity) {
        return new AprovacaoDto(
                aprovacaoEntity.getId(),
                aprovacaoEntity.getVagaId(),
                aprovacaoEntity.getUsuarioId(),
                aprovacaoEntity.getStatusAprovacao()
        );
    }
}