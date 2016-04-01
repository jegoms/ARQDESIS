package to;

public class ClienteTO
{
	private String nomeTitular;
	private int idCliente;
	
	public String getNome()
	{
		return nomeTitular;
	}
	
	public int getIdCliente()
	{
		return idCliente;
	}
	
	public void setNome(String nomeTitular)
	{
		this.nomeTitular = nomeTitular;
	}
	
	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
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
		ClienteTO other = (ClienteTO) obj;
		if (idCliente != other.idCliente)
			return false;
		if (nomeTitular == null) {
			if (other.nomeTitular != null)
				return false;
		} else if (!nomeTitular.equals(other.nomeTitular))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ClienteTO [nomeTitular=" + nomeTitular + ", idCliente=" + idCliente + "]";
	}
}
