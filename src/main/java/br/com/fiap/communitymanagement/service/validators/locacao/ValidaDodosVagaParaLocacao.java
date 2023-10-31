package br.com.fiap.communitymanagement.service.validators.locacao;

import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.dto.PaymentRequestDto;
import br.com.fiap.communitymanagement.entities.VagaEntity;
import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.enumerator.FormaPagamentoEnum;
import br.com.fiap.communitymanagement.enumerator.StatusAprovacaoEnum;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import br.com.fiap.communitymanagement.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidaDodosVagaParaLocacao implements DadosLocacaoValidadores {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private PagamentoService pagamentoService;

    @Override
    public void validar(LocacaoDto locacaoDto) {

        if (locacaoDto.vagaId() == null) {
            throw new ValidacaoException("Id da vaga deve ser preechido!");
        }

        Optional<VagaEntity> vaga = vagaRepository.findById(locacaoDto.vagaId());

        if (vaga.isEmpty()) {
            throw new ValidacaoException("Vaga não encontrada!");
        }

        if (!vaga.get().getStatusAprovacao().equals(StatusAprovacaoEnum.APROVADO.name())) {
            throw new ValidacaoException("A vaga não esta aprovada para locação!");
        }

        if (!pagamentoService.processPaymentPix(new PaymentRequestDto(FormaPagamentoEnum.PIX.getCodigo(),
                null,
                null,
                null,
                null,
                vaga.get().getChavePixRecebimento()))) {
            throw new ValidacaoException("Ocorreu um erro ao tentar efetuar o pagamento para locação");
        }

    }
}
