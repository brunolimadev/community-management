package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.AprovacaoDto;
import br.com.fiap.communitymanagement.dto.VagaDto;
import br.com.fiap.communitymanagement.entities.AprovacaoEntity;
import br.com.fiap.communitymanagement.repository.AprovacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AprovacaoService {
    @Autowired
    private AprovacaoRepository aprovacaoRepository;

    @Autowired
    private VagaService vagaService;

    public AprovacaoDto save(AprovacaoDto aprovacaoDto) {
        VagaDto vagaDto = vagaService.findById(aprovacaoDto.vagaId());
        vagaService.update(aprovacaoDto.vagaId(), new VagaDto(
                vagaDto.id(),
                vagaDto.tipoVaga(),
                vagaDto.dataInicioLocacao(),
                vagaDto.dataFimLocacao(),
                vagaDto.agenciaRecebimento(),
                vagaDto.contaRecebimento(),
                vagaDto.chavePixRecebimento(),
                vagaDto.usuarioId(),
                aprovacaoDto.statusAprovacao()
        ));
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