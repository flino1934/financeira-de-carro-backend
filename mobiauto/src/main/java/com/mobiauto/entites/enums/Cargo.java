package com.mobiauto.entites.enums;

public enum Cargo {
    PROPRIETARIO(1, "Proprietário"),
    GERENTE(2, "Gerente"),
    ASSISTENTE(3, "Assistente"),
    ADMIN(4, "Administrador");

    private final int codigo;
    private final String descricao;

    Cargo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Cargo fromCodigo(int codigo) {
        for (Cargo cargo : Cargo.values()) {
            if (cargo.codigo == codigo) {
                return cargo;
            }
        }
        throw new IllegalArgumentException("Código de cargo inválido: " + codigo);
    }

    public static Cargo fromDescricao(String descricao) {
        for (Cargo cargo : Cargo.values()) {
            if (cargo.descricao.equalsIgnoreCase(descricao)) {
                return cargo;
            }
        }
        throw new IllegalArgumentException("Descrição de cargo inválida: " + descricao);
    }
}
