package br.com.fiap.communitymanagement.enums;

public enum FormaPagamentoEnum {
    CARTAO_DE_CREDITO(1),
    PIX(2),
    NOT_FOUND(3);

    private final int codigo;

    FormaPagamentoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static FormaPagamentoEnum getByCodigo(int codigo) {
        for (FormaPagamentoEnum formaPagamento : values()) {
            if (formaPagamento.getCodigo() == codigo) {
                return formaPagamento;
            }
        }
        return NOT_FOUND;
    }
    
}