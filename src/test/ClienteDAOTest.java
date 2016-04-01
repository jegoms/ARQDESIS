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
	
	@Before
	public void setUp() throws Exception
	{
		dao = new ClienteDAO();
		to = new ClienteTO();
	}
	
	@Test	
	public void test00Carregar()
	{
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//INSERT INTO Cliente(nome) VALUES('Antônio da Silva');
		ClienteTO fixture = new ClienteTO();
		fixture.setNome("Antônio da Silva");
		fixture.setIdCliente(1);
		ClienteTO novo = dao.carregar(fixture.getIdCliente());		
		assertEquals("testa acesso", novo, fixture);
	}	
}
