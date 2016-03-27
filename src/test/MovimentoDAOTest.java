package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.MovimentoDAO;
import to.MovimentoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentoDAOTest
{
	MovimentoDAO dao;
	MovimentoTO to;
	
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
		dao = new MovimentoDAO();
		to = new MovimentoTO();
		to.setId();
		to.setIdConta();
		to.setData("");
		to.setTipo("");
		to.setAgencia();
		to.setConta();
		to.setValor();
		to.setSaldoAtual();
	}
	
	@Test
	public void test00Carregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		MovimentoTO fixture = new MovimentoTO();		
		fixture.setId();
		fixture.setIdConta();
		fixture.setData("");
		fixture.setTipo("");
		fixture.setAgencia();
		fixture.setConta();
		fixture.setValor();
		fixture.setSaldoAtual();
		MovimentoTO novo = dao.carregar();
		novo.setId(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir()
	{
		dao.incluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar()
	{
		to.setFone("999999");
		dao.atualizar(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir()
	{
		to.setNome(null);
		to.setFone(null);
		dao.excluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
}
