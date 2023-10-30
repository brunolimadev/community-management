package br.com.fiap.communitymanagement.service;

import org.springframework.stereotype.Service;

import br.com.fiap.communitymanagement.dto.PaymentRequestDto;
import br.com.fiap.communitymanagement.dto.PaymentResponseDto;
import br.com.fiap.communitymanagement.enums.FormaPagamentoEnum;
import br.com.fiap.communitymanagement.exceptions.ValidacaoException;
import br.com.fiap.communitymanagement.util.CreditCardValidator;

@Service
public class PaymentService {

	public PaymentResponseDto process(PaymentRequestDto dto) {

		Integer idTransacao = dto.formaPagamento().codigo();
		FormaPagamentoEnum formaPagamento = FormaPagamentoEnum.getByCodigo(idTransacao);

		switch (formaPagamento) {

		case CARTAO_DE_CREDITO:
			processPaymentCard(dto);
			break;

		case PIX:
			processPaymentPix(dto);
			break;

		default:
			throw new ValidacaoException("Forma de pagamento não encontrada!");
		}

		return new PaymentResponseDto("Pagamento aprovado!");
	}

	public boolean processPaymentCard(PaymentRequestDto dadosCartao) {
		return  validateCard(dadosCartao);
	}

	public boolean processPaymentPix(PaymentRequestDto dadosCartao) {
		return validatePixData(dadosCartao);
	}

	private Boolean validateCard(PaymentRequestDto dadosCartao) {
		 CreditCardValidator.validateCardNumber(dadosCartao.numeroCartao());
		 CreditCardValidator.validateExpirationDate(dadosCartao.dataValidade());
		 CreditCardValidator.validateSecurityCode(dadosCartao.codigoSeguranca());
		 CreditCardValidator.validateAmount(dadosCartao.valorCompra());
		return true;
	}

	private boolean validatePixData(PaymentRequestDto dadosCartao) {
		return CreditCardValidator.validatePix(dadosCartao.validacaoPix());
	}

}
