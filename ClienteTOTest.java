package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import to.ClienteTO;

public class ClienteTOTest
{
	ClienteTO to;
	@Before
	public void setUp() throws Exception
	{
		to = new ClienteTO();	
		to.setNome("Bela Lugosi");
		to.setIdCliente(3);
	}

	@Test
	public void testGets()
	{
		assertEquals("getNome", to.getNome(), "Bela Lugosi");	
		assertEquals("getId", to.getIdCliente(), 3);
	}
	
	@Test
	public void testEquals()
	{
		ClienteTO copia = new ClienteTO();		
		copia.setNome(to.getNome());
		copia.setIdCliente(to.getIdCliente());
		assertEquals("teste to igual a copia", to, copia);
	}
}
