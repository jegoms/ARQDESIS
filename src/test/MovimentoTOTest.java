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
		to = new MovimentoTO();
		to.setId(1);
		to.setIdConta(1);
		to.setData("31-03-2016");
		to.setTipo("Saque");
		to.setAgencia("1111");
		to.setConta("11111111");
		to.setValor(10);
		to.setSaldoAtual(10);			
	}

	@Test
	public void testGets()
	{	
		assertEquals("getId", to.getId(), 1);
		assertEquals("getIdConta", to.getIdConta(), 1);
		assertEquals("getData", to.getData(), "31-03-2016");
		assertEquals("getTipo", to.getTipo(), "Saque");
		assertEquals("getAgencia", to.getAgencia(), "1111");
		assertEquals("getConta", to.getConta(), "11111111");
		assertEquals("getValor", to.getValor(), 10, 0.0000001);
		assertEquals("getSaldoAtual", to.getSaldoAtual(), 10, 0.0000001);
	}
	
	@Test
	public void testEquals()
	{
		MovimentoTO copia = new MovimentoTO();		
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
