/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import banco.Banco;
import userinterfaces.ContaOrdemUI;

/**
 *
 * @author Administrator
 */
public class ContaOrdem extends Conta {
    
    public void depositar(double valor) {
        setSaldo(getSaldo()+valor);
    }
    
    public boolean levantar(double valor) {
        boolean conseguiuLevantar = false;
        
        if ( getSaldo() >= valor ) {
             setSaldo(getSaldo()-valor);
             conseguiuLevantar = true;
        }
        return conseguiuLevantar;
    }
    
     public void menu(Banco b) {
        ContaOrdemUI c = new ContaOrdemUI(this, b);
        c.menuMovimentosConta();
    }
    
}
