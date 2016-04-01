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

   @Override
   public String toString()
   {
	   return "MovimentoTO [data=" + data + ", tipo=" + tipo + ", agencia=" + agencia + ", conta=" + conta + ", valor="
			+ valor + ", saldoAtual=" + saldoAtual + ", id=" + id + ", idConta=" + idConta + "]";
   }
   
   @Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoTO other = (MovimentoTO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;

		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		
		if (valor != other.valor)
			return false;
		
		if (saldoAtual != other.saldoAtual)
			return false;
		
		if (id != other.id)
			return false;
		
		if (idConta != other.idConta)
			return false;
		
		return true;
	}
}