//ARRUMAR A INTERNACIONALIZAÇÃO

import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.util.*;

public class LancamentosTableModel extends AbstractTableModel
{
   //classe que controi a tabela
   private static final int colData = 0;
   private static final int colTipo = 1;
   private static final int colDocumento = 2;
   private static final int colValor = 3;
   private static final int colSaldo = 4;
   
   private List<Movimento> valores;
   
   public LancamentosTableModel(List<Movimento> valores)
   {  
      this.valores = valores;
   }
   
   public int getRowCount()
   {
      return valores.size();//10;//valores.size(); //quantas linhas a tabela possui
   }
   
   public int getColumnCount()
   {
      return 5;
   }
   
   public Object getValueAt(int rowIndex, int columnIndex) //o método vai saber o q vai ser acessado
   {//é a partir deste que se consegue preencher a tabela

      Movimento al = valores.get(rowIndex);
      
      if(columnIndex == colData)
         return al.getData();
      
      if(columnIndex == colTipo)
         return al.getTipo();
      
      if(columnIndex == colDocumento)
         return al.getId();
      
      if(columnIndex == colValor)
         return al.getValor();
         
      if(columnIndex == colSaldo)
         return "R$ " + al.getSaldoAtual();
          
      return null;
   }
      
   public String getColumnName(int column)
   {
      String coluna = "";
      switch(column)
      {
         case colData: 
            coluna = "Data";
            break;
         case colTipo:
            coluna = "Tipo";
            break;
         case colDocumento: 
            coluna = "Documento";
            break;
         case colValor:
            coluna = "Valor";
            break;
         case colSaldo: 
            coluna = "Saldo";
            break;       
         default:
            throw new IllegalArgumentException("Coluna inválida");
      }
      return coluna;
   }
}