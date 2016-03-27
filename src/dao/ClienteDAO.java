package dao;

import java.sql.*;
//import java.util.*;
import javax.swing.*;

import factory.DBConnection;
import to.ClienteTO;

public class ClienteDAO
{
	protected Statement statement = null;
	protected Connection conn = DBConnection.getConnection();
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
      
   	//p saber o nome
	public String consultarCliente(int idCliente)
	{
		String dados="";
		try
		{
			String query = "SELECT * FROM Cliente WHERE idCliente = "+idCliente+";";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
      
			while( rs.next() )          
				dados = rs.getString("nome");         
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		return dados;
	} 
   
	public void incluir(ClienteTO to)
	{
		String sqlInsert = "INSERT INTO Cliente(nome) VALUES (?)";

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1, to.getNome());					
			stm.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void atualizar(ClienteTO to)
	{
		String sqlUpdate = "UPDATE Cliente SET nome=?, WHERE idCliente=?";

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1, to.getNome());			
			stm.setInt(2, to.getIdCliente());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void excluir(ClienteTO to)
	{
		String sqlDelete = "DELETE FROM Cliente WHERE idCliente = ?";
 
		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, to.getIdCliente());
			stm.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ClienteTO carregar(int id)
	{
		ClienteTO to = new ClienteTO();
		String sqlSelect = "SELECT nome FROM Cliente WHERE idCliente = ?";

		try (Connection conn = DBConnection.getConnection();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();)
			{
				if (rs.next())
				{
					to.setNome(rs.getString("nome"));				
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
}        
   
   /*public int qtCliente()
   {
      int aux = 0;
      try
      {
         String query = "SELECT COUNT(*) AS 'C' FROM Cliente;";
         pstm = conn.prepareStatement(query);
         rs = pstm.executeQuery();
      
         while( rs.next() )  
         {
            aux = rs.getInt("C");
         }
      }
      catch(Exception e)
      {
      }
      return aux;
   }*/