package br.marco.chamadas;

import br.marco.modelos.CEP;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCep {

    public CEP consultar (String cepConsulta) {

        CEP cep = new CEP();

        if (cepConsulta.length() != 8) {
            System.out.println("Formato de CEP inválido");
        } else {

            String url = "http://viacep.com.br/ws/" +
                    cepConsulta +
                    "/json";
            try {

                // constrói a requisição
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 400) {
                    System.out.println("CEP inexistente !");
                } else {

                    String jsonBody = response.body();
                    Gson gson = new Gson();
                    cep = gson.fromJson(jsonBody, CEP.class);

                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        return cep;
    }
}
