package br.com.fiap.communitymanagement.service.validators.locacao;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidaDodosPeriodoParaLocacao implements DadosLocacaoValidadores{
    @Override
    public void validar(LocacaoDto locacaoDto) {

        if (locacaoDto.periodoLocacao() <= 0) {
            throw new ValidacaoException("O período de locação precisa ser preenchido!");
        }

        if (locacaoDto.periodoLocacao() > 24) {
            throw new ValidacaoException("O perído de locação não pode ser maior que dois anso!");
        }

    }
}
