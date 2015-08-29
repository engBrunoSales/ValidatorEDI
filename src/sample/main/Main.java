package sample.main;

import org.json.JSONObject;
import sample.cnab.Cnab;
import sample.edi.Edi;

import javax.lang.model.type.NullType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.StringCharacterIterator;
import java.util.Scanner;

/**
 * Created by brunosales on 28/08/15.
 */
public class Main {

    private Cnab cnab;
    private Edi edi;


    private String lerArquivo( String path ){
        String linha = null;
        try {
            FileReader arq = new FileReader( path );
            BufferedReader lerArq = new BufferedReader( arq );

            linha = lerArq.readLine();
            while ( linha != null ) {

                linha += lerArq.readLine(); // lê da segunda até a última linha

            }

            arq.close( );
        } catch ( IOException e ) {
            System.err.printf( "Erro na abertura do arquivo: %s.\n",
                    e.getMessage( ) );
        }

        if ( linha == null ){
            System.err.println( "Arquivo se encontra vazio!!" );
        }


        return linha;
    }

    public void cabecalho(){

        System.out.println("------------------Sistema de Verificação de EDI Bancário------------------------");
        System.out.println("Developer: Bruno Sales");
        System.out.println("IFCE - 2015");

    }

    public void programa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usuário para podermos continuar o processo de verificação EDI Bancário por favor\n coloque " +
                "o caminho do arquivo de configuração EDI referemte ao arquivo que se quer verificar.");
        System.out.println();

        System.out.print("Caminho do arquivo de Configuração(.json): ");
        String pathJson = scanner.nextLine();
        System.out.println();
        //Ler o arquivo json e define o objeto cnab
        String json = this.lerArquivo( pathJson );
        this.cnab = new Cnab();
        this.cnab.jsonForObject( json );


        System.out.print("Caminho do arquivo(.txt): ");
        String pathArquivo = scanner.nextLine();
        System.out.println();
        //Ler o arquivo txt e faz a verificação de todos os registros e todos os campos
        String txt = this.lerArquivo( pathArquivo );


    }


    public static void main( String args[] ){

        Main main = new Main();
        main.cabecalho();
        main.programa();


    }

}
