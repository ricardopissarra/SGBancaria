/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import banco.Gestor;
import clientes.ClienteVip;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class ClienteVipUI  {
    
    ClienteVip clienteVip;
    
   
    public ClienteVipUI(ClienteVip c) {
        clienteVip = c;
    }
    
    public void menu() {
        System.out.println("\n\nDados para novo cliente VIP\n");
        
        
        System.out.println("\nNome? ");
        Scanner input = new Scanner(System.in);
        clienteVip.setNome(input.nextLine());
        
        // Identificar gestor de conta
        
        Gestor g = new Gestor();
        
        System.out.println("\nNome do gestor? ");
        input = new Scanner(System.in);
        g.setNome(input.nextLine());
        
        // ideal era dar acesso ao sistema de gerir gestores em vez de criar...
        clienteVip.setGestor(g);
    }
}