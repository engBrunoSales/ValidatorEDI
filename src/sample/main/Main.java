package sample.main;


import sample.cnab.Cnab;
import sample.edi.Edi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by brunosales on 28/08/15.
 */
public class Main {

    private Cnab cnab;
    private Edi edi;


    private String lerArquivo( String path ){

        String linha = null;
        String arquivo = "";

        try {
            FileReader arq = new FileReader( path );
            BufferedReader lerArq = new BufferedReader( arq );

            linha = lerArq.readLine();
            if ( linha == null || linha == "" || linha == " "){
                System.err.println( "Arquivo se encontra vazio!!" );
            }
            arquivo += linha;

            while ( linha != null ) {

                linha = lerArq.readLine(); // lê da segunda até a última linha
                if( linha != null ){
                    arquivo += linha;
                }

            }

            arq.close( );
        } catch ( IOException e ) {
            System.err.printf( "Erro na abertura do arquivo: %s.\n",
                    e.getMessage( ) );
        }

        if ( arquivo == null || arquivo == "" || arquivo == " " ){
            System.err.println( "Arquivo se encontra vazio!!" );
        }


        return arquivo;
    }

    public void cabecalho(){

        System.out.println("------------------Sistema de Verificação de EDI Bancário------------------------");
        System.out.println("Developer: Bruno Sales");
        System.out.println("IFCE - 2015");

    }

    public void programa(){
        Scanner scanner =   new Scanner(System.in);
        System.out.println("Usuário para podermos continuar o processo de verificação EDI Bancário por favor\n coloque " +
                "o caminho do arquivo de configuração EDI referemte ao arquivo que se quer verificar.");
        System.out.println();

        System.out.println("Caminho do arquivo de Configuração(.json): ");
        String pathJson = scanner.next();
        System.out.println();
        //Ler o arquivo json e define o objeto cnab
        String json = this.lerArquivo( pathJson );
        this.cnab = new Cnab();
        this.cnab.jsonForObject( json );


        System.out.println("Caminho do arquivo para verifição(.txt): ");
        String pathArquivo = scanner.next();
        System.out.println();
        //Ler o arquivo txt e faz a verificação de todos os registros e todos os campos
        String txtArquivo = this.lerArquivo( pathArquivo );
        Edi edi = new Edi(this.cnab, txtArquivo );
        edi.lerArquivo();

    }


    public static void main( String args[] ){

        Main main = new Main();
        main.cabecalho();
        main.programa();


    }

}
