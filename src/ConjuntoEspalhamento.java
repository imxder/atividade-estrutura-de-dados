import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {

    private ArrayList<LinkedList<String>> tabela;
    private int tamanho = 0;

    private int calculaIndiceDaTabela(String palavra) {
        return Math.abs(palavra.toLowerCase().hashCode() % tabela.size());
    }

    public ConjuntoEspalhamento() {
        this.tabela = new ArrayList<LinkedList<String>>();
        for (int i = 0; i < 26; i++) {
            this.tabela.add(new LinkedList<String>());
        }
    }

    public void adiciona(String palavra) {
        if (!this.contem(palavra)) {
            tamanho++;
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.add(palavra);
            if ((1.0 * tamanho) / this.tabela.size() > 0.75) {
                this.redimensionaTabela();
            }
        }
    }

    public void remove(String palavra) {
        if (this.contem(palavra)) {
            tamanho--;
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.remove(palavra);
            if ((1.0 * tamanho) / this.tabela.size() < 0.25) {
                this.redimensionaTabela();
            }
        }
    }

    public boolean contem(String palavra) {
        int indice = this.calculaIndiceDaTabela(palavra);
        List<String> lista = this.tabela.get(indice);
        return lista.contains(palavra);
    }

    public List<String> pegaTodas() {
        List<String> lista = new ArrayList<>();
        for (List<String> itens : tabela) {
            lista.addAll(itens);
        }
        return lista;
    }

    public int tamanho() {
        return tamanho;
    }

    private void redimensionaTabela() {
        List<String> palavras = this.pegaTodas();
        this.tabela.clear();
        for (int i = 0; i < this.tabela.size() * 2; i++) {
            this.tabela.add(new LinkedList<String>());
        }
        for (String palavra : palavras) {
            this.adiciona(palavra);
        }
    }
    
    public boolean olhaTodasAsLetras(String palavra, char letra) {
        palavra = palavra.toLowerCase();
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

}
