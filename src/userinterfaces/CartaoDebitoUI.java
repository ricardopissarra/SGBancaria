/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import cartoes.CartaoDebito;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class CartaoDebitoUI {
    CartaoDebito cartao; 
    
    public CartaoDebitoUI(CartaoDebito c) {
        cartao = c;
    }
    
    public void menu() {
        System.out.println("\n\nCartao de Debito Criado com o nr: " + cartao.getNumero());
    }
    
    public void alterarDados() {
        System.out.println("\n\nNão pode alterar dados deste cartão (#" + cartao.getNumero() + ")");
    }
}
