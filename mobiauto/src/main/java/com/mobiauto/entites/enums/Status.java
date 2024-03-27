package com.mobiauto.entites.enums;

public enum Status {
    NOVO(1, "Novo"),
    EM_ATENDIMENTO(2, "Em Atendimento"),
    CONCLUIDO(3, "Concluido");

    private final int codigo;
    private final String descricao;

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status fromCodigo(int codigo) {
        for (Status st : Status.values()) {
            if (st.codigo == codigo) {
                return st;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }

    public static Status fromDescricao(String descricao) {
        for (Status st : Status.values()) {
            if (st.descricao.equalsIgnoreCase(descricao)) {
                return st;
            }
        }
        throw new IllegalArgumentException("Descrição de status inválida: " + descricao);
    }
}
