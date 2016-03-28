import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;

public class TelaLancamentos extends JFrame implements ActionListener
{
   private List<Movimento> valores;
   
	private JLabel lTitular, lLancamentos;
	private JButton bImprimir, bVoltar;   
	private Container c;
   private JTable table;
   private JScrollPane scrollPane;
	private ResourceBundle bn = null;
   private String lingua, pais, titular;
   private Conta co;
   	
   private List<Movimento> movimentoList;
      
	public TelaLancamentos(String lingua, String pais, JLabel lTitular, Conta co)
	{
      super();
      c = getContentPane();
      c.setLayout(new BorderLayout());
		
      this.lingua = lingua;
      this.pais = pais;
      this.co=co;
      titular=lTitular.getText();
      
		lLancamentos = new JLabel("Lançamentos");
      
      bImprimir = new JButton("Imprimir");     
      bImprimir.addActionListener(this);
      getRootPane().setDefaultButton(bImprimir);
      
      bVoltar = new JButton("Voltar");     
      bVoltar.addActionListener(this);
		     
      table = new JTable();
      scrollPane = new JScrollPane(table);
      JPanel panelTable = new JPanel(new GridLayout(1,1));
      panelTable.add(scrollPane);
      refreshTable();           
      
		//paineis					
		JPanel fDireita = new JPanel(new FlowLayout());
		//fDireita.add(bImprimir);
      fDireita.add(bVoltar);

      JPanel pTitular = new JPanel(new FlowLayout());
      pTitular.add(lTitular);

      JPanel pDireita = new JPanel(new BorderLayout());
      pDireita.add(fDireita, BorderLayout.EAST);
      
      setTitle("Banco 'X'");
      escolhaIdioma(lingua, pais);
      
      //quadrinho            
      JPanel p = new JPanel(new BorderLayout());
      p.add(panelTable, BorderLayout.CENTER);      
      TitledBorder t = new TitledBorder(lLancamentos.getText());
      p.setBorder(t);
      
		//container
      c.add(pTitular, BorderLayout.NORTH);
		c.add(p, BorderLayout.CENTER);
		c.add(pDireita, BorderLayout.SOUTH);		
      
		//detalhes     
		ImageIcon icone2 = new ImageIcon("2.png"); //https://macmagazine.com.br/wp-content/uploads/2012/06/27-ibank_icon.png
      setIconImage(icone2.getImage()); //altera o ícone da janela         
      Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
      setLocation((((tela.width-this.getSize().width)/2)-250), ((tela.height-this.getSize().height)/2)-200);            
		setSize(500, 400);
      setResizable(false);
		setVisible(true);
	}
	
   //ARRUMAR INTERNACIONALIZAÇÃO
   public void escolhaIdioma(String lingua, String pais) 
   { 
      Locale.setDefault(new Locale(lingua, pais));
      Locale locale = Locale.getDefault();
       
      bn = ResourceBundle.getBundle("Traducao", locale);
       
      bImprimir.setText(bn.getString("botao.imprimir"));
      bVoltar.setText(bn.getString("botao.voltar"));
      setTitle(bn.getString("titulo")); 
      lLancamentos.setText("");
   }
   
   public void actionPerformed(ActionEvent event)
   {     
      if(event.getSource() == bVoltar)
      {
         dispose();
      }
      
      /*if(event.getSource() == bImprimir)
      {
         ImpressaoExtrato ie = new ImpressaoExtrato(lingua, pais, co, titular, arquivoLogList);
      }*/
   }
   
   public void refreshTable()
   {
      movimentoList = new Movimento(co.getIdConta()).consultarTodos();
      if(movimentoList != null)
      {
         table.setModel(new LancamentosTableModel( movimentoList ));
         table.setDefaultRenderer(Object.class, new LancamentosCellRenderer());
      }
   }  
}
