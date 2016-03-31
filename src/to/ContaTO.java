package to;

public class ContaTO
{
	private int idConta;
	private double saldo;
	private String agencia;
	private String conta;
	private int idCliente;
	
	public int getIdCliente()
	{
		return idCliente;
	}
	
	public void setIdCliente(int idCliente)
	{
		this.idCliente= idCliente;
	}
	
	public int getIdConta()
	{
		return idConta;
	}
   
	public void setIdConta(int idConta)
	{
		this.idConta = idConta;
	}
   
	public double getSaldo()
	{
		return saldo;
	}
   
	public String getAgencia()
	{
		return agencia;
	}
   
	public String getConta()
	{
		return conta;
	}
   
	public void setAgencia(String agencia)
	{
		this.agencia = agencia;
	}
   
	public void setConta(String conta)
	{
		this.conta = conta;
	}
   
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
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
		ContaTO other = (ContaTO) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (idConta != other.idConta)
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (saldo != other.saldo)
			return false;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ContaTO [idConta=" + idConta + ", saldo=" + saldo + ", agencia=" + agencia + ", conta=" + conta
				+ ", idCliente=" + idCliente + "]";
	}
	
	
	
	
	
}