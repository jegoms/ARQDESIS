package factory;
import java.sql.*;
 
public class DBConnection
{
   private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/ProjetoSistemaBancario";
   private static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
   private static final String USER = "root";
   private static final String PASS = "9114115693532601"; //senha!!
   
   public static Connection getConnection()
   {
      System.out.println("Conectando ao Banco de Dados");
      try
      {
         Class.forName(DRIVER_CLASS_MYSQL);
         return DriverManager.getConnection(URL_MYSQL, USER, PASS);
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (SQLException e)
      {
         throw new RuntimeException(e);
      }
      return null;
   }
 
   public static boolean close(Connection conn, PreparedStatement stmt, ResultSet rs)
   {
	  boolean flag = true;
      try
      {
         if (conn!= null)
         {
            conn.close();
         }
      
         if (stmt!= null)
         {
            stmt.close();
         }
      
         if (rs!= null)
         {
            rs.close();
         }
      } 
      catch (SQLException e)
      {
         e.printStackTrace();
         flag = false;
      }
      return flag;
   }

}