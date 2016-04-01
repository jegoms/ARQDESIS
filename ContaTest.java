package test;

import model.Conta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest
{
	Conta conta, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception
	{
		conta = new Conta(10.0, "2222", "2222", 1);
		copia = new Conta(10.0, "2222", "2222", 1);
	}
	
	@Test
	public void test00Carregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		Conta fixture = new Conta(10.0, "1111", "11111111", 1);
		Conta novo = new Conta(10, "1111", "11111111", 1);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar()
	{
		conta.criar();
		conta.carregar();
		assertEquals("testa criacao", conta, copia);
	}

	@Test
	public void test02Atualizar()
	{
		conta.setSaldo(50.00);
		copia.setSaldo(50.00);		
		conta.atualizar();
		assertEquals("testa atualizacao", conta, copia);
	}

	@Test
	public void test03Excluir()
	{
		conta.setSaldo(0);
		conta.setAgencia(null);
		conta.setConta(null);
		conta.setIdConta(0);
		conta.setIdCliente(0);
		copia.setSaldo(0);
		copia.setAgencia(null);
		copia.setConta(null);
		copia.setIdConta(0);
		copia.setIdCliente(0);
		conta.excluir();
		assertEquals("testa exclusao", conta, copia);
	}
}
