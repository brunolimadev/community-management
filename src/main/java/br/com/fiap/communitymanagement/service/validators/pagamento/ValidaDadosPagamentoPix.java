package br.com.fiap.communitymanagement.service.validators.pagamento;

import java.util.Objects;
	
import org.springframework.stereotype.Component;

import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.dto.DadosPagamentoDto;

@Component
public class ValidaDadosPagamentoPix implements DadosPagamentoPix {

	@Override
	public void validar(DadosPagamentoDto pagamentoDto) {

		if (Objects.isNull(pagamentoDto.validacaoPix()) || pagamentoDto.validacaoPix().isEmpty()) {
			throw new ValidacaoException("Pagamento não Aprovado: Código do Pix inválido!");
		}

	}

}
