package model;

import dao.ClienteDAO;
import to.ClienteTO;

public class Cliente
{
	private String nomeTitular;
	private int idCliente;
	
	public Cliente(int idCliente, String n)
	{
		setIdCliente(idCliente);
		setNome(n);
	}
	
	public void setNome(String n)
	{
		nomeTitular = n;
	}
	
	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}
	
	public String getNome()
	{
		return nomeTitular;
	}
	
	public int getIdCliente()
	{
		return idCliente;
	}
		
	public void carregar()
	{
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.carregar(idCliente);
		setNome(to.getNome());
	}

	@Override
	public String toString()
	{
		return "Cliente [id=" + idCliente + ", nome=" + nomeTitular + "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		if (nomeTitular == null) {
			if (other.nomeTitular != null)
				return false;
		} else if (!nomeTitular.equals(other.nomeTitular))
			return false;
		return true;
	}
}
