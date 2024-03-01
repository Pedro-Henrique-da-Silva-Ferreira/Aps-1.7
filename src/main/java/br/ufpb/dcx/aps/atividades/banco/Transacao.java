package br.ufpb.dcx.aps.atividades.banco;

import java.util.Calendar;

public class Transacao {
    private int id;
    private Calendar data;
    private double valor;


    public Transacao(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }


    public int getId() {
        return id;
    }

    public Calendar getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Trasacao\n" + "id:" + id + ", data:" + data + ", valor:" + valor;
    }
}
