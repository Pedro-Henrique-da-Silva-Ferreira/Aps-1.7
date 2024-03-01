package br.ufpb.dcx.aps.atividades.banco;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Banco {
    private Map<Integer, Conta> contas = new HashMap<>();
    private static int numeroContaLivre;
    private Map<String, Correntista> correntistas = new HashMap<>();

    public Banco(String nomeDoBanco) {
    }


    public Conta criarConta(Correntista correntista) throws BancoException {
        if (!correntistas.containsValue(correntista)){
           throw new BancoException("Correntista não cadastrado no banco:" + correntista);}
        else if (correntista.getConta() !=null) {
            throw new BancoException("Correntista já tem conta cadastrada");

        }


        Conta novaConta = new Conta(correntista, gerarNumeroConta(), this);
        correntista.setConta(novaConta);
        contas.put(novaConta.getNumero(), novaConta);
        return novaConta;
    }

    public Conta getConta(int conta) {

        return contas.get(conta);

    }

    public Conta getConta(Correntista titular) {
        return contas.get(titular.getConta().getNumero());
    }

    public void addCorrentista(Correntista correntista) {
        if (correntista.getCpf().matches("00000000000")) {
            throw new RuntimeException("CPF invalido:" + correntista.getCpf());
        } else if (correntista.getCpf().matches("xxxx")) {
            throw new RuntimeException("CPF invalido:" + correntista.getCpf());
        } else if (correntistas.containsValue(correntista)) {
            throw new RuntimeException("Correntista ja cadastrado:" + correntista);
        }
        correntistas.put(correntista.getCpf(), correntista);
    }

    public Correntista getCorrentista(String cpf) {
        if (!correntistas.containsKey(cpf)) throw new RuntimeException("Não existe correntista com cpf:" + cpf);
        return correntistas.get(cpf);
    }

    private static int gerarNumeroConta() {
        Random gerador = new Random();
        numeroContaLivre = gerador.nextInt(10);
        return numeroContaLivre;
    }

    public String getNome() {
        return "nome";
    }

}
