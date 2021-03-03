/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import banco.Banco;
import contas.Conta;
import contas.ContaOrdem;
import java.sql.Timestamp;
import java.util.Scanner;
import movimentos.Deposito;
import movimentos.Levantamento;
import movimentos.Movimento;
import movimentos.Transferencia;

/**
 *
 * @author Administrator
 */
public class ContaOrdemUI extends ContaUI {
    
    public ContaOrdemUI(Conta c, Banco b) {
        super(c, b);
    }
    
    
    public void efetuarDeposito() {
        // pedir valor
        System.out.println("Digite o valor para depositar: ");
        Scanner input = new Scanner(System.in);
        double v = input.nextDouble();
        // depositar
        ContaOrdem co = (ContaOrdem) getConta();
        co.depositar(v);
        // criar movimento
        Deposito d = new Deposito();
        d.setValor(v);
        d.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        
        // juntar o movimento ao extracto
        co.getListaMovimentos().add(d);
    }
    
    public void efetuarLevantamento() {
          // pedir valor
        System.out.println("Digite o valor para levantar: ");
        Scanner input = new Scanner(System.in);
        double v = input.nextDouble();
        // depositar
        ContaOrdem co = (ContaOrdem) getConta();
        co.levantar(v);
        // criar movimento
        Levantamento d = new Levantamento();
        d.setValor(v);
        d.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        
        // juntar o movimento ao extracto
        co.getListaMovimentos().add(d);
    }
    
    public void efetuarTransferencia() {
        
        // pedir conta destibo
        System.out.println("Digite o número da conta destino");
        Scanner input = new Scanner(System.in);
        int destino = input.nextInt();
        
       
        // pedir valor
        System.out.println("Digite o valor para transferir: ");
        input = new Scanner(System.in);
        double v = input.nextDouble();
        // transferir
        Conta co = (Conta) getConta();
        
        Conta cDestino ; // polimorfico pode ser qq tipo de conta
        // método e informar...
        // zxc
        
        boolean podeTransferir = false; 
        
        cDestino = getBanco().procuraConta(destino);
        if ( cDestino != null ) {
            podeTransferir = true;
        }
        
        if ( podeTransferir == true ) {
        
                co.transferir(cDestino, v);
                // criar movimento
                Transferencia t = new Transferencia();
                t.setValor(v);
                t.setTimeStamp(new Timestamp(System.currentTimeMillis()));
               // t.setDadosContaDestino(cDestino.getNumero());
                t.setDadosContaDestino(" TRF OK ");
                // juntar o movimento ao extracto
                co.getListaMovimentos().add(t);
        }
    }
    
    public void consultarSaldo() {
         ContaOrdem co = (ContaOrdem) getConta();
         System.out.println("Saldo=" + co.getSaldo());
    }
    
    public void verExtracto() {
        ContaOrdem co = (ContaOrdem) getConta();
        for ( int i = 0 ; i < co.getListaMovimentos().size(); i++) {
            Movimento m = (Movimento) co.getListaMovimentos().get(i);
            System.out.println(m.informacao());
        }
    }
 
    public void menuMovimentosConta() {
        // reedfinir nas sub classes e criar o menu específico
        
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("MOVIMENTOS CONTA ORDEM");
            System.out.println("1 - Depositar");
            System.out.println("2 - Levantar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Saldo");
            System.out.println("5 - Ver extracto de conta");
            System.out.println("6 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    efetuarDeposito();
                    break;
                case 2:
                    efetuarLevantamento();
                    break;
                case 3:
                    efetuarTransferencia();
                    break;
                case 4:
                    consultarSaldo();
                    break;
                case 5:
                    verExtracto();
                    break;
                    
                    
                case 6:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
        
    }
}
