
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Aplicacao {
	
	private static Lista lista; 
	// scanner
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		lista = new Lista();
		adicionarSessoesIniciais(); 
		int opcao;
		 do {
	            System.out.println("\n*** Menu principal ***\n");
	            System.out.println("0 - sair");
	            System.out.println("1 - Cadastrar filme");
	            System.out.println("2 - Mostrar dados filme (filme, sessão)");
	            System.out.println("3 - Editar filme");
	            System.out.println("4 - Listagem ordem alfabética");
	            System.out.println("5 - Listagem ordem avaliação");
	            System.out.println("6 - Listagem cronológica");
	            System.out.println("7 - Listagem favoritos");
	            System.out.print("\n>> Informe a opção desejada ");
	            opcao = teclado.nextInt();
	            teclado.nextLine(); // consumir o enter que ficou no buffer
	            switch (opcao){ 
                case 1:
                   lista.cadastrarSessao(lerSessao());
                    break;  
                case 2:
                	pesquisarFilme();
                    break;
                case 3:
                    editarFilme();
                    break;
                case 4:
                	lista.listarFilmesEmOrdemAlfabetica();
                    break;
                case 5:
                	 lista.listarFilmesEmOrdemAvaliacao();
                    break;
                case 6:
                	 lista.listarFilmesEmOrdemCronologica();
                    break;
                case 7:  // 
                	  lista.listarFilmesFavoritos();
                    break;
            }
		 } while (opcao != 0);
    }
	
	 private static void adicionarSessoesIniciais() {
	        // essões iniciais para facilitar a demonstração
	        Filme filme1 = new Filme("Interestelar", 8,true, "Bom filme");
	        Filme filme2 = new Filme("efeito borboleta", 10, false, "FILME DE QUALIDADE");
	        Filme filme3 = new Filme("Simplesmente acontece", 9, true, "muito Romance");
	        Filme filme4 = new Filme("DragonBall Evolution", 1, true, "chato");

	        Local local1 = new Local("Pátio Batel");
	        Local local2 = new Local("Jockey Plaza");
	        Local local3 = new Local("Shopping Jardim das Americas");

	        LocalDateTime data1 = LocalDateTime.of(2022, 12, 28, 20, 30);
	        LocalDateTime data2 = LocalDateTime.of(2022, 3, 17, 21, 30);
	        LocalDateTime data3 = LocalDateTime.of(2021, 1, 6, 22, 0);

	       lista.cadastrarSessao(new Sessao(filme1, local1, data1, 15.50f, "Ótimo local "));
	       lista.cadastrarSessao(new Sessao(filme2, local2, data2, 20.00f, "Recomendo"));
	       lista.cadastrarSessao(new Sessao(filme3, local3, data3, 16.50f, "Recomendo"));
	       lista.cadastrarSessao(new Sessao(filme4, local3, data3, 5f, "sem comentários..."));
	 }
	 public static Sessao lerSessao(){
		    System.out.println("\n*** Ler Sessao ***\n");
		    teclado.nextLine(); // Consumir a quebra de linha
		    System.out.print("Nome do filme: ");
		    String nomeFilme = teclado.nextLine();
		    System.out.print("Nota do filme: ");
		    int nota = teclado.nextInt();
		    System.out.print("Favorito? ");
		    boolean favorito = teclado.nextBoolean();
		    System.out.print("Preço da sessão: ");
		    float preco = teclado.nextFloat();
		    teclado.nextLine(); // Consumir a quebra de linha
		    System.out.print("Comentário do filme? ");
		    String comentario_filme = teclado.nextLine();
		    System.out.print("comentário da essa sessao: ");
		 
		 
	        String comentario_sessao = teclado.nextLine();
		    System.out.print("Nome do local? ");
		    String nomeLocal = teclado.nextLine();
		    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
		    String dataHoraStr = teclado.nextLine();
		    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		    Filme filme = new Filme(nomeFilme, nota, favorito, comentario_filme);
		    Local local = new Local(nomeLocal);
		    
		    return new Sessao(filme, local, dataHora, preco, comentario_sessao);
		}
	 
	 public static void pesquisarFilme(){
	        System.out.println("\n*** Mostrar filme ***\n");
	        Sessao sessao = encontrarSessao();
	        if (sessao != null)
	          mostrarFilme(sessao);
	        else System.out.println("Filme não encontrado");
	    }
	 
	 public static void mostrarFilme(Sessao sessao){
	        System.out.println("Nome: "+sessao.getFilme().getNome());
	        System.out.println("Nota: "+sessao.getFilme().getNota());
	        System.out.println("Favorito: "+sessao.getFilme().isFavorito());
	        System.out.println("Data: "+sessao.getData());
	        System.out.println("Preço: "+sessao.getPreco());
	        System.out.println("Local: "+sessao.getLocal().getNome());
	        System.out.println("Comentário do filme: "+sessao.getFilme().getComentario());
	        System.out.println("Comentário da sessão: "+sessao.getComentario());
	    }
	 
	 public static Sessao encontrarSessao() {
		    System.out.print("Informe o nome do filme");
		    String nome = teclado.nextLine();
		    for (Sessao sessao : lista) {
		        if (sessao.getFilme().getNome().toUpperCase().contains(nome.toUpperCase())) {
		            System.out.println("Achei " + sessao.getFilme().getNome());
		            System.out.println("É o filme procurado <S/N>? ");
		            String conf = teclado.nextLine();
		            if (conf.toUpperCase().charAt(0) == 'S')
		                return sessao;
		        }
		    }
		    return null;
		}
	 public static void editarFilme() {
		    System.out.println("\n*** Editar filme ***\n");
		    Sessao sessao = encontrarSessao();
		    if (sessao != null) {
		        System.out.print("Deseja editar a nota do filme? (S/N) ");
		        String resposta = teclado.nextLine();
		        if (resposta.equalsIgnoreCase("S")) {
		            System.out.print("Nova nota: ");
		            int novaNota = teclado.nextInt();
		            teclado.nextLine(); // Consumir a quebra de linha
		            sessao.getFilme().setNota(novaNota);
		        } else {
		            System.out.println("Nota mantida ");
		        }
		        System.out.print("Deseja editar o comentário do filme? (S/N) ");
		        resposta = teclado.nextLine();
		        if (resposta.equalsIgnoreCase("S")) {
		            System.out.print("Novo comentário: ");
		            String novoComentario = teclado.nextLine();
		            sessao.getFilme().setComentario(novoComentario);
		        } else {
		            System.out.println("Sem mudanças no comentário do filme");
		        }
		        System.out.print("Deseja editar o comentário da sessão? (S/N) ");
		        resposta = teclado.nextLine();
		        if (resposta.equalsIgnoreCase("S")) {
		            System.out.print("Novo comentário da sessão: ");
		            String novoComentarioSessao = teclado.nextLine();
		            sessao.setComentario(novoComentarioSessao);
		        } else {
		            System.out.println("Sem mudanças no comentário da sessão ");
		        }
		        System.out.println("As modificações foram salvas!");
		    } else {
		        System.out.println("Filme não encontrado");
		    }
		}
	
	}
		 
