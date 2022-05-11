package banco;

public class Conta {

	private static int contadorConta =1; //Gerar um id para cada nova conta
	
	private int numeroConta;
	private Cliente cliente;
	private float saldo = 0f;
	private boolean status;
	
	
	// M�todos construtoes
	
	public Conta() {
	
	}

	public Conta(Cliente cliente) {
		this.numeroConta = contadorConta;
		this.cliente = cliente;
		this.status = true;
		contadorConta +=1;
	}
	
	//M�todos de acesso

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroConta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numeroConta != other.numeroConta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		
			return "\n N�mero da conta:" + this.getNumeroConta() +
				   "\n Nome:" + this.cliente.getNome() +
				   "\n CPF:" + this.cliente.getCpf() +
				   "\n Saldo:" + this.getSaldo()+
				   "\n Status:" + this.isStatus() +
				   "\n";
					  	
	}
	//M�todo depositar
	
	public void depositar(float quantia) {
		if(this.isStatus() == true && quantia > 0) {
			setSaldo(getSaldo() + quantia);
			System.out.println("Deposito efetuado!");
		}
		else {
			System.err.println("N�o foi poss�vel efetuar o deposito! ");
		}	
	}
	//M�todo sacar
	
	public void sacar(float quantia){
		if(this.isStatus() == true && quantia > 0 && this.getSaldo() >= quantia){
			setSaldo(getSaldo() - quantia);
			System.out.println("Saque efetuado!");	
		}
		else {
			System.err.println("N�o foi poss�vel efetuar o saque! ");
		}
		
	}
	//M�todo desativar conta
	
	public void desativarConta() {
		if(this.getSaldo() > 0) {
			System.err.println("Conta  cont�m saldo, n�o pode ser desativada");
		}
		else {
			this.setStatus(false);
			System.out.println("Conta Desativada");
		}	
	}
	//M�todo consultar saldo
	
	public void consultarSaldo() {
		System.out.println("Saldo: " + this.getSaldo());
	} 
		

}
