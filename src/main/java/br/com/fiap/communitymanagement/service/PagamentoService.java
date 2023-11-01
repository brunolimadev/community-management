package br.com.fiap.communitymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.dto.DadosPagamentoDto;
import br.com.fiap.communitymanagement.enumerator.FormaPagamentoEnum;
import br.com.fiap.communitymanagement.service.validators.pagamento.DadosPagamentoCartao;
import br.com.fiap.communitymanagement.service.validators.pagamento.DadosPagamentoDepositoBancario;
import br.com.fiap.communitymanagement.service.validators.pagamento.DadosPagamentoPix;

@Service
public class PagamentoService {
	@Autowired
	private List<DadosPagamentoCartao> validadoresCartao;

	@Autowired
	private List<DadosPagamentoPix> validadoresPix;

	@Autowired
	private List<DadosPagamentoDepositoBancario> validadoresDepositoBancario;

	public Boolean processar(DadosPagamentoDto dto) {
		FormaPagamentoEnum formaPagamento = FormaPagamentoEnum.getByCodigo(dto.formaPagamento());

		switch (formaPagamento) {

		case CARTAO_DE_CREDITO:
			processarPagamentoCartao(dto);
			break;

		case PIX:
			processarPagamentoPix(dto);
			break;

		case DEPOSITO_BANCARIO:
			processarPagamentoDepositoBancario(dto);
			break;

		default:
			throw new ValidacaoException("Forma de pagamento não encontrada!");
		}

		return true;
	}

	private void processarPagamentoDepositoBancario(DadosPagamentoDto dto) {
		this.validadoresDepositoBancario.forEach(vdb -> vdb.validar(dto));

	}

	private void processarPagamentoCartao(DadosPagamentoDto dto) {
		this.validadoresCartao.forEach(vc -> vc.validar(dto));
	}

	private void processarPagamentoPix(DadosPagamentoDto dadosCartao) {
		this.validadoresPix.forEach(vp -> vp.validar(dadosCartao));
	}

}
