/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import cartoes.CartaoCredito;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class CartaoCreditoUI {
    CartaoCredito cartao; 
    
    public CartaoCreditoUI(CartaoCredito c) {
        cartao = c;
    }
    
    public void menu() {
        System.out.println("\n\nCartao de Credito Criado com o nr: " + cartao.getNumero());
        
        System.out.println("\nPlafond? ");
        Scanner input = new Scanner(System.in);
        cartao.setPlafond(input.nextDouble());
        
    }

    public void alterarDados() {
        System.out.println("\n\nAlterar plafond do cartão (#" + cartao.getNumero() + ")");
        
        System.out.println("\nNovo Plafond? ");
        Scanner input = new Scanner(System.in);
        cartao.setPlafond(input.nextDouble());
        
    }
    
}
