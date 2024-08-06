import br.marco.chamadas.ConsultarCep;
import br.marco.chamadas.GravadorDeArquivo;
import br.marco.modelos.CEP;
//import com.google.gson.FieldNamingPolicy;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cepConsulta;
        GravadorDeArquivo gravador = new GravadorDeArquivo();
        gravador.open("arquivoDeCEPs.txt");

        while (true) {

            cepConsulta = lerCEP();

            if (cepConsulta.compareTo("fim") == 0) {
                break;
            } else {

                ConsultarCep consultarCep = new ConsultarCep();
                CEP cep = consultarCep.consultar(cepConsulta);

                if (cep.getCep().isEmpty()) {
                    System.out.println("CEP inexistente");
                } else {
                    System.out.println("CEP " + cep);
                    gravador.write(cep);
                }
            }
        }

        gravador.close();
    }

    public static String lerCEP () {

        Scanner leitor = new Scanner (System.in);
        String cep;

        System.out.printf("Digite um CEP :");
        cep =  leitor.nextLine();

        return cep;
    }
}