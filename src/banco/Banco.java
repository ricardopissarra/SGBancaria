/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import clientes.ClienteNormal;
import contas.Conta;
import java.util.ArrayList; 

import userinterfaces.BancoUI;
/**
 *
 * @author Administrator
 */
public class Banco {
    
    ArrayList listaClientes;
    ArrayList listaContas;

    ClienteNormal clienteAtivo; // polimorfismo, serve para Vips..


    public ArrayList getListaContas() {
        return listaContas;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }
    
    public Banco() {
        listaClientes = new ArrayList();
        listaContas = new ArrayList();
        clienteAtivo = null;
    }

    public ClienteNormal procuraCliente(int n) {
        ClienteNormal cliente = null;
        
        for ( int i = 0; i < listaClientes.size() ; i++ ) {
              ClienteNormal c = (ClienteNormal) listaClientes.get(i);
              if ( c.getNumero() == n ) {
                  cliente = c;
                  break;
              }
        }
        
        return cliente;
    }
    
    public Conta procuraConta(int n) { // polimorfismo
        Conta conta = null;
        ClienteNormal cliente = null;
        
        for ( int i = 0; i < listaClientes.size() ; i++ ) {
              ClienteNormal c = (ClienteNormal) listaClientes.get(i);
              
              for ( int j = 0; j < c.getListaContas().size() ; j++ ) {
                  Conta cc = (Conta) c.getListaContas().get(j);
                  
                  if ( cc.getNumero() == n) {
                      conta = cc;
                      break;
                  }
              }
              
        }
        
        return conta;
    }
    
    public ClienteNormal getClienteAtivo() {
        return clienteAtivo;
    }

    public void setClienteAtivo(ClienteNormal clienteAtivo) {
        this.clienteAtivo = clienteAtivo;
    }
    
   
    public void menu() {
        BancoUI ui = new BancoUI(this);
        ui.menu();
    }
    
    
}
