package br.com.hcgv.gitsearch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        String escolha = "sim";

        while (escolha.equals("sim")) {
            System.out.println("\nInforme o nick do usuário: "); // pedindo o nickname para o usuario
            var name = sc.nextLine();

            String endereco = "https://api.github.com/users/" + name.replace(" ", ""); // URL pra consumier a API do usuario
            System.out.println("Procurando por " + name.replace(" ", "+") + "... ");  // message
            String dadosBuscados = "a";

            HttpClient client = HttpClient.newHttpClient();   // novo client
            HttpRequest request = HttpRequest.newBuilder()    // requisicao http
                    .uri(URI.create(endereco))     //jogo a URL da API no ".create"
                    .build();
            HttpResponse<String> response = client   // peguei a response em String
                    .send(request, HttpResponse.BodyHandlers.ofString());
            dadosBuscados = response.body();  // armazenei em uma variavel


            if (!dadosBuscados.equals("{\"message\":\"Not Found\",\"documentation_url\":" +
                    "\"https://docs.github.com/rest/users/users#get-a-user\"}") && !dadosBuscados.equals("a")) {  // condition

                System.out.println("\nUsuário encontrado com sucesso!");
                System.out.println(dadosBuscados);    // imprimi na tela os dados

                Gson gson = new GsonBuilder()  // gson para extrair os atributos do user
                        .create();
                User user = gson.fromJson(dadosBuscados, User.class);  // extrai para a classe User.class
                System.out.println(user); // imprimi os dados formatados
            } else {
                System.out.println("Usuário não encontrado");
            }
            System.out.println("\nDeseja procurar por mais usuários? (sim/não)");
            escolha = sc.nextLine();
        }
        System.out.println("\nEncerrando...");

        sc.close();
    }
}
