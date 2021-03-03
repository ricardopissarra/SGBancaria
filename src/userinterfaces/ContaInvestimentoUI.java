/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import banco.Banco;
import contas.Conta;
import contas.ContaInvestimento;
import contas.ContaOrdem;
import java.sql.Timestamp;
import java.util.Scanner;
import movimentos.Deposito;
import movimentos.Levantamento;
import movimentos.Movimento;

/**
 *
 * @author Administrator
 */
public class ContaInvestimentoUI extends ContaUI {
    
    public ContaInvestimentoUI(Conta c, Banco b) {
        super(c, b);
    }
    
     public void efetuarDeposito() {
        // pedir valor
        System.out.println("Digite o valor para depositar: ");
        Scanner input = new Scanner(System.in);
        double v = input.nextDouble();
        // depositar
        ContaInvestimento ci = (ContaInvestimento) getConta();
        ci.depositar(v);
        // criar movimento
        Deposito d = new Deposito();
        d.setValor(v);
        d.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        
        // juntar o movimento ao extracto
        ci.getListaMovimentos().add(d);
    }
    
    public void efetuarLevantamento() {
        ContaInvestimento ci = (ContaInvestimento) getConta();
          // pedir valor
        System.out.println("Custo da operação: " + ci.getCusto());          
        System.out.println("Digite o valor para levantar: ");
        Scanner input = new Scanner(System.in);
        double v = input.nextDouble();
        // depositar
        
        ci.levantar(v);
        
        
        // criar movimento
        Levantamento d = new Levantamento();
        d.setValor(v+ci.getCusto());
        d.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        
        // juntar o movimento ao extracto
        ci.getListaMovimentos().add(d);
    }
    
    public void efetuarTransferencia() {
        
    }
    
    public void consultarSaldo() {
         ContaInvestimento ci = (ContaInvestimento) getConta();
         System.out.println("Saldo=" + ci.getSaldo());
    }
    
    public void verExtracto() {
        ContaInvestimento ci = (ContaInvestimento) getConta();
        for ( int i = 0 ; i < ci.getListaMovimentos().size(); i++) {
            Movimento m = (Movimento) ci.getListaMovimentos().get(i);
            System.out.println(m.informacao());
        }
    }
 
    public void menuMovimentosConta() {
        // reedfinir nas sub classes e criar o menu específico
        
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("MOVIMENTOS CONTA INVESTIMENTO");
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
