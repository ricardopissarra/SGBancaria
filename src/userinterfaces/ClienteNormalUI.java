/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import clientes.ClienteNormal; 
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ClienteNormalUI {
    
    ClienteNormal clienteNormal;
    
    public ClienteNormalUI(ClienteNormal c) {
        clienteNormal = c;
    }
    
    public void menu() {
        
        System.out.println("\n\nDados para cliente normal\n");
        
        
        System.out.println("\nNome? ");
        Scanner input = new Scanner(System.in);
        clienteNormal.setNome(input.nextLine());
        // mais dados...
        
        
    }
}
