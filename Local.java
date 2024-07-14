
public class Local {
	private String nome; 
	
	   public Local(String nome) {
		   super(); // chama o construtor da superclasse, no caso Object
	        this.nome = nome;
	    }


		public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    @Override
	    public String toString() {
	        return "Local{" +
	                "nome='" + nome + '\'' +
	                '}';
	    }

}
