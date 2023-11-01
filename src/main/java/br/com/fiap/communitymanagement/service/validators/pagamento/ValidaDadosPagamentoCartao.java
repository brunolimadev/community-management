package br.com.fiap.communitymanagement.service.validators.pagamento;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.dto.DadosPagamentoDto;

@Component
public class ValidaDadosPagamentoCartao implements DadosPagamentoCartao {

	@Override
	public void validar(DadosPagamentoDto pagamentoCartaoDto) {

		validarNumeroCartao(pagamentoCartaoDto.numeroCartao());
		validarDataValidade(pagamentoCartaoDto.dataValidade());
		validarCodigoSeguranca(pagamentoCartaoDto.codigoSeguranca());
		validarValorCompra(pagamentoCartaoDto.valorCompra());

	}

	private void validarValorCompra(Double valor) {
		if (Objects.isNull(valor) || valor < 0 || valor == 0) {
			throw new ValidacaoException("Pagamento não Aprovado: Valor da transação inválido!");
		}

	}

	private void validarCodigoSeguranca(String codigoSeguranca) {

		if (Objects.isNull(codigoSeguranca) || codigoSeguranca.isEmpty() || !codigoSeguranca.matches("\\d{3}")) {
			throw new ValidacaoException("Pagamento não Aprovado: Código de segurança inválido!");
		}

	}

	// Valida a data de validade do cartão de crédito (no formato MM/YY)
	private void validarDataValidade(String dataValidade) {

		String[] partes = dataValidade.split("/");

		if (partes.length != 2 || partes[0].length() != 2 || partes[1].length() != 2) {
			throw new ValidacaoException("Pagamento não aprovado: Formato de data inválido");
		}

		int mes = Integer.parseInt(partes[0]);
		int ano = Integer.parseInt(partes[1]) + 2000; // Supondo que os anos sejam fornecidos nos últimos dois dígitos

		if (mes > 12 || mes < 1) {
			throw new ValidacaoException("Pagamento não aprovado: Mes/Ano informado inexistente!");
		}

		// Obtém o ano atual
		int anoAtual = java.time.Year.now().getValue();

		// Verifica se a data de validade é válida (não anterior à data atual)
		if (ano < anoAtual || (ano == anoAtual && mes < java.time.MonthDay.now().getMonthValue())) {
			throw new ValidacaoException("Pagamento não aprovado: Data de validade expirada!");
		}
	}

	private void validarNumeroCartao(String numeroCartao) {
		if (numeroCartao.matches("^(?!\\s*$)\\d{16}$")) {
			throw new ValidacaoException("Pagamento não aprovado: Numero do cartão inválido!");
		}
	}

}
