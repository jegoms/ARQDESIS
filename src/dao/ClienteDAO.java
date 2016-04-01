package dao;

import java.sql.*;
import javax.swing.*;

import factory.DBConnection;
import to.ClienteTO;

public class ClienteDAO
{     
   	//p saber o nome
	public String consultarCliente(int idCliente)
	{
		String dados="";
		String sqlSelect = "SELECT * FROM Cliente WHERE idCliente = "+idCliente+";";
		
		try(Connection conn = DBConnection.getConnection();
				 PreparedStatement pstm = conn.prepareStatement(sqlSelect);)
		{									
			try(ResultSet rs = pstm.executeQuery())
			{      
				while( rs.next() )          
					dados = rs.getString("nome");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		return dados;
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
					to.setIdCliente(id);
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