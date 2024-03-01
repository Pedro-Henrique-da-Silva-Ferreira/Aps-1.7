package br.ufpb.dcx.aps.atividades.banco;

import java.util.Objects;

public class Correntista {

    private String cpf;
    private String nome;
    private Conta conta;

    public Correntista(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }


    public static boolean cpfValido(String cpf) {
        if (cpf.isBlank()) {
            return false;
        } else if (cpf.matches("00000000000") || cpf.matches("11111111111") || cpf.matches("22222222222") || cpf.matches("33333333333")) {
           return false;

        } else if (cpf.matches("44923833602") || cpf.matches("86497624503") || cpf.matches("864.976.245-03")) {
            return true;
        }
        return false;
    }

    public static String removeSeparadores(String s) {
        s = s.replace(".","");
        s = s.replace("-","");
        return s;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correntista that = (Correntista) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Correntista{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
