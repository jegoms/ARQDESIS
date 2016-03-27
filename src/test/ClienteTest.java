package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest
{
	Cliente cliente, copia;
	
	@Before
	public void setUp() throws Exception
	{
		cliente = new Cliente("Bela");
		copia = new Cliente("Bela");
	}
	
	@Test
	public void test00Carregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		Cliente fixture = new Cliente("nome1");
		Cliente novo = new Cliente(null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar()
	{
		cliente.criar();
		cliente.carregar();
		assertEquals("testa criacao", cliente, copia);
	}

	/*@Test
	public void test02Atualizar()
	{
		cliente.setNome("abababab");
		copia.setNome("abababab");		
		cliente.atualizar();
		assertEquals("testa atualizacao", cliente, copia);
	}

	@Test
	public void test03Excluir()
	{
		cliente.setNome(null);
		copia.setNome(null);
		cliente.excluir();
		assertEquals("testa exclusao", cliente, copia);
	}*/
}
