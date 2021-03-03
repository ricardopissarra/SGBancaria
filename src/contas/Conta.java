/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import banco.Banco;
import java.util.ArrayList;
import userinterfaces.ContaUI;

/**
 *
 * @author Administrator
 */
public abstract class Conta {
    private static int gerador = 0;
    private  int numero;
    private double saldo;
    
    private ArrayList listaMovimentos;
    
    public Conta() {
        ++gerador;
        numero = gerador;
        
        listaMovimentos = new ArrayList();
        
    }
    
    public boolean transferir(Conta c, double valor) {
        c.setSaldo(getSaldo()+valor);
        setSaldo(getSaldo()-valor);
        return true;
    }

    public ArrayList getListaMovimentos() {
        return listaMovimentos;
    }

//    public void setListaMovimentos(ArrayList listaMovimentos) {
//        this.listaMovimentos = listaMovimentos;
//    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
     public void menu(Banco b) {
        ContaUI c = new ContaUI(this, b);
        c.menuMovimentosConta();
    }
}
