package to;

public class MovimentoTO
{
   private String data;
   private String tipo;
   private String agencia;
   private String conta;
   private double valor;
   private double saldoAtual;
   private int id;
   private int idConta;
   
   public void setIdConta(int idConta)
   {
      this.idConta = idConta;
   }
   
   public void setData(String data)
   {
      this.data = data;
   }
   
   public void setTipo(String tipo)
   {
      this.tipo = tipo;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public void setAgencia(String agencia)
   {
      this.agencia = agencia;
   }
   
   public void setConta(String conta)
   {
      this.conta = conta;
   }
   
   public void setValor(double valor)
   {
      this.valor = valor;
   }
   
   public void setSaldoAtual(double saldoAtual)
   {
      this.saldoAtual = saldoAtual;
   }
   
   public int getId()
   {
      return id;
   }
   
   public String getData()
   {
      return data;
   }
   
   public String getTipo()
   {
      return tipo;
   }
   
   public String getAgencia()
   {
      return agencia;
   }
   
   public String getConta()
   {
      return conta;
   }
   
   public double getValor()
   {
      return valor;
   }
   
   public double getSaldoAtual()
   {
      return saldoAtual;
   }
   
   public int getIdConta()
   {
      return idConta;
   }
}