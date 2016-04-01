package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Cliente;

public class ClienteTest
{	
	@Test
	public void testCarregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//INSERT INTO Cliente(nome) VALUES('Antônio da Silva');
		Cliente fixture = new Cliente(1, "Antônio da Silva");
		Cliente novo = new Cliente(fixture.getIdCliente(), null);
		novo.carregar();
		assertEquals("testa acesso", novo, fixture);
	}
}
