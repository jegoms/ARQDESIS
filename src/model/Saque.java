import java.util.*;

public class Saque extends Movimento
{
   private Conta co;
   
   public Saque(String data, String tipo, String agencia, String conta, double valor, double saldoAtual, int idConta, Conta co)
   //valorOperacao deve ser double por causa do d�bito
   {
      super(data, tipo, agencia, conta, valor, saldoAtual, idConta);
      this.co=co;
   }
   
   public Saque(String data, double valor, Conta co)
   {
      super(data, "", "", "", valor, 0, 0);
      this.co=co;
   }
   
   //aqui v� se a a pessoa n digitou dois reais por exemplo
   public boolean validarValor()
   {
      boolean flag = false;      
      //tem notas de 10
      //tem q ser maior q 10
      if( (valor%10)==0 )
         flag = true; //no lugar q chamar esse m�todo, se flag false, deve escrever q a pessoa deve digitar um v�lor v�lido      
      return flag;
   }   
   
   //se sim, verificar se h� saldo suficiente na conta
   public boolean verificarDisponibilidadeSaldo()
   {
      boolean flag = false;      
      if(validarValor())
      {
         if(valor <= co.getSaldo()) //onde co eh conta
            flag = true;
      }      
      return flag;
   }
	
	//instanciar Dispenser e consultar as notas
   public boolean sacar()
   {
      boolean flag = false;
      DispenserDAO dd = new DispenserDAO();     
      Dispenser d = dd.consultar();
      ContaDAO cd = new ContaDAO();
      
      if(d.consultaNota((int)valor))
      {
         d.escolherNotas((int)valor);
         co.setSaldo((co.getSaldo()-valor)); //atualiza saldo
         cd.atualizarSaldo(co);
         dd.alterar(d);
         flag = true;
      }   
         
      return flag;
   }
	
   //tem q ajeitar as msg p outra l�ngua
	public int efetuarSaque()
   {
      int saida;      
      
      if(validarValor())
      {
         if(verificarDisponibilidadeSaldo())
         {
            if(sacar())
            {
               setTipo("Saque");
               setAgencia(co.getAgencia());
               setConta(co.getConta());               
               setSaldoAtual(co.getSaldo());
               setIdConta(co.getIdConta());
               
               criar();               
               
               //Saque realizado com sucesso!                                             
               saida = 1;
            }
            else
            {
               //Saque indispon�vel no momento //n�o h� notas suficientes
               saida = -1;
            }
         }
         else
         {
            //Saldo insuficiente para realizar esta opera��o
            saida = 0;
         }
      }
      else
      {
         //Valor inv�lido
         saida = -2;
      }      
      return saida;
   }		
}