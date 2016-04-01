package model;

import to.ContaTO;
import dao.ContaDAO;

import java.text.DecimalFormat;

public class Conta
{
	private double saldo;
	private String agencia;
	private String conta;
	private int idConta;
	private int idCliente;
	
	public Conta(double saldo, String agencia, String conta, int idCliente)//, int idConta)
	{
		setSaldo(saldo);
		setAgencia(agencia);
		setConta(conta);
		setIdCliente(idCliente);
		setIdConta(idConta);
	}
	
	public Conta()
	{
		// TODO Auto-generated constructor stub
	}

	public double getSaldo()
	{
		return saldo;
	}
	
	public String getSaldoS()
	{
		DecimalFormat duas = new DecimalFormat("0.00");
		return "R$ " + duas.format(getSaldo());
	}
	
	public String getConta()
	{
		return conta;
	}	
	
	public String getAgencia()
	{
		return agencia;
	}
	
	public int getIdConta()
	{
		return idConta;
	}

	public int getIdCliente()
	{
		return idCliente;
	}
	
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	public void setConta(String conta)
	{
		this.conta = conta;
	}
	
	public void setAgencia(String agencia)
	{
		this.agencia = agencia;
	}
   
	public void setIdConta(int idConta)
	{
		this.idConta = idConta;
	}
	
	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}	

	public void carregar()
	{
		ContaDAO dao = new ContaDAO();
		ContaTO to = dao.carregar(idConta);
		setSaldo(to.getSaldo());
		setAgencia(to.getAgencia());
		setConta(to.getConta());
		setIdCliente(to.getIdCliente());
	}
	
	@Override
	public String toString()
	{
		return "Conta [saldo=" + saldo + ", agencia=" + agencia + ", conta=" + conta + ", idConta=" + idConta
				+ ", idCliente=" + idCliente + "]";
	}
}