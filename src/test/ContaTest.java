package test;

import model.Conta;

import static org.junit.Assert.*;
import org.junit.Test;

public class ContaTest
{	
	@Test
	public void testCarregar()
	{
		//para funcionar a conta 1 e o cliente 1 devem ter sido carregados no banco por fora
		//INSERT INTO Conta(agencia, numeroConta, saldo, id_Cliente) VALUES('1111', '11111111', '10.00', '1');
		//INSERT INTO Cliente(nome) VALUES('Antônio da Silva');
		Conta fixture = new Conta(10.0, "1111", "11111111", 1);
		fixture.setIdConta(1);
		
		Conta novo = new Conta();
		novo.setIdConta(fixture.getIdConta());
		novo.carregar();
		assertEquals("testa acesso", novo, fixture);
	}
}
