package br.ufpb.dcx.aps.atividades.banco;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Conta {
    Locale brasil = new Locale("pt", "BR");
    private Correntista correntista;
    private int numero;
    private List<Transacao> transacoes = new ArrayList<>();
    private Banco banco;

    public Conta(Correntista correntista, int numero, Banco banco) {
        this.correntista = correntista;
        this.banco = banco;
    }

    public Transacao depositar(double valor) {

        Transacao transacao = new Transacao(transacoes.size(), valor);
        transacoes.add(transacao);
        return transacao;

    }

    public Transacao sacar(double valor) {

        Transacao sacar = new Transacao(transacoes.size(), -valor);
        transacoes.add(sacar);
        return sacar;
    }

    public double saldo() {
        return transacoes.size();
    }

    public String extrato() {
        String extrato = ">> " + banco.getNome() + "\n" + ">> Correntista: \n" + " CPF: " + correntista.getCpf() + "\n " + correntista.getNome() + "\n> EXTRATO\n" +
                "------------------------------------\n";
        for (Transacao transacao : transacoes) {
            extrato = transacao.toString();
        }

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(brasil);
        return extrato;
        //ainda falta deu uma cansada
    }

    public Integer getNumero() {
        return numero;
    }
}
