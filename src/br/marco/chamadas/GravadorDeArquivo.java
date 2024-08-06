package br.marco.chamadas;

import java.io.FileWriter;
import java.io.IOException;

public class GravadorDeArquivo {

    FileWriter gravador;

    public boolean open(String fileName) {

        boolean open = false;

        try {
            gravador = new FileWriter("dadosCep.txt");
            open = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return open;
    }

    public boolean write(Object objeto) {

        boolean write = false;

        try {
            gravador.write(objeto.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return write;
    }

    public boolean close (){

        boolean close = false;

        try {
            gravador.close();
            close = true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return close;
    }
}
