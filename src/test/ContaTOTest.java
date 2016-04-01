package test;

import to.ContaTO;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContaTOTest
{
	ContaTO to;
	
	@Before
	public void setUp() throws Exception
	{
		to = new ContaTO();
		to.setAgencia("1111");
		to.setConta("11111111");
		to.setIdCliente(1);
		to.setIdConta(1);
		to.setSaldo(10);
	}
	
	@Test
	public void testGets()
	{
		assertEquals("getIdConta", to.getIdConta(), 1);
		assertEquals("getIdCliente", to.getIdCliente(), 1);
		assertEquals("getConta", to.getConta(), "11111111");
		assertEquals("getAgencia", to.getAgencia(), "1111");
		assertEquals("getSaldo", to.getSaldo(), 10, 0.00000001);
	}
	
	@Test
	public void testEquals()
	{
		ContaTO copia = new ContaTO();
		copia.setIdConta(to.getIdConta());
		copia.setAgencia(to.getAgencia());
		copia.setConta(to.getConta());
		copia.setIdCliente(to.getIdCliente());
		copia.setSaldo(to.getSaldo());
		assertEquals("teste to igual a copia", to, copia);
	}
}
