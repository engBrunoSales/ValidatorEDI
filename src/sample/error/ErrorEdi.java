package sample.error;

import java.util.ArrayList;

/**
 * Created by brunosales on 07/09/15.
 */
public class ErrorEdi {

    private static ArrayList<String> mensagemError = new ArrayList<String>();

    public ErrorEdi() {

    }

    public ArrayList<String> getMensagemError() {
        return mensagemError;
    }


    public void adicionaMensagemError( String mensagem ){

        //if ( mensagem != "" && mensagem != " " ){
            mensagemError.add(mensagem);
        //}

    }





}
