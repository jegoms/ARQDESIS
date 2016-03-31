package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.ClienteDAO;
import to.ClienteTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOTest
{
	ClienteDAO dao;
	ClienteTO to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ClienteTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception
	{
		dao = new ClienteDAO();
		to = new ClienteTO();	
		to.setNome("Bela Lugosi");
		//to.setIdCliente(3);
	}
	
	@Test	
	public void test00Carregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		ClienteTO fixture = new ClienteTO();
		fixture.setNome("Ant�nio da Silva");
		fixture.setIdCliente(1);
		ClienteTO novo = dao.carregar(1);
		novo.setIdCliente(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir()
	{
		dao.incluir(to);
		//System.out.println(to.getIdCliente());
		ClienteTO novo = dao.carregar(2);
		//novo.setIdCliente(2);
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar()
	{
		dao.atualizar(to);
		ClienteTO novo = dao.carregar(to.getIdCliente());
		novo.setIdCliente(to.getIdCliente());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir()
	{
		to.setNome(null);
		dao.excluir(to);
		ClienteTO novo = dao.carregar(to.getIdCliente());
		novo.setIdCliente(to.getIdCliente());
		assertEquals("testa inclusao", novo, to);
	}
}
