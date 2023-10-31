package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.entities.AprovacaoEntity;
import br.com.fiap.communitymanagement.repository.AprovacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprovacaoService {
    @Autowired
    private AprovacaoRepository aprovacaoRepository;

    public AprovacaoDto save(AprovacaoDto aprovacaoDto) {
        return toAprovacaoDto(aprovacaoRepository.save(toAprovacaoEntity(aprovacaoDto)));
    }

    private AprovacaoEntity toAprovacaoEntity(AprovacaoDto aprovacaoDto) {
        AprovacaoEntity aprovacaoEntity = new AprovacaoEntity();
        aprovacaoEntity.setVagaId(aprovacaoDto.vagaId());
        aprovacaoEntity.setUsuarioLocatarioId(aprovacaoDto.usuarioLocatarioId());
        aprovacaoEntity.setUsuarioId(aprovacaoDto.usuarioId());
        aprovacaoEntity.setStatusAprovacao(aprovacaoDto.statusAprovacao());

        return aprovacaoEntity;
    }

    private AprovacaoDto toAprovacaoDto(AprovacaoEntity aprovacaoEntity) {
        return new AprovacaoDto(
                aprovacaoEntity.getId(),
                aprovacaoEntity.getVagaId(),
                aprovacaoEntity.getUsuarioLocatarioId(),
                aprovacaoEntity.getUsuarioId(),
                aprovacaoEntity.getStatusAprovacao()
        );
    }
}