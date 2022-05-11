package banco;

public class Cliente {
	
	private static int contadorCliente =1; ///Gerar um id para cada novo cliente
	
	private String cpf;
	private String nome;
	
	//Construtores
	
	public Cliente() {
		
	}

	public Cliente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		contadorCliente += 1;
	}

	//Métodos de acesso
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	public String toString() {
		return "\n Nome: " + this.getNome()+ 
				"\n CPF: " + this.getCpf()+
				"\n";
	
	}
	
	

}
