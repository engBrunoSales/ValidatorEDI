package sample.cnab;

/**
 * Created by brunosales on 13/07/15.
 */
public class Campo {

    private String nome;
    private String valor;
    private int inicio;
    private int tamanho;
    private boolean obrigatorio;
    private String valorPadrao;
    private static String tipo;


    public Campo(String nome, String valor, int tamanho, int inicio, String tipo) {

        this.nome = nome;
        this.valor = valor;
        this.tamanho = tamanho;
        this.inicio = inicio;
        this.tipo = tipo;

    }

    public Campo(String nome, String valor, int tamanho, int inicio, String tipo, boolean obrigatorio) {

        this.nome = nome;
        this.valor = valor;
        this.tamanho = tamanho;
        this.obrigatorio = obrigatorio;
        this.inicio = inicio;
        this.tipo = tipo;

    }

    /**
     * Getter for property 'nome'.
     *
     * @return Value for property 'nome'.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter for property 'nome'.
     *
     * @param nome Value to set for property 'nome'.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter for property 'valor'.
     *
     * @return Value for property 'valor'.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Setter for property 'valor'.
     *
     * @param valor Value to set for property 'valor'.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Getter for property 'inicio'.
     *
     * @return Value for property 'inicio'.
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * Setter for property 'inicio'.
     *
     * @param inicio Value to set for property 'inicio'.
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    /**
     * Getter for property 'tamanho'.
     *
     * @return Value for property 'tamanho'.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Setter for property 'tamanho'.
     *
     * @param tamanho Value to set for property 'tamanho'.
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Getter for property 'tipo'.
     *
     * @return Value for property 'tipo'.
     */
    public static String getTipo() {
        return tipo;
    }
}

