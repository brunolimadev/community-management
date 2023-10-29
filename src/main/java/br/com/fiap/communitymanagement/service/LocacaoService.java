package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.entities.LocacaoEntity;
import br.com.fiap.communitymanagement.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;

    public LocacaoDto save(LocacaoDto locacaoDto) {
        return toLocacaoDto(locacaoRepository.save(toLocacaoEntity(locacaoDto)));
    }

    private LocacaoEntity toLocacaoEntity(LocacaoDto locacaoDto) {
        LocacaoEntity locacaoEntity = new LocacaoEntity();
        locacaoEntity.setVagaId(locacaoDto.vagaId());

        return locacaoEntity;
    }

    private LocacaoDto toLocacaoDto(LocacaoEntity locacaoEntity) {
        return new LocacaoDto(locacaoEntity.getId(), locacaoEntity.getVagaId());
    }

}