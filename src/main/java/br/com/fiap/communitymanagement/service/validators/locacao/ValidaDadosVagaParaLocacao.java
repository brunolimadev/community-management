package br.com.fiap.communitymanagement.service.validators.locacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.communitymanagement.controller.exception.ValidacaoException;
import br.com.fiap.communitymanagement.dto.DadosPagamentoDto;
import br.com.fiap.communitymanagement.dto.LocacaoDto;
import br.com.fiap.communitymanagement.entities.VagaEntity;
import br.com.fiap.communitymanagement.enumerator.FormaPagamentoEnum;
import br.com.fiap.communitymanagement.enumerator.StatusAprovacaoEnum;
import br.com.fiap.communitymanagement.repository.VagaRepository;
import br.com.fiap.communitymanagement.service.PagamentoService;

@Component
public class ValidaDadosVagaParaLocacao implements DadosLocacaoValidadores {

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

//        if (!pagamentoService.processar(
//        		new DadosPagamentoDto(
//        		FormaPagamentoEnum.PIX.getCodigo(),
//                null,
//                null,
//                null,
//                null,
//                vaga.get().getChavePixRecebimento(),
//                null,
//                null)
//        		)) {
//            throw new ValidacaoException("Ocorreu um erro ao tentar efetuar o pagamento para locação");
//        }
        
        if (!pagamentoService.processar(
        		new DadosPagamentoDto(
        		FormaPagamentoEnum.DEPOSITO_BANCARIO.getCodigo(),
                null,
                null,
                null,
                null,
                vaga.get().getChavePixRecebimento(),
                vaga.get().getAgenciaRecebimento(),
                vaga.get().getContaRecebimento()
                 )
        		)) {
            throw new ValidacaoException("Ocorreu um erro ao tentar efetuar o pagamento para locação");
        }
    }
}
