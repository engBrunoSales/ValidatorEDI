package sample.edi;

import sample.cnab.Campo;
import sample.cnab.Cnab;
import sample.cnab.Registro;
import sample.error.ErrorEdi;

import java.util.ArrayList;

/**
 * Created by brunosales on 13/07/15.
 */
public class Edi {

    private Cnab cnab;
    private String arquivo;
    public static ErrorEdi error;

    public Edi( Cnab cnab, String arquivo )  {

        this.cnab = cnab;
        this.arquivo = arquivo;
        this.error = new ErrorEdi();
    }



    public void lerArquivo(){

        String auxArquivo = this.arquivo;
        String[] linha = auxArquivo.split("\n");
        for (int i = 0; i < linha.length; i++) {

            if (linha[i].length() != this.cnab.getCnab()){

                this.error.adicionaMensagemError("A quantidade de caracteres da linha: " + (i + 1) +
                        "( tamanho = " + linha[i].length() + " )" +
                        " é diferente do padrão cnab " + this.cnab.getCnab());

            }else {

                lerLinhaArquivo( linha[i], (i+1) );

            }

        }

    }

    public void lerLinhaArquivo( String linha, int numLinha ){

        char tipoSegmento = linha.charAt( this.cnab.getPosicaoSegmento() - 1 );

        Registro registro = this.cnab.encontraRegistro( tipoSegmento );

        if ( registro == null ){
            this.error.adicionaMensagemError( "Tipo de Registro: " + tipoSegmento +
                    " não encontrado não padrão cnab: " + numLinha + ".\t Verifique posição " +
                    "do Segmento no arquivo de configuração!" );
        }else {

            ArrayList<Campo> campos = registro.getCampos();

            for (int i = 0; i < campos.size(); i++) {

                Campo campo = campos.get(i);
                int inicio = campo.getInicio();
                int tamanho = campo.getTamanho();
                String campoNaLinha;
                if( inicio - 1 + tamanho <= this.cnab.getCnab() - 1 ){

                    campoNaLinha = linha.substring( inicio - 1, inicio - 1 + tamanho);
                }else{

                    campoNaLinha = linha.substring( inicio - 1 );
                }

                this.verificaCampoNaLnha( campo, campoNaLinha, numLinha );

            }

        }


    }


    public void verificaCampoNaLnha( Campo campo, String campoNaLinha, int numLinha ){

        String tipoDoCampo = campo.getTipo();
        if ( tipoDoCampo.compareTo(" ") == 0 ){
            this.verificaSeCampoEBranco( campo, campoNaLinha, numLinha );
        }else if ( tipoDoCampo.compareTo("9") == 0 ){
            this.verificaSeCampoENumerico( campo, campoNaLinha, numLinha );
        }else if ( tipoDoCampo.compareTo("0") == 0 ){
            this.verificaSeCampoEZerado(campo, campoNaLinha, numLinha);
        }

    }

    public void verificaSeCampoEBranco( Campo campo, String campoNaLinha, int numLinha ){

        for (int i = 0; i < campoNaLinha.length(); i++) {
            String caractere = campoNaLinha.charAt(i) + "";
            if ( caractere.compareTo(" ") != 0 ){
                this.error.adicionaMensagemError("O campo: " + campo.getNome() + " na linha: " + numLinha +
                    " deve está em branco mas contém Valor: "+ campoNaLinha );
                i = campoNaLinha.length();
            }
        }

    }


    public void verificaSeCampoENumerico( Campo campo, String campoNaLinha, int numLinha ){

        for (int i = 0; i < campoNaLinha.length(); i++) {
            String caractere = campoNaLinha.charAt(i) + "";
            try {
                int num = Integer.parseInt( caractere );
            } catch (NumberFormatException e) {
                this.error.adicionaMensagemError("O campo: " + campo.getNome() + " na linha: "+ numLinha +
                        " deve ser númerico. Valor do campo no arquivo: " + campoNaLinha);
                i = campoNaLinha.length();
            }
        }

    }


    public void verificaSeCampoEZerado(Campo campo, String campoNaLinha, int numLinha){

        for (int i = 0; i < campoNaLinha.length(); i++) {
            String caractere = campoNaLinha.charAt(i) + "";
            if ( caractere.compareTo("0") != 0 ){
                this.error.adicionaMensagemError("O campo: " + campo.getNome() + " na linha: " + numLinha +
                        " deve está zerado mas contém Valor: "+ campoNaLinha );
                i = campoNaLinha.length();
            }
        }

    }





}
