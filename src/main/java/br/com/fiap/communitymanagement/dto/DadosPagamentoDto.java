package br.com.fiap.communitymanagement.dto;

public record DadosPagamentoDto(
		int formaPagamento,
		Double valorCompra,
		String numeroCartao,
		String dataValidade,
		String codigoSeguranca,
		String validacaoPix,
		String agencia,
		String conta
		
		) 
		{}
