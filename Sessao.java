
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Sessao {
	   private Filme filme;
	   private Local local;
	   private LocalDateTime data;
	   private float preco;
	   private String comentario;
	   
	 public Sessao(Filme filme, Local local, LocalDateTime data, float preco, String comentario) {
	        this.filme = filme;
	        this.local = local;
	        this.data = data;
	        this.preco = preco;
	        this.comentario = comentario;
	  }
	 
	 public Sessao(Filme filme, Local local, float preco) {
	        this.filme = filme;
	        this.local = local;
	        this.preco = preco;
	  }

	    @Override
	 public String toString() {
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE – HH'h'mm");
	        String dataFormatada = data.format(formatter);
	        return "Sessao{" +
	                "filme=" + filme +
	                ", local=" + local +
	                ", data=" + dataFormatada +
	                ", preco=" + preco +
	                ", comentario='" + comentario + '\'' +
	                '}';
	  }

		public Filme getFilme() {
			return filme;
		}

		public void setFilme(Filme filme) {
			this.filme = filme;
		}

		public Local getLocal() {
			return local;
		}

		public void setLocal(Local local) {
			this.local = local;
		}

		public String getData() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE – HH'h'mm");
	        String dataFormatada = data.format(formatter);
			return dataFormatada;
		}
		
		public LocalDateTime getDataOriginal() {
	        return data;
	    }
		  
		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}


}


