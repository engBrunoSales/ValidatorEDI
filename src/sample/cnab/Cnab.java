package sample.cnab;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by brunosales on 13/07/15.
 */
public class Cnab {

    private static int cnab;
    private String banco;
    private String versao;
    private int ano_layout;
    private String header;
    private String headerlote;
    private String detalhe;
    private String trailerlote;
    private String trailer;
    private int posicaoSegmento;
    private ArrayList<Registro> registros;

    private String logErroLeitura = "";


    public Cnab( ){

    }

    /**
     * Getter for property 'cnab'.
     *
     * @return Value for property 'cnab'.
     */
    public int getCnab() {
        return cnab;
    }

    /**
     * Getter for property 'banco'.
     *
     * @return Value for property 'banco'.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Setter for property 'banco'.
     *
     * @param banco Value to set for property 'banco'.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Getter for property 'versao'.
     *
     * @return Value for property 'versao'.
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Setter for property 'versao'.
     *
     * @param versao Value to set for property 'versao'.
     */
    public void setVersao(String versao) {
        this.versao = versao;
    }

    /**
     * Getter for property 'ano_layout'.
     *
     * @return Value for property 'ano_layout'.
     */
    public int getAno_layout() {
        return ano_layout;
    }

    /**
     * Setter for property 'ano_layout'.
     *
     * @param ano_layout Value to set for property 'ano_layout'.
     */
    public void setAno_layout(int ano_layout) {
        this.ano_layout = ano_layout;
    }

    /**
     * Getter for property 'header'.
     *
     * @return Value for property 'header'.
     */
    public String getHeader() {
        return header;
    }

    /**
     * Setter for property 'header'.
     *
     * @param header Value to set for property 'header'.
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Getter for property 'headerlote'.
     *
     * @return Value for property 'headerlote'.
     */
    public String getHeaderlote() {
        return headerlote;
    }

    /**
     * Setter for property 'headerlote'.
     *
     * @param headerlote Value to set for property 'headerlote'.
     */
    public void setHeaderlote(String headerlote) {
        this.headerlote = headerlote;
    }

    /**
     * Getter for property 'detalhe'.
     *
     * @return Value for property 'detalhe'.
     */
    public String getDetalhe() {
        return detalhe;
    }

    /**
     * Setter for property 'detalhe'.
     *
     * @param detalhe Value to set for property 'detalhe'.
     */
    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    /**
     * Getter for property 'trailerlote'.
     *
     * @return Value for property 'trailerlote'.
     */
    public String getTrailerlote() {
        return trailerlote;
    }

    /**
     * Setter for property 'trailerlote'.
     *
     * @param trailerlote Value to set for property 'trailerlote'.
     */
    public void setTrailerlote(String trailerlote) {
        this.trailerlote = trailerlote;
    }

    /**
     * Getter for property 'trailer'.
     *
     * @return Value for property 'trailer'.
     */
    public String getTrailer() {
        return trailer;
    }

    /**
     * Setter for property 'trailer'.
     *
     * @param trailer Value to set for property 'trailer'.
     */
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    /**
     * Getter for property 'posicaoSegmento'.
     *
     * @return Value for property 'posicaoSegmento'.
     */
    public int getPosicaoSegmento() {
        return posicaoSegmento;
    }

    /**
     * Setter for property 'posicaoSegmento'.
     *
     * @param posicaoSegmento Value to set for property 'posicaoSegmento'.
     */
    public void setPosicaoSegmento(int posicaoSegmento) {
        this.posicaoSegmento = posicaoSegmento;
    }

    /**
     * Getter for property 'registros'.
     *
     * @return Value for property 'registros'.
     */
    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    /**
     * Setter for property 'registros'.
     *
     * @param registros Value to set for property 'registros'.
     */
    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }


    /**
     * Getter for property 'logErroLeitura'.
     *
     * @return Value for property 'logErroLeitura'.
     */
    public String getLogErroLeitura() {
        return logErroLeitura;
    }

    /**
     * Setter for property 'logErroLeitura'.
     *
     * @param logErroLeitura Value to set for property 'logErroLeitura'.
     */
    public void setLogErroLeitura(String logErroLeitura) {
        this.logErroLeitura = logErroLeitura;
    }

    public void verificaSeENumerico( String valor ){

    }

    public void verificaSeEAlfanumerico( String valor ){

    }

    public void verificaSeEDecimal( String valor ){


    }

    public void verificaSeEData(  ){


    }

    public void verificaValorDoCampo( String valor, String tipo, String nomeCampo, String nomeRegistro ){

        switch ( tipo ){
            case "9" :
                this.verificaSeENumerico( valor );
            case "A" :
                this.verificaSeEAlfanumerico( valor );
            case "N" :
                this.verificaSeEDecimal( valor );
            default:
                System.err.println(" O campo: " + nomeCampo + " do Segmento: " + nomeRegistro + " não apresenta" +
                        " nenhum tipo padrão( 9, N, A ) para o valor: " + valor + " .");
        }
    }


    /**
     * Método que ler o arquivo json e cria os objetos referentes a leitura.
     *
     * @param json String referente ao json lido a partir do arquivo de configuração.
     */
    public void jsonForObject( String json ){

        JSONObject my_obj = new JSONObject( json );

        this.cnab            = my_obj.getInt( "cnab" );
        this.banco           = my_obj.getString( "banco" );
        this.versao          = my_obj.getString( "versao" );
        this.ano_layout      = my_obj.getInt( "ano_layout" );
        this.header          = my_obj.getString( "header" );
        this.headerlote      = my_obj.getString( "headerlote" );
        this.detalhe         = my_obj.getString( "detalhe" );
        this.trailerlote     = my_obj.getString( "trailerlote" );
        this.trailer         = my_obj.getString( "trailer" );
        this.posicaoSegmento = my_obj.getInt( "posicaoSegmento" );

        JSONArray registrosJSON = my_obj.getJSONArray("registros");
        ArrayList<Registro> registros = new ArrayList<>( registrosJSON.length( ) );
        for ( int i = 0; i < registrosJSON.length( ); i++ ) {
            JSONObject registroJson = registrosJSON.getJSONObject( i );

            String segmento = registroJson.getString( "segmento" );
            String descricao = registroJson.getString( "descricao" );
            boolean obrigatorio = registroJson.getBoolean( "obrigatorio");
            boolean repetido = registroJson.getBoolean( "repetido" );


            JSONArray camposJson = my_obj.getJSONArray( "campos" );
            ArrayList<Campo> campos = new ArrayList<Campo>( camposJson.length( ) );
            for ( int j = 0; i < camposJson.length(); j++ ){
                JSONObject campoJson = camposJson.getJSONObject( j );

                String nome = campoJson.getString( "campo" );
                String descricaoCampo = campoJson.getString( "descricao" );
                int inicio = campoJson.getInt( "inicio" );
                int tamanho = campoJson.getInt( "tamanho" );
                boolean campoObrigatorio = campoJson.getBoolean( "obrigatorio" );
                String valorPadrao = campoJson.getString( "default" );
                String valor = campoJson.getString( "valor" );
                String tipo = campoJson.getString( "tipo" );

                this.verificaValorDoCampo( valor, tipo, nome, segmento );

                Campo campo = new Campo( nome, valor, tamanho, inicio, tipo, campoObrigatorio );

                /* Colocar o valorPadrao aqui */

                campos.add(campo);

            }
            Registro registro = new Registro( segmento, descricao, obrigatorio, repetido, campos );
            registros.add( registro );

        }

        this.registros = registros;

    }

















}
