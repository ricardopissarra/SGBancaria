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
import contas.ContaPrazo;
import java.util.Scanner;
import movimentos.Movimento;

/**
 *
 * @author Administrator
 */
public class ContaPrazoUI extends ContaUI{
    
    public ContaPrazoUI(Conta c, Banco b) {
        super(c, b);
    }
    
     
   
    public void efetuarTransferencia() {
        ContaPrazo cp = (ContaPrazo) getConta();

        if ( cp.isJaTransferiu() == false ) {
            // faz transferencia
        } else {
            System.out.println("Já fez a única transferência possível");
        }
    }
    
    public void consultarSaldo() {
         ContaPrazo cp = (ContaPrazo) getConta();
         System.out.println("Saldo=" + cp.getSaldo());
    }
    
    public void verExtracto() {
        ContaPrazo cp = (ContaPrazo) getConta();
        for ( int i = 0 ; i < cp.getListaMovimentos().size(); i++) {
            Movimento m = (Movimento) cp.getListaMovimentos().get(i);
            System.out.println(m.informacao());
        }
    }
 
    public void menuMovimentosConta() {
        // reedfinir nas sub classes e criar o menu específico
        
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("MOVIMENTOS CONTA PRAZO");
            System.out.println("1 - Transferir");
            System.out.println("2 - Saldo");
            System.out.println("3 - Ver extracto de conta");
            System.out.println("4 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                
                case 1:
                    efetuarTransferencia();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    verExtracto();
                    break;
                    
                    
                case 4:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
        
    }
    
    
}
