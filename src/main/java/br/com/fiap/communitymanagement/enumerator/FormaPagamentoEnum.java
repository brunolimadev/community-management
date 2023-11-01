package br.com.fiap.communitymanagement.enumerator;

public enum FormaPagamentoEnum {
    CARTAO_DE_CREDITO(1),
    PIX(2),
    DEPOSITO_BANCARIO(3),
    NOT_FOUND(4);

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