package sample.cnab;

import java.util.ArrayList;

/**
 * Created by brunosales on 28/08/15.
 */
public class Registro {

    private String segmento;
    private String descricao;
    private boolean obrigatorio;
    private boolean repetido;
    private ArrayList<Campo> campos;

    public Registro(String segmento, String descricao, boolean obrigatorio, boolean repetido, ArrayList<Campo> campos) {
        this.segmento = segmento;
        this.descricao = descricao;
        this.obrigatorio = obrigatorio;
        this.repetido = repetido;
        this.campos = campos;
    }

    /**
     * Getter for property 'segmento'.
     *
     * @return Value for property 'segmento'.
     */
    public String getSegmento() {
        return segmento;
    }

    /**
     * Setter for property 'segmento'.
     *
     * @param segmento Value to set for property 'segmento'.
     */
    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    /**
     * Getter for property 'descricao'.
     *
     * @return Value for property 'descricao'.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Setter for property 'descricao'.
     *
     * @param descricao Value to set for property 'descricao'.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Getter for property 'obrigatorio'.
     *
     * @return Value for property 'obrigatorio'.
     */
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    /**
     * Setter for property 'obrigatorio'.
     *
     * @param obrigatorio Value to set for property 'obrigatorio'.
     */
    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    /**
     * Getter for property 'repetido'.
     *
     * @return Value for property 'repetido'.
     */
    public boolean isRepetido() {
        return repetido;
    }

    /**
     * Setter for property 'repetido'.
     *
     * @param repetido Value to set for property 'repetido'.
     */
    public void setRepetido(boolean repetido) {
        this.repetido = repetido;
    }

    /**
     * Getter for property 'campos'.
     *
     * @return Value for property 'campos'.
     */
    public ArrayList<Campo> getCampos() {
        return campos;
    }

    /**
     * Setter for property 'campos'.
     *
     * @param campos Value to set for property 'campos'.
     */
    public void setCampos(ArrayList<Campo> campos) {
        this.campos = campos;
    }
}
