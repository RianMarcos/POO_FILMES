
public class Filme implements Comparable<Filme> {
	private String nome;
	private int nota; // de 0 a 5
	private boolean favorito;
	// opcional
	private String comentario;
	// ter um atributo comentário no filme OU Sessão
	// se feito nos dois, é bônus
	
	// outro adicional 
	// private Genero genero;
	
	// construtor
	public Filme(String nome, int nota, boolean favorito, String comentario) {
        super(); // chama o construtor da superclasse, no caso Object
        this.nome = nome;
        this.nota = nota;
        this.favorito = favorito;
        this.comentario = comentario;
    }
	
	public Filme(String nome, int nota, String comentario) {
        super(); // chama o construtor da superclasse, no caso Object
        this.nome = nome;
        this.nota = nota;
        this.comentario = comentario;
    }
	
	public Filme(String nome, int nota, boolean favorito) {
        super(); // chama o construtor da superclasse, no caso Object
        this.nome = nome;
        this.nota = nota;
        this.favorito = favorito;
    }



	@Override
	public int compareTo(Filme filme) {
		// TODO 
		return 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	  @Override
	public String toString() {
	     return "Filme{" +
	                "nome='" + nome + '\'' +
	                ", nota=" + nota +
	                ", favorito=" + favorito +
	                ", comentario='" + comentario + '\'' +
	                '}';
	 }
	  
}
