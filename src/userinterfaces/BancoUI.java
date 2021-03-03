/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import java.util.Scanner;

import banco.Banco;
import clientes.*;
import cartoes.*;
import contas.Conta;
import contas.ContaInvestimento;
import contas.ContaOrdem;
import contas.ContaPoupanca;
import contas.ContaPrazo;

/**
 *
 * @author Administrator
 */
public class BancoUI {

    Banco meuBanco;

    public BancoUI(Banco b) {
        meuBanco = b;
    }

    public void menu() {

        boolean termina = false;
        do {
            System.out.println("\n\n");
            System.out.println("Menu do Banco");
            System.out.println("1 - Criar um cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Selecionar cliente  (Opções do cliente)");
            System.out.println("4 - Selecionar um cartão de cliente ativo");
            System.out.println("5 - Avançar um período");
            System.out.println("6 - Sair");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarUmCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    if (meuBanco.getClienteAtivo() == null) {
                        if (pedirCliente()==true) {
                            opcoesDoCliente();
                        }
                    } else {
                        opcoesDoCliente();
                    }
                    break;
                    
                 case 4:
                    if (meuBanco.getClienteAtivo() != null) {
                            selecionarUmCartao();
                    } else {
                        System.out.println("Cliente ativo não selecionado");
                    }
                    break;    
                case 6:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }

    private void criarUmCliente() {
        boolean termina = false;
        do {
            System.out.println("\n\n");
            System.out.println("Criar um cliente");
            System.out.println("1 - Cliente normal");
            System.out.println("2 - Cliente VIP");
            System.out.println("3 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarClienteNormal();
                    break;
                case 2:
                    criarClienteVip();
                    break;
                case 3:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }

    private void criarClienteNormal() {
        ClienteNormal c = new ClienteNormal();
        meuBanco.getListaClientes().add(c);
        c.menu();
    }

    private void criarClienteVip() {
        ClienteVip c = new ClienteVip();
        meuBanco.getListaClientes().add(c);
        c.menu();
    }

    private void listarClientes() {
        System.out.println("\n\nListagem de clientes");
        for (int i = 0; i < meuBanco.getListaClientes().size(); i++) {
            ClienteNormal c = (ClienteNormal) meuBanco.getListaClientes().get(i);
            System.out.println("");
            if (meuBanco.getClienteAtivo() != null) {
                if (c.getNumero() == meuBanco.getClienteAtivo().getNumero()) {
                    System.out.print("--> ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.print("#" + c.getNumero() + " " + c.getNome()); // polimorfismo, clientes VIP são listados

        }
    }

    public boolean pedirCliente() {
        boolean estado = false;

        System.out.println("\n\nIndique qual o numero de cliente");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        ClienteNormal clienteAtivo = meuBanco.procuraCliente(n);

        if (clienteAtivo != null) {
            meuBanco.setClienteAtivo(clienteAtivo);
            estado = true;
        }

        return estado;

    }

    
    
     public boolean pedirCartao() {
        boolean estado = false;

        System.out.println("\n\nIndique qual o numero de cartão?");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        CartaoDebito cartaoEscolhido = meuBanco.getClienteAtivo().procuraCartao(n);

        if (cartaoEscolhido != null) {
            meuBanco.getClienteAtivo().setCartaoAtivo(cartaoEscolhido);
            estado = true;
        }

        return estado;

    }
    
    public void editarDadosCliente() {
        if (meuBanco.getClienteAtivo() != null) {
            meuBanco.getClienteAtivo().menu();
        }
    }

    public void desativarCliente() {
        meuBanco.setClienteAtivo(null);
    }

    
      public void criarCartaoDebito() {
        if (meuBanco.getClienteAtivo() != null) {
            CartaoDebito c = new CartaoDebito();
            meuBanco.getClienteAtivo().getListaCartoes().add(c);
            c.menu();
        } else {

            System.out.println("Sem cliente ativo...");
        }
    }

    public boolean temContaOrdem() {
        boolean tem = false;
        
        for ( int i = 0; i < meuBanco.getClienteAtivo().getListaContas().size();i++) {
            Conta c = (Conta)  meuBanco.getClienteAtivo().getListaContas().get(i);
            if ( c instanceof ContaOrdem ) {
                tem = true;
            }
        }
        
        return tem;
    }
    
    public void criarContaOrdem() {
        if (meuBanco.getClienteAtivo() != null) {
            // validar se este cliente já tem uma conta ordem associada
            // só pode ter uma..
            if ( temContaOrdem() == false ) {
                    ContaOrdem c = new ContaOrdem();
                    meuBanco.getClienteAtivo().getListaContas().add(c);
                    System.out.println("Conta ordem criada com o número: " + c.getNumero());
                    // por omissão, nova conta fica ativa
                    meuBanco.getClienteAtivo().setContaAtiva(c);
            } else {
                System.out.println("Já tem uma conta ordem associada...");
            }
        } else {

            System.out.println("Tem que selecionar o cliente ativo...");
        }
    }

    
    public void criarContaInvestimento() {
        if (meuBanco.getClienteAtivo() != null) {
            
            ContaInvestimento c = new ContaInvestimento();
            meuBanco.getClienteAtivo().getListaContas().add(c);
            System.out.println("Conta investimento criada com o número: " + c.getNumero());
            // por omissão, nova conta fica ativa
            meuBanco.getClienteAtivo().setContaAtiva(c);

        } else {

            System.out.println("Tem que selecionar o cliente ativo...");
        }
    }
    
     public void criarContaPoupanca() {
        if (meuBanco.getClienteAtivo() != null) {
            
            ContaPoupanca c = new ContaPoupanca();
            meuBanco.getClienteAtivo().getListaContas().add(c);
            System.out.println("Conta poupança criada com o número: " + c.getNumero());
            // por omissão, nova conta fica ativa
            meuBanco.getClienteAtivo().setContaAtiva(c);

        } else {

            System.out.println("Tem que selecionar o cliente ativo...");
        }
    }
    
    
      public void criarContaPrazo() {
        if (meuBanco.getClienteAtivo() != null) {
            
            ContaPrazo c = new ContaPrazo();
            meuBanco.getClienteAtivo().getListaContas().add(c);
            System.out.println("Conta prazo criada com o número: " + c.getNumero());
            // por omissão, nova conta fica ativa
            meuBanco.getClienteAtivo().setContaAtiva(c);

        } else {

            System.out.println("Tem que selecionar o cliente ativo...");
        }
    }
    
    
    
    public void criarCartaoCredito() {
        if (meuBanco.getClienteAtivo() != null) {
            CartaoCredito c = new CartaoCredito();
            meuBanco.getClienteAtivo().getListaCartoes().add(c);
            c.menu();
        } else {

            System.out.println("Sem cliente ativo...");
        }
    }

    public void criarCartao() {

        // escolher tipo de cartão 
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("Criar cartao");
            System.out.println("1 - Cartao de Debito");
            System.out.println("2 - Cartao de Credito");
            System.out.println("3 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarCartaoDebito();
                    break;
                case 2:
                    criarCartaoCredito();
                    break;

                case 3:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);

    }

     public void criarConta() {

        // escolher tipo de conta 
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("Criar conta");
            System.out.println("1 - Conta Ordem");
            System.out.println("2 - Conta Investimento");
            System.out.println("3 - Conta Poupança");
            System.out.println("4 - Conta Prazo");
            System.out.println("5 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarContaOrdem();
                    break;
                case 2:
                    criarContaInvestimento();
                    break;
                case 3:
                    criarContaPoupanca();
                    break;
                case 4:
                    criarContaPrazo();
                    break;                    
                    
                case 5:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);

    }
    
    
    public void listarCartoes() {
        if (meuBanco.getClienteAtivo() != null) {
            for (int i = 0; i < meuBanco.getClienteAtivo().getListaCartoes().size(); i++) {
                CartaoDebito c = (CartaoDebito) meuBanco.getClienteAtivo().getListaCartoes().get(i);
                System.out.println("Cartao #" + c.getNumero());
                if (c instanceof CartaoCredito) {
                    CartaoCredito cc = (CartaoCredito) c;
                    System.out.print(" Plafond: " + cc.getPlafond());
                }
            }
        }
    }

    public void alterarDadosCartao() {
        if ( pedirCartao() == true ) {
            meuBanco.getClienteAtivo().getCartaoAtivo().alterarDados();
        } else {
            System.out.println("\n\nNumero de cartão não associado a cliente ativo");
        }
    }
    
    public void listarContas() {
        System.out.println("\n\nListar conta do cliente");
        if ( meuBanco.getClienteAtivo() != null ) {
                if ( meuBanco.getClienteAtivo().getListaContas().size() > 0  ) {
                    for (int i = 0; i < meuBanco.getClienteAtivo().getListaContas().size(); i++) {
                        Conta c = (Conta) meuBanco.getClienteAtivo().getListaContas().get(i);
                        System.out.println("#" + c.getNumero() + " Saldo= " + c.getSaldo()); 
                    }
                } else {
                    System.out.println("Ainda não há contas associadas a este cliente");
                }
        }
    }

    public void movimentarContaAtiva() {
        if ( meuBanco.getClienteAtivo() != null ) {
            
            if ( meuBanco.getClienteAtivo().getContaAtiva() != null) {
                
                // ok, cliente e conta ativa 
                meuBanco.getClienteAtivo().getContaAtiva().menu(meuBanco);
                
            } else {
                System.out.println("Não escolheu uma conta ativa");
            }
            
        } else {
            System.out.println("Não tem cliente selecionado");
        }
    }
    
    
    public void opcoesDoCliente() {
        boolean termina = false;

        do {
            
            ClienteNormal cAtiv = meuBanco.getClienteAtivo();
            String mensagem = "Opções do cliente ";
            if ( cAtiv != null ) {
                mensagem+=" ativo ";
                mensagem+=cAtiv.getNome();
            }
            
            System.out.println("\n\n");
            System.out.println(mensagem);
            System.out.println("1 - Desativar cliente ativo");
            System.out.println("2 - Editar os dados do cliente");
            System.out.println("3 - Criar cartao");
            System.out.println("4 - Listar cartoes");
            System.out.println("5 - Alterar dados do cartao");
            System.out.println("6 - Desativar cartao");
            System.out.println("7 - Criar conta");
            System.out.println("8 - Listar contas");
            System.out.println("9 - Escolher conta ativa do cliente ativo");
            System.out.println("10 - Movimentar conta ativa");
            System.out.println("11 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    desativarCliente();
                    break;
                case 2:
                    editarDadosCliente();
                    break;
                case 3:
                    criarCartao();
                    break;
                case 4:
                    listarCartoes();
                    break;
                case 5:
                    alterarDadosCartao();
                    break;
                    
                case 6:
                    desativarCartaoAtivo();
                    break; 
                    
                case 7:
                    criarConta();
                    break;  
                 
                case 8:
                    listarContas();
                    break;      
                
                case 9: 
                    escolherContaAtivaDoClienteAtivo();
                    break;
                case 10:
                    movimentarContaAtiva();
                    break;
                    
                case 11:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }
    
    
    // para cliente ativo....
     public void selecionarUmCartao() {
        
        CartaoDebito  cartao;
        
        System.out.println("Digite o número de cartão que pretende: ");
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();
         
        cartao = meuBanco.getClienteAtivo().procuraCartao(numero);
        
        if ( cartao != null ) {
            meuBanco.getClienteAtivo().setCartaoAtivo(cartao);
        } else {
            System.out.println("Numero de cartao sem associação ao cliente ativo");
        }
        
     }
    
     public void desativarCartaoAtivo() {
         
            if (  meuBanco.getClienteAtivo() != null ) {
                meuBanco.getClienteAtivo().setCartaoAtivo(null);
                System.out.println("O cartão ativo foi desativado.");
            } else {
                System.out.println("Não existe um cliente ativo...");
            }
        
        
     }
     
     public void escolherContaAtivaDoClienteAtivo() {
        
        if ( meuBanco.getClienteAtivo() != null ) {
         
                Conta  conta;

                System.out.println("Digite o número da conta pretendida: ");
                Scanner input = new Scanner(System.in);
                int numero = input.nextInt();

                conta = meuBanco.getClienteAtivo().procuraConta(numero);

                if ( conta != null ) {
                    meuBanco.getClienteAtivo().setContaAtiva(conta);
                } else {
                    System.out.println("Numero de conta não encontrado para este cliente");
                }

        
        }
     }
     
     public void movimentarConta() {
         if ( meuBanco.getClienteAtivo() != null ) {
          
             if ( meuBanco.getClienteAtivo().getContaAtiva() != null ) {
                 
                 Conta c = meuBanco.getClienteAtivo().getContaAtiva();
                 c.menu(meuBanco);
             }
         }
     
}}
