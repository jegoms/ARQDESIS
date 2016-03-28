package test;

import static org.junit.Assert.*;
import org.junit.Test;
import factory.DBConnection;

public class DBConnectionTest
{
	@Test
	public void testGetConnection()
	{
		try
		{
			assertNotNull("testa se a conexao nao eh nula", DBConnection.getConnection());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}

	@Test
	public void testClose()
	{
		try
		{
			assertTrue("testa se a conexao eh nula", DBConnection.close(null, null, null));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}
}
