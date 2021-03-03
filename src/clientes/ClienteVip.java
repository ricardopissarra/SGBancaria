/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import banco.Gestor;

/**
 *
 * @author Administrator
 */
public class ClienteVip extends ClienteNormal {
    Gestor gestor;

    public ClienteVip() {
        super(); 
    }
    
    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
    
    
}
