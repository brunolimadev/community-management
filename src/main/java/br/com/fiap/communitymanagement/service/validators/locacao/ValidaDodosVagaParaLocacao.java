package br.com.fiap.communitymanagement.service.validators.locacao;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.entities.VagaEntity;
import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidaDodosVagaParaLocacao implements DadosLocacaoValidadores {

    @Autowired
    private VagaRepository vagaRepository;

    @Override
    public void validar(LocacaoDto locacaoDto) {

        if (locacaoDto.vagaId() == null) {
            throw new ValidacaoException("Id da vaga deve ser preechido!");
        }

        Optional<VagaEntity> vaga = vagaRepository.findById(locacaoDto.vagaId());

        if (vaga.isEmpty()) {
            throw new ValidacaoException("Vaga não encontrada!");
        }

        if (!vaga.get().getStatusAprovacao().equals("APROVADA")) {
            throw new ValidacaoException("A vaga não esta aprovada para locação!");
        }
        
    }
}
