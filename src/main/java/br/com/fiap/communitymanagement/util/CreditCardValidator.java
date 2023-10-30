package br.com.fiap.communitymanagement.util;

import java.util.Objects;

import br.com.fiap.communitymanagement.exceptions.PaymentException;

public class CreditCardValidator {

	public static boolean validateCardNumber(String numero) {

		numero = numero.replaceAll("[^0-9]", "");

		if (!numero.matches("^(?!\\s*$)\\d{16}$")) {
			throw new PaymentException("Pagamento não aprovado: Numero do cartão inválido!");
		}
		return true;
	}

	// Valida a data de validade do cartão de crédito (no formato MM/YY)
	public static boolean validateExpirationDate(String dataValidade) {

		String[] partes = dataValidade.split("/");
		if (partes.length != 2 || partes[0].length()  !=2 || partes[1].length() != 2) {
			throw new PaymentException("Pagamento não aprocado: Formato de data inválido");
		}

		int mes = Integer.parseInt(partes[0]);
		int ano = Integer.parseInt(partes[1]) + 2000; // Supondo que os anos sejam fornecidos nos últimos dois dígitos
		
		if(mes > 12 || mes < 1) {
			throw new PaymentException("Pagamento não aprocado: Mes/Ano informado inexistente!");
		}
		
		// Obtém o ano atual
		int anoAtual = java.time.Year.now().getValue();

		// Verifica se a data de validade é válida (não anterior à data atual)
		if (ano < anoAtual || (ano == anoAtual && mes < java.time.MonthDay.now().getMonthValue())) {
			throw new PaymentException("Pagamento não aprocado: Data de validade expirada!");
		}
		return true;
	}

	// Método para validar o código CVC do cartão de crédito
	public static boolean validateSecurityCode(String cvc) {
		if (Objects.isNull(cvc)|| cvc.isEmpty() || !cvc.matches("\\d{3}")) {
			throw new PaymentException("Pagamento não Aprovado: Código de segurança inválido!");
		}
		return true;
	}

	public static boolean validateAmount(Double valor) {
		if (Objects.isNull(valor) || valor < 0 || valor == 0) {
			throw new PaymentException("Pagamento não Aprovado: Valor da transação inválido!");
		}
		return true;
	}

	public static boolean validatePix(String numero) {

		if (Objects.isNull(numero) || numero.length() == 0 ) {
			throw new PaymentException("Pagamento não Aprovado: Código validação pix não enviado!");
		}
		return true;
	}

}
