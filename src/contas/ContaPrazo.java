/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import banco.Banco;
import userinterfaces.ContaPoupancaUI;
import userinterfaces.ContaPrazoUI;



/**
 *
 * @author Administrator
 */
public class ContaPrazo extends ContaPoupanca {
   
   private boolean jaTransferiu; 

    public boolean isJaTransferiu() {
        return jaTransferiu;
    }

   public ContaPrazo() {
       jaTransferiu = false; // overkill...
   }
   
   public boolean transferir(Conta c, double valor) {
        boolean estado = false;

        if ( ( c instanceof ContaOrdem ) && jaTransferiu == false ) {
            estado = super.transferir(c, valor);
            jaTransferiu = true;
        }

        return estado;
    }

      public void menu(Banco b) {
        ContaPrazoUI c = new ContaPrazoUI(this, b);
        c.menuMovimentosConta();
    }
}
