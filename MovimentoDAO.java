package dao;

import factory.DBConnection;

import java.util.*;
import java.sql.*;
import javax.swing.*;

public class MovimentoDAO
{
	protected Statement statement = null;
	protected Connection conn = DBConnection.getConnection();
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;   
   
	public void incluir(MovimentoTO to)
	{
		String sqlInsert = "INSERT INTO Movimento(dataOperacao, tipoOperacao, agencia, conta, valor, saldoAtual, id_Conta) VALUES (?, ?, ?, ?, ?, ?, ?)";
      
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1, to.getData());
			stm.setString(2, to.getTipo());
			stm.setString(3, to.getAgencia());
			stm.setString(4, to.getConta());
			stm.setDouble(5, to.getValor());
			stm.setDouble(6, to.getSaldoAtual());
			stm.setInt(7, to.getIdConta());
			stm.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
   
	public void atualizar(MovimentoTO to)
	{
		String sqlUpdate = "UPDATE Movimento SET dataOperacao=?, tipoOperacao=?, agencia=?, conta=?, valor=?, saldoAtual=?, id_Conta=? WHERE idMovimento=?";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, to.getData());
			stm.setString(2, to.getTipo());
			stm.setString(3, to.getAgencia());
			stm.setString(4, to.getConta());
			stm.setDouble(5, to.getValor());
			stm.setDouble(6, to.getSaldoAtual());
			stm.setInt(7, to.getIdConta());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void excluir(MovimentoTO to)
	{
		String sqlDelete = "DELETE FROM Movimento WHERE idMovimento = ?";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, to.getId());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public MovimentoTO carregar(int id)
	{
		MovimentoTO to = new MovimentoTO();
		String sqlSelect = "SELECT dataOperacao, tipoOperacao, agencia, conta, valor, saldoAtual, id_Conta FROM Movimento WHERE Movimento.idMovimento = ?";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();)
			{
				if (rs.next())
				{           
					to.setData(rs.getString("data"));
					to.setTipo(rs.getString("tipo"));
					to.setAgencia(rs.getString("agencia"));
					to.setConta(rs.getString("conta"));
					to.setValor(rs.getDouble("valor"));
					to.setSaldoAtual(rs.getDouble("saldoAtual"));
					to.setIdConta(rs.getInt("id_Conta"));
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch (SQLException e1)
		{
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
      
   /*//qro saber a qtd de saque, saldo, extrato, transferencia, débito
   public int consultarQtdOperacao(String operacao)
   {
      int dados=0;
      try
      {
         String query = "SELECT COUNT(*) AS C FROM ArquivoLog WHERE tipoOperacao='"+operacao+"';";
         pstm = conn.prepareStatement(query);
         rs = pstm.executeQuery();
      
         while( rs.next() )  
         {
            dados = rs.getInt("C");
         }
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
      }
      return dados;
   }*/
   
	public List<Movimento> consultarTodos(int idConta)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstm = null;
		List<Movimento> dados = new ArrayList<Movimento>();
		ResultSet rs = null;
      
		try
		{
			String query = "SELECT * FROM Movimento WHERE id_Conta = "+idConta+";";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();

			while(rs.next())  
			{
				Movimento al = new Movimento(idConta);
				al.setId( Integer.parseInt( rs.getString("idMovimento") ) );
				al.setData( rs.getString("dataOperacao") );
				al.setTipo( rs.getString("tipoOperacao") );
				al.setAgencia( rs.getString("agencia") );
				al.setConta( rs.getString("conta") );
				al.setValor( Double.parseDouble( rs.getString("valor") ) );
				al.setSaldoAtual( Double.parseDouble( rs.getString("saldoAtual") ) );
				dados.add( al );
            
            //total++; //variável que armazena a qtd de mercadorias cadastradas
			}
		}
		catch(SQLException e)
		{
			try
			{
				if(conn != null)
					conn.rollback();
			}
			catch(SQLException e1)
			{
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			}
			finally
			{
				DBConnection.close(conn, pstm, rs);
			}
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}      
		return dados;
	}
}