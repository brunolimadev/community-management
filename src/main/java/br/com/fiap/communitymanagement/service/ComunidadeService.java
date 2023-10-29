package br.com.fiap.communitymanagement.service;

import br.com.fiap.communitymanagement.dto.ComunidadeDto;
import br.com.fiap.communitymanagement.entities.ComunidadeEntity;
import br.com.fiap.communitymanagement.repository.ComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComunidadeService {
    @Autowired
    private ComunidadeRepository comunidadeRepository;

    public void mock() {
        comunidadeRepository.save(criarComunidadeEntity(criarComunidadeDto("Condomínio Cerejeiras III")));
        comunidadeRepository.save(criarComunidadeEntity(criarComunidadeDto("Rua sem saída 56")));
        comunidadeRepository.save(criarComunidadeEntity(criarComunidadeDto("Conjunto Residencial Sábia Laranjeira")));
        comunidadeRepository.save(criarComunidadeEntity(criarComunidadeDto("Comunidade do Pajé")));
    }

    public Page<ComunidadeDto> findAll(Pageable pageable) {
        Page<ComunidadeEntity> comunidadeEntityPage = comunidadeRepository.findAll(pageable);
        return comunidadeEntityPage.map(this::toComunidadeDto);
    }

    private ComunidadeEntity criarComunidadeEntity(ComunidadeDto comunidadeDto) {
        ComunidadeEntity comunidadeEntity = new ComunidadeEntity();
        comunidadeEntity.setNome(comunidadeDto.nome());
        return comunidadeEntity;
    }

    private ComunidadeDto criarComunidadeDto(String nome) {
        return new ComunidadeDto(null, nome);
    }

    private ComunidadeDto toComunidadeDto(ComunidadeEntity comunidadeEntity) {
        return new ComunidadeDto(comunidadeEntity.getId(), comunidadeEntity.getNome());
    }

}