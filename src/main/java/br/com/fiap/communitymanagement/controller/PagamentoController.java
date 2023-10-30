package br.com.fiap.communitymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.communitymanagement.dto.PaymentRequestDto;
import br.com.fiap.communitymanagement.dto.PaymentResponseDto;
import br.com.fiap.communitymanagement.service.PaymentService;

@RestController
@RequestMapping("/community-management/payments")
public class PagamentoController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<String> validarPagamento(@RequestBody PaymentRequestDto dadosCartao) {

		try {
			PaymentResponseDto retorno = paymentService.process(dadosCartao);  
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno.mensagem());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}
}
