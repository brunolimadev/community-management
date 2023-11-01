package br.com.fiap.communitymanagement.service.validators.pagamento;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.dto.DadosPagamentoDto;

@Component
public class ValidaDadosPagamentoDepositoBancario implements DadosPagamentoDepositoBancario {

	@Override
	public void validar(DadosPagamentoDto pagamentoDto) {

		if (Objects.isNull(pagamentoDto.agencia()) || pagamentoDto.agencia().isEmpty()
				|| !pagamentoDto.agencia().matches("^\\d{1,5}(\\d|X)$")) {
			throw new ValidacaoException("Pagamento não Aprovado: Código da agência inválido!");
		}

		if (Objects.isNull(pagamentoDto.conta()) || pagamentoDto.conta().isEmpty()
				|| !pagamentoDto.agencia().matches("^\\d{1,12}$")) {
			throw new ValidacaoException("Pagamento não Aprovado: Número da conta inválido!");
		}
	}

}
