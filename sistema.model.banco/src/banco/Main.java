package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner entrada =  new  Scanner(System.in);
	static ArrayList<Conta> contasClientes;
	
	public static void main (String [] args) {
		contasClientes = new ArrayList<Conta>();
		operacao();
	}
	public static void operacao() {
		
		System.out.println("\n");
		System.out.println("---------------------------------------");
		System.out.println("ESCOLHA A OPERA��O QUE DESEJA REALIZAR ");
		System.out.println("---------------------------------------");
		System.out.println("OP��O 1 - Criar conta");
		System.out.println("OP��O 2 - Depositar  ");
		System.out.println("OP��O 3 - Sacar      ");
		System.out.println("OP��O 4 - Listar     ");
		System.out.println("OP��O 5 - Sair       ");
		System.out.println("---------------------------------------");
		
		int operacao = entrada.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		
		case 2:
			depositar();
			break;
		
		case 3:
			sacar();
			break;
		
		case 4:
			listar();
			break;
	
		case 5:
			System.out.println("Obrigado pela prefer�ncia");
			System.exit(0);
		default:
			System.err.println("Op��o invalida!");
			operacao();
			break;
		}
			
		
	}
	public static void criarConta() {
		
		System.out.println("\nCPF: ");
		String cpf = entrada.next();
		
		System.out.println("\nNome: ");
		String nome = entrada.next();
		
		Cliente cliente = new Cliente(nome,cpf);
		Conta conta = new Conta(cliente);
		
		contasClientes.add(conta);
		System.out.println("Sua conta foi criada com sucesso");
				
		operacao();
		
	}
	
	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasClientes.size() > 0) {
			for(Conta c: contasClientes) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}
	public static void depositar(){
		System.out.println("Numero da conta: ");
		int numeroConta = entrada.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja depositar?");
			float quantiaDeposito = entrada.nextFloat();
			conta.depositar(quantiaDeposito);
			//System.out.println("Deposito efetuado!");
		}
		else {
			System.err.println("Conta n�o encontrada!");
		}
		operacao();
	}
		
		public static void sacar() {
			System.out.println("Numero da conta: ");
			int numeroConta = entrada.nextInt();
			
			Conta conta = encontrarConta(numeroConta);
			
			if(conta != null) {
				System.out.println("Qual valor deseja sacar?");
				float quantiaSaque = entrada.nextFloat();
				conta.sacar(quantiaSaque);
				//System.out.println("Saque efetuado!");
			}
			else {
				System.err.println("Conta n�o encontrada!");
			}
			operacao();
		}
		
		public static void listar(){
			if(contasClientes.size() > 0) {
				for(Conta conta : contasClientes) {
					System.out.println(conta);	
				}	
			}
			else {
				System.err.println("N�o h� contas cadastradas!");
			}
			operacao();
			
		}
}
