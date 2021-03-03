/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartoes;

import userinterfaces.CartaoCreditoUI;

/**
 *
 * @author Administrator
 */
public class CartaoCredito extends CartaoDebito {
    private double plafond; 
    
    public boolean cashAdvance(double valor) {
        return true;
    }

    public double getPlafond() {
        return plafond;
    }

    public void setPlafond(double plafond) {
        this.plafond = plafond;
    }
    
    public void menu() {
        CartaoCreditoUI ui = new CartaoCreditoUI(this);
        ui.menu();
    }
    
    public void alterarDados() {
        CartaoCreditoUI ui = new CartaoCreditoUI(this);
        ui.alterarDados();
         
    }
    
}
