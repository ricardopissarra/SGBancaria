/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import cartoes.CartaoDebito;
import contas.Conta;
import java.util.ArrayList;
import userinterfaces.ClienteNormalUI;

/**
 *
 * @author Administrator
 */
public class ClienteNormal {
    private String nome;
    // String email;
    
    private static int gerador=0;
    private int numero; 
    
    ArrayList listaCartoes;
    ArrayList listaContas;
    
    CartaoDebito cartaoAtivo; // polimorfico... pode ser uisado para CartaoCredito 
    
    Conta contaAtiva; // classe abstrata.. polimorfismo
    
    public ArrayList getListaContas() {
        return listaContas;
    }
    
   


    public ArrayList getListaCartoes() {
        return listaCartoes;
    }
    
    public ClienteNormal() {
        ++gerador;
        numero = gerador;
        setNome("Sem nome atribuido"); 
        
        listaCartoes = new ArrayList();
        listaContas = new ArrayList();
        
        cartaoAtivo = null;
        contaAtiva = null;
    }

    public Conta getContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(Conta contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

    public CartaoDebito getCartaoAtivo() {
        return cartaoAtivo;
    }

    public void setCartaoAtivo(CartaoDebito cartaoAtivo) {
        this.cartaoAtivo = cartaoAtivo;
    }

    
     public CartaoDebito procuraCartao(int n) {
        CartaoDebito cartao = null;
        
        for ( int i = 0; i < listaCartoes.size() ; i++ ) {
              CartaoDebito c = (CartaoDebito) listaCartoes.get(i);
              if ( c.getNumero() == n ) {
                  cartao = c;
                  break;
              }
        }
        
        return cartao;
    }
    
     public Conta procuraConta(int n) {
        Conta conta = null;
        
        for ( int i = 0; i < listaContas.size() ; i++ ) {
              Conta c = (Conta) listaContas.get(i);
              if ( c.getNumero() == n ) {
                  conta = c;
                  break;
              }
        }
        
        return conta;
    }
     
     
     
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public  int getNumero() {
        return numero;
    }
    
    public void menu() {
        ClienteNormalUI ui = new ClienteNormalUI(this);
        ui.menu();
    }
    
}
