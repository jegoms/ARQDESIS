package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.MovimentoDAO;
import model.Movimento;
import to.MovimentoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentoDAOTest
{
	MovimentoDAO dao;
	MovimentoTO to;
	
	@Before
	public void setUp() throws Exception
	{
		dao = new MovimentoDAO();
		to = new MovimentoTO();
		to.setId(2);
		to.setIdConta(1);
		to.setData("31-03-2016");
		to.setTipo("Saque");
		to.setAgencia("1111");
		to.setConta("11111111");
		to.setValor(5);
		to.setSaldoAtual(5);
	}
	
	@Test
	public void test00Carregar()
	{
		//para funcionar o movimento 1 deve ter sido carregado no banco por fora
		//INSERT INTO Movimento(dataOperacao, tipoOperacao, agencia, conta, valor, saldoAtual, id_Conta) VALUES ('31-03-2016', 'Saque', '1111', '11111111', '5', '10', '1')"
		MovimentoTO fixture = new MovimentoTO();		
		fixture.setId(1);
		fixture.setIdConta(1);
		fixture.setData("31-03-2016");
		fixture.setTipo("Saque");
		fixture.setAgencia("1111");
		fixture.setConta("11111111");
		fixture.setValor(5);
		fixture.setSaldoAtual(10);
		MovimentoTO novo = dao.carregar(fixture.getId());
		assertEquals("testa acesso", novo, fixture);
	}

	@Test
	public void test01Inserir()
	{
		dao.incluir(to);
		MovimentoTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02ConsultarTodos() 
	{		
		List<Movimento> todos = new ArrayList<Movimento>();		
		todos = dao.consultarTodos(1); //consulta todos os movimentos da conta 1
		
		MovimentoTO mt = new MovimentoTO();

		List<Movimento> todos2 = new ArrayList<Movimento>();
		
		for(int i=0; i<todos.size(); i++)
		{
			mt = dao.carregar(i); //recebe cada um
			Movimento m = new Movimento(mt.getIdConta()); //carrega em Movimento p poder comparar tipos iguais
			m.setAgencia(mt.getAgencia());
			m.setConta(mt.getConta());
			m.setData(mt.getData());			
			m.setId(mt.getId());
			m.setSaldoAtual(m.getSaldoAtual());
			m.setTipo(mt.getTipo());
			m.setValor(mt.getValor());
			
			todos2.set(i, m);
		}
		
		for(int i=0; i<todos.size(); i++)			
			assertEquals("testa igualdade de Arrays", todos.get(i), todos2.get(i));
	}
}
