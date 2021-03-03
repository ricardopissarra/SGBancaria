/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartoes;

import java.util.ArrayList;
import userinterfaces.CartaoDebitoUI;

/**
 *
 * @author Administrator
 */
public class CartaoDebito {
    
      private int numero;
      private static int gerador = 100;
      
      private ArrayList listaMovimentos;

   
    
      public CartaoDebito() {
          ++gerador;
          numero = gerador;
          listaMovimentos = new ArrayList();
      }
      
      
     public void menu() {
        CartaoDebitoUI ui = new CartaoDebitoUI(this);
        ui.menu();
    }
    
     public void alterarDados() {
        CartaoDebitoUI ui = new CartaoDebitoUI(this);
        ui.alterarDados();
         
     }
   
      public ArrayList getListaMovimentos() {
        return listaMovimentos;
    }

    public void setListaMovimentos(ArrayList listaMovimentos) {
        this.listaMovimentos = listaMovimentos;
    }

    public int getNumero() {
        return numero;
    }

}
