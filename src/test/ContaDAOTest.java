package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import to.ContaTO;
import dao.ContaDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaDAOTest
{
	ContaDAO dao;
	ContaTO to;
		
	@Before
	public void setUp() throws Exception
	{
		dao = new ContaDAO();
		to = new ContaTO();
	}
	
	@Test
	public void test00Carregar()
	{
		//para funcionar a conta 1 e o cliente 1 devem ter sido carregados no banco por fora
		//INSERT INTO Conta(agencia, numeroConta, saldo, id_Cliente) VALUES('1111', '11111111', '10.00', '1');
		//INSERT INTO Cliente(nome) VALUES('Antônio da Silva');
		ContaTO fixture = new ContaTO();
		fixture.setIdConta(1);
		fixture.setAgencia("1111");
		fixture.setConta("11111111");
		fixture.setSaldo(10);
		fixture.setIdCliente(1);
		to = dao.carregar(fixture.getIdCliente());
		to.setIdConta(1);
		assertEquals("testa acesso", to, fixture);
	}

	/*@Test
	public void test01ConsultarIdCliente()
	{
		int aux = Integer.parseInt(dao.consultarIdCliente(to));
		to.setIdCliente(aux);
		assertTrue("testa consulta id cliente", ( aux == to.getIdCliente()));
	}	
	
	@Test
	public void testconsultarIdConta()
	{
		int aux = Integer.parseInt(dao.consultarIdConta(to));
		to.setIdConta(aux);
		assertEquals("testa consulta id conta", aux, to.getIdConta());
	}
	
	@Test
	public void testConsultarSaldo()
	{
		double aux = Double.parseDouble(dao.consultarSaldo(to));
		to.setSaldo(aux);
		assertEquals("testa consulta saldo", aux, to.getSaldo(), 0.00000001);
	}*/
	
	//@Test
	//
}
