/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

/**
 *
 * @author Administrator
 */
public class Transferencia extends Movimento {
    
     public String dadosContaDestino;
    
     public String informacao() {
        return new String("Movimento transferencia - " + getValor() + " " + getTimeStamp() 
                + " Conta destino: " + dadosContaDestino);
    }

    public void setDadosContaDestino(String dadosContaDestino) {
        this.dadosContaDestino = dadosContaDestino;
    }

}
