package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.entities.LocacaoEntity;
import br.com.fiap.communitymanagement.repository.LocacaoRepository;
import br.com.fiap.communitymanagement.service.validators.locacao.DadosLocacaoValidadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private List<DadosLocacaoValidadores> validadores;

    public LocacaoDto save(LocacaoDto locacaoDto) {
        this.validadores.forEach(validador -> validador.validar(locacaoDto));
        return toLocacaoDto(locacaoRepository.save(toLocacaoEntity(locacaoDto)));
    }

    private LocacaoEntity toLocacaoEntity(LocacaoDto locacaoDto) {
        LocacaoEntity locacaoEntity = new LocacaoEntity();
        locacaoEntity.setVagaId(locacaoDto.vagaId());

        return locacaoEntity;
    }

    private LocacaoDto toLocacaoDto(LocacaoEntity locacaoEntity) {
        return new LocacaoDto(
                locacaoEntity.getId(),
                locacaoEntity.getVagaId()
        );
    }

}