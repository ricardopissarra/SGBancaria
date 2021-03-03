/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import banco.Banco;
import contas.Conta;

/**
 *
 * @author Administrator
 */
public class ContaUI {
    
    Conta conta; 
    Banco banco;
    
    public ContaUI(Conta c, Banco b) {
        conta = c;
        banco = b;
    }

    public Conta getConta() {
        return conta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    public void menuMovimentosConta() {
        // reedfinir nas sub classes e criar o menu específico
    }
}
