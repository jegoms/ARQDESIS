package to;

public class ContaTO
{
	private int idConta;
	private double saldo;
	private String agencia;
	private String conta;
	
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
}
