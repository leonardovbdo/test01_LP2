package question02;

public class Vacina {
    private String nome;
    private String doencasImunizadas;
    private int dosesInicial;
    private int dosesReforco;
    private int mesesAplicacao;
    private int criancasImunizadas;

    //Construtor
    public Vacina(String nome, String doencasImunizadas, int dosesInicial, int dosesReforco, int mesesAplicacao) {
        this.nome = nome;
        this.doencasImunizadas = doencasImunizadas;
        this.dosesInicial = dosesInicial;
        this.dosesReforco = dosesReforco;
        this.mesesAplicacao = mesesAplicacao;
        this.criancasImunizadas = 0;
    }

    //Métodos Especiais
    public void adicionarAplicacao(){
        this.criancasImunizadas++;
    }

    public int getTotalDoses(){
        return (this.dosesInicial + this.dosesReforco);
    }

    //Getter para todos os atributos
    public String getNome() {
        return nome;
    }

    public String getDoencasImunizadas() {
        return doencasImunizadas;
    }

    public int getDosesInicial() {
        return dosesInicial;
    }

    public int getDosesReforco() {
        return dosesReforco;
    }

    public int getMesesAplicacao() {
        return mesesAplicacao;
    }

    public int getCriancasImunizadas() {
        return criancasImunizadas;
    }
}
