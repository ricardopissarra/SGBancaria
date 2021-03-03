/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import banco.Banco;
import userinterfaces.ContaInvestimentoUI;
import userinterfaces.ContaOrdemUI;

/**
 *
 * @author Administrator
 */
public class ContaInvestimento extends ContaOrdem {
    private double custo; 

    public ContaInvestimento ()  {
        setCusto(50);
    }
    /**
     * @return the custo
     */
    public double getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }
    
     public boolean levantar(double valor) {
        boolean conseguiuLevantar = false;
        
        if ( getSaldo() >= valor ) {
             setSaldo(getSaldo()-valor);
             setSaldo(getSaldo()-getCusto());
             conseguiuLevantar = true;
        }
        return conseguiuLevantar;
    }
     
       public void menu(Banco b) {
        ContaInvestimentoUI c = new ContaInvestimentoUI(this, b);
        c.menuMovimentosConta();
    }
}
