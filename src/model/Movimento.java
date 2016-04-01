package model;

import java.util.*;

import dao.MovimentoDAO;
import to.MovimentoTO;

public class Movimento
{
	protected String data;
	protected String tipo;
	protected String agencia;
	protected String conta;
	protected double valor;
	protected double saldoAtual;
	protected int id;
	protected int idConta;
   
	public Movimento(String data, String tipo, String agencia, String conta, double valor, double saldoAtual, int idConta)
	{
		setData(data);
		setTipo(tipo);
		setAgencia(agencia);
		setConta(conta);
		setValor(valor);
		setSaldoAtual(saldoAtual);
		setId(0);
		setIdConta(idConta);
	}
   
	public Movimento(int idConta)
	{
		this.idConta = idConta;
		setData("");
		setTipo("");
		setAgencia("");
		setConta("");
		setValor(0);
		setSaldoAtual(0);
		setId(0);
	}
   
	public void setIdConta(int idConta)
	{
		this.idConta = idConta;
	}
   
	public void setData(String data)
	{
		this.data = data;
	}
   
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
   
	public void setId(int id)
	{
		this.id = id;
	}
   
	public void setAgencia(String agencia)
	{
		this.agencia = agencia;
	}
   
	public void setConta(String conta)
	{
		this.conta = conta;
	}
   
	public void setValor(double valor)
	{
		this.valor = valor;
	}
   
	public void setSaldoAtual(double saldoAtual)
	{
		this.saldoAtual = saldoAtual;
	}
   
	public int getId()
	{
		return id;
	}
   
	public String getData()
	{
		return data;
	}
   
	public String getTipo()
	{
		return tipo;
	}
   
	public String getAgencia()
	{
		return agencia;
	}
   
	public String getConta()
	{
		return conta;
	}
   
	public double getValor()
	{
		return valor;
	}
   
	public double getSaldoAtual()
	{
		return saldoAtual;
	}
   
	public int getIdConta()
	{
		return idConta;
	}
   
	public void criar()
	{
		MovimentoDAO dao = new MovimentoDAO();
		MovimentoTO to = new MovimentoTO();
		to.setId(id);
		to.setData(data);
		to.setTipo(tipo);
		to.setAgencia(agencia);
		to.setConta(conta);
		to.setValor(valor);
		to.setSaldoAtual(saldoAtual);
		to.setIdConta(idConta);
		dao.incluir(to);
	}

	public void carregar()
	{
		MovimentoDAO dao = new MovimentoDAO();
		MovimentoTO to = dao.carregar(id);
		to.setData(data);
		to.setTipo(tipo);
		to.setAgencia(agencia);
		to.setConta(conta);
		to.setValor(valor);
		to.setSaldoAtual(saldoAtual);
		to.setIdConta(idConta);
	}
   
	public List<Movimento> consultarTodos()
	{
		MovimentoDAO m = new MovimentoDAO();
		return m.consultarTodos(getIdConta());
	}
   
	public String dados()
	{
		String saida = ""+ id + data + tipo + agencia + conta + valor + saldoAtual;
		return saida;
	}

	@Override
	public String toString()
	{
		return "Movimento [data=" + data + ", tipo=" + tipo + ", agencia=" + agencia + ", conta=" + conta + ", valor="
				+ valor + ", saldoAtual=" + saldoAtual + ", id=" + id + ", idConta=" + idConta + "]";
	}
}