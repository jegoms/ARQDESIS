package test;

import to.MovimentoTO;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MovimentoTOTest
{
	MovimentoTO to;

	@Before
	public void setUp() throws Exception
	{
		to = new MovimentoTo();
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
	public void testGets()
	{	
		assertEquals("getId", to.getId(), 3);
		assertEquals("getIdConta", to.getIdConta(), );
		assertEquals("getData", to.getData(), );
		assertEquals("getTipo", to.getTipo(), );
		assertEquals("getAgencia", to.getAgencia(), );
		assertEquals("getConta", to.getConta(), );
		assertEquals("getValor", to.getValor(), );
		assertEquals("getSaldoAtual", to.getSaldoAtual(), );
	}
	
	@Test
	public void testEquals()
	{
		ClienteTO copia = new ClienteTO();		
		copia.setId(to.getId());
		copia.setIdConta(to.getIdConta());
		copia.setData(to.getData());
		copia.setTipo(to.getTipo());
		copia.setAgencia(to.getAgencia());
		copia.setConta(to.getConta());
		copia.setValor(to.getValor());
		copia.setSaldoAtual(to.getSaldoAtual());
		assertEquals("teste to igual a copia", to, copia);
	}
}
