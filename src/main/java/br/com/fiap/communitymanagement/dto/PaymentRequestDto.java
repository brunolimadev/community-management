package br.com.fiap.communitymanagement.dto;

public record PaymentRequestDto(
		FormOfPaymentDto formaPagamento,
		Double valorCompra,
		String numeroCartao,
		String dataValidade,
		String codigoSeguranca,
		String validacaoPix
		) 
		{}
