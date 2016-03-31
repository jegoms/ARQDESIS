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
		//para funcionar a conta 1 e o cliente 1 devem ter sido carregados no banco por fora
		//INSERT INTO Conta(agencia, numeroConta, saldo, id_Cliente) VALUES('1111', '11111111', '10.00', '1');
		//INSERT INTO Cliente(nome) VALUES('Ant�nio da Silva');
		Conta fixture = new Conta(10.0, "1111", "11111111", 1);
		Conta novo = new Conta(10, "1111", "11111111", 1);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

}
