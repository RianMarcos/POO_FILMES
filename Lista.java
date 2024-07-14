import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.LocalDateTime;


// lista agrega todas as sessões
// ela encapsula um arraylist de forma
// a esconder sua estrutura interna 
public class Lista implements Iterable<Sessao>{
    private ArrayList<Sessao> lista;
    
    // construtor
    public Lista() {
        this.lista = new ArrayList<>();

    }
    
    public void cadastrarSessao(Sessao sessao) {
        lista.add(sessao);
    }

    
    @Override
    public Iterator<Sessao> iterator() {
        return lista.iterator();
    }
    
    public void remove(Sessao sessao){
        lista.remove(sessao);
    }

    public void remove(int i){
        lista.remove(i);
    }
    
    public void listarFilmesEmOrdemAlfabetica() {
        Collections.sort(lista, new Comparator<Sessao>() {
            @Override
            public int compare(Sessao sessao1, Sessao sessao2) {
                return sessao1.getFilme().getNome().compareToIgnoreCase(sessao2.getFilme().getNome());
            }
        });
        
        System.out.println("Listagem de filmes em ordem alfabética:");
        System.out.println();
        
        for (Sessao sessao : lista) {
            System.out.println(sessao.getFilme().getNome() + " (" +
                               sessao.getData() + ") – " +
                               sessao.getLocal().getNome());
        }
    }
    public void listarFilmesEmOrdemAvaliacao() {
        Collections.sort(lista, new Comparator<Sessao>() {
            @Override
            public int compare(Sessao sessao1, Sessao sessao2) {
                int comparacaoNota = Integer.compare(sessao2.getFilme().getNota(), sessao1.getFilme().getNota());
                if (comparacaoNota == 0) {
                    return sessao1.getFilme().getNome().compareToIgnoreCase(sessao2.getFilme().getNome());
                } else {
                    return comparacaoNota;
                }
            }
        });
        
        System.out.println("Listagem de filmes em ordem de avaliação e em ordem alfabética dentro da avaliação:");
        int notaAtual = -1;
        for (Sessao sessao : lista) {
            if (sessao.getFilme().getNota() != notaAtual) {
                notaAtual = sessao.getFilme().getNota();
                System.out.println("Nota " + notaAtual + ":");
                ArrayList<Sessao> filmesMesmaNota = new ArrayList<>();
                for (Sessao s : lista) {
                    if (s.getFilme().getNota() == notaAtual) {
                        filmesMesmaNota.add(s);
                    }
                }
                Collections.sort(filmesMesmaNota, new Comparator<Sessao>() {
                    @Override
                    public int compare(Sessao sessao1, Sessao sessao2) {
                        return sessao1.getFilme().getNome().compareToIgnoreCase(sessao2.getFilme().getNome());
                    }
                });
                for (Sessao s : filmesMesmaNota) {
                    System.out.println(s.getFilme().getNome() + " (" +
                                       s.getData() + ") – " +
                                       s.getLocal().getNome());
                }
            }
        }
    }
    public void listarFilmesFavoritos() {
        Collections.sort(lista, new Comparator<Sessao>() {
            @Override
            public int compare(Sessao sessao1, Sessao sessao2) {
                return sessao1.getFilme().getNome().compareTo(sessao2.getFilme().getNome());
            }
        });
        
        System.out.println("Listagem de filmes favoritos:");
        for (Sessao sessao : lista) {
            if (sessao.getFilme().isFavorito()) {
                System.out.println(sessao.getFilme().getNome() + " (" +
                                   sessao.getData().formatted(DateTimeFormatter.ofPattern("dd/MMM/yyyy, EEE", new Locale("pt", "BR"))) + ") – " +
                                   sessao.getLocal().getNome());
            }
        }
    }
    
    public void listarFilmesEmOrdemCronologica() {
        Collections.sort(lista, new Comparator<Sessao>() {
            @Override
            public int compare(Sessao sessao1, Sessao sessao2) {
                return sessao1.getDataOriginal().compareTo(sessao2.getDataOriginal());
            }
        });
        
        System.out.println("Listagem de filmes em ordem cronológica:");
        System.out.println();
        
        Month mesAtual = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd (EEE, HH:mm)", new Locale("pt", "BR"));
        for (Sessao sessao : lista) {
            LocalDateTime dataHora = sessao.getDataOriginal();
            LocalDate data = dataHora.toLocalDate();
            if (mesAtual == null || data.getMonth() != mesAtual) {
                mesAtual = data.getMonth();
                String nomeMes = mesAtual.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
                System.out.println(nomeMes + "/" + data.getYear());
            }
            System.out.println(
                               data.getDayOfMonth() + " (" +
                               data.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")) + ", " +
                               dataHora.format(formatter) +
                               ") - " + sessao.getFilme().getNome() +
                               " - " + sessao.getLocal().getNome());
            System.out.println(" ");
        }
    }

}
