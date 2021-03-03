/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */

/*
 Date date= new Date();
 
 long time = date.getTime();
     System.out.println("Time in Milliseconds: " + time);
 
 Timestamp ts = new Timestamp(time);
 System.out.println("Current Time Stamp: " + ts);
*/


public class Movimento {
    
    private Timestamp timeStamp; 
    private double valor;
    
    
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    
  

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String informacao() {
        return new String("N/A");
    }
    
}
