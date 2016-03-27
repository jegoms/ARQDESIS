import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LancamentosCellRenderer extends DefaultTableCellRenderer
{
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
   {  
      super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
      if(row%2 == 0)
      {
         setBackground(Color.LIGHT_GRAY);
      }
      else
      {
         setBackground(null);
      } //para que as linhas pares fiquem cinza
      
      if(isSelected)
      {
         setBackground(Color.RED);
      }
      
      //ajustar tamanho das colunas
      table.getColumnModel().getColumn(0).setMinWidth(100);
      table.getColumnModel().getColumn(1).setMinWidth(100);
      table.getColumnModel().getColumn(2).setMinWidth(100);
      table.getColumnModel().getColumn(3).setMinWidth(100);
      table.getColumnModel().getColumn(4).setMinWidth(100);
      return this;
   }
}