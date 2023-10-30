package br.com.fiap.communitymanagement.service.validators.locacao;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidaDodosUsuarioIdParaLocacao implements DadosLocacaoValidadores{
    @Override
    public void validar(LocacaoDto locacaoDto) {

        if (locacaoDto.usuarioId() == null) {
            throw new ValidacaoException("Id do locador deve ser preechido!");
        }

        if (locacaoDto.usuarioLocatarioId() == null) {
            throw new ValidacaoException("Id do locatário deve ser preechido!");
        }

    }
}
