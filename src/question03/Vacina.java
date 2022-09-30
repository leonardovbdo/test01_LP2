package question03;

public class Vacina {
    private String nome;
    private String doencasImunizadas;
    private int dosesInicial;
    private int dosesReforco;
    private int mesesAplicacao;
    private int criancasImunizadas;

    //construtor

    public Vacina(String nome, String doencasImunizadas,
                  int dosesInicial, int dosesReforco, int mesesAplicacao) throws Exception {
        if (dosesInicial < 0 || dosesReforco < 0 || mesesAplicacao < 0){
            throw new Exception("* Houve um erro na adição da vacina *");
        } else {
            this.nome = nome;
            this.doencasImunizadas = doencasImunizadas;
            this.dosesInicial = dosesInicial;
            this.dosesReforco = dosesReforco;
            this.mesesAplicacao = mesesAplicacao;
        }
    }

    //métodos especiais
    public void adicionarAplicacao(){
        this.criancasImunizadas++;
    }

    public int getTotalDoses(){
        return (this.dosesInicial + this.dosesReforco);
    }

    //getter para todos os atributos

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
