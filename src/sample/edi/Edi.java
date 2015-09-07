package sample.edi;

import sample.cnab.Cnab;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by brunosales on 13/07/15.
 */
public class Edi {

    private Cnab cnab;
    private String arquivo;


    public Edi( Cnab cnab, String arquivo )  {

        this.cnab = cnab;
        this.arquivo = arquivo;

    }


    public void lerArquivo(){

        String auxArquivo = this.arquivo;
        String[] linha = auxArquivo.split("\n", -1);


    }

    public void lerLinhaArquivo( String linha ){

        for( int j = 0; j < linha.length(); j++ ){

        }

    }





}
