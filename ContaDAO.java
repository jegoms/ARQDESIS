package dao;

import to.ContaTO;
import factory.DBConnection;
import model.Conta;

import java.sql.*;
//import java.util.*;
//import javax.swing.*;

public class ContaDAO
{
	protected Statement statement = null;
	protected Connection conn = DBConnection.getConnection();
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;   
   
   //---------------------------------
	public void incluir(ContaTO to)
	{
		String sqlInsert = "INSERT INTO Conta(idConta, agencia, numeroConta, saldo) VALUES (?, ?, ?, ?)";

   		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);)
   		{
   			stm.setInt(1, to.getIdConta());
   			stm.setString(2, to.getAgencia());
   			stm.setString(3, to.getConta());
            stm.setDouble(4, to.getSaldo());
   			stm.execute();
   		}
   		catch (SQLException e)
   		{
   			e.printStackTrace();
   		}
   	}
      
	public void atualizar(ContaTO to)
	{
		String sqlUpdate = "UPDATE Conta SET agencia=?, numeroConta=?, saldo=? WHERE idConta=?";

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, to.getAgencia());
			stm.setString(2, to.getConta());
            stm.setDouble(3, to.getSaldo());
			stm.setInt(4, to.getIdConta());
			stm.execute();
		}
		catch (Exception e)
        {
			e.printStackTrace();
        }
   	}

	public void excluir(ContaTO to)
	{
   		String sqlDelete = "DELETE FROM Conta WHERE idConta = ?";

   		try (Connection conn = DBConnection.getConnection();
		 	 PreparedStatement stm = conn.prepareStatement(sqlDelete);)
   		{
   			stm.setInt(1, to.getIdConta());
   			stm.execute();
   		}
        catch (Exception e)
        {
   			e.printStackTrace();
        }
   	}
      
	public ContaTO carregar(int idConta)
    {
   		ContaTO to = new ContaTO();
   		String sqlSelect = "SELECT agencia, numeroConta, saldo FROM Conta WHERE idConta = ?";

   		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);)
   		{
   			stm.setInt(1, idConta);
   			try (ResultSet rs = stm.executeQuery();)
            {
   				if (rs.next())
   				{
					to.setAgencia(rs.getString("agencia"));
					to.setConta(rs.getString("numeroConta"));
					to.setSaldo(rs.getDouble("saldo"));
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
      
   //-------------------------------
   
   //p saber o id do cliente
	public String consultarIdCliente(Conta co)
	{
		String dados = "";      
		String sqlSelect = "SELECT * FROM Conta WHERE numeroConta = ?;";
      
		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setString(1, co.getConta());

			try (ResultSet rs = stm.executeQuery();)
			{
				while(rs.next())
				{
					dados += rs.getString("id_Cliente");
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
		return dados;		
	}
   
   //distingue as contas do cliente
	public String consultarIdConta(Conta co)
	{	
		String dados = "";
		String sqlSelect = "SELECT * FROM Conta WHERE numeroConta = ?;";
      
		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setString(1, co.getConta());

			try (ResultSet rs = stm.executeQuery();)
			{
				while(rs.next())
				{
					dados += rs.getString("idConta");
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
		return dados;
	}
   
	public String consultarSaldo(Conta co)
	{  
		String dados = "";
		String sqlSelect = "SELECT * FROM Conta WHERE idConta = ?;";
      
		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, co.getIdConta());

			try (ResultSet rs = stm.executeQuery();)
			{
				while(rs.next())
				{
					dados += rs.getString("saldo");
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
		return dados;
	}
   
   //atualizar saldo     
	public int atualizarSaldo(Conta co)
	{
		String sqlUpdate = "UPDATE Conta SET saldo = ? WHERE idConta= ?;";
		int result = 0;
      
		try (Connection conn = DBConnection.getConnection();
			  PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
         
			stm.setDouble(1, co.getSaldo());
			stm.setInt(2, co.getIdConta());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
      
		finally
		{
			DBConnection.close(conn, pstm, null); //null pq n tem resultset
		}     
		return result;
	}  
}