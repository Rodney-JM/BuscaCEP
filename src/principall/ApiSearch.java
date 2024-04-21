package principall;

import modelos.Cep;
import modelos.Viacep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiSearch {
    private Scanner scan;
    private Gson gson;

    public ApiSearch(){
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        scan = new Scanner(System.in);
    }

    public void searchCep()throws IOException {
        String searchedCep = "";
        List<Cep> cepList = new ArrayList<>();

        while(!searchedCep.equalsIgnoreCase("sair")){
            System.out.println("Digite o número do seu CEP: ");
            searchedCep = scan.nextLine();

            String apiRequestAddress = "http://viacep.com.br/ws/" + searchedCep + "/json/";
            apiRequestAddress = apiRequestAddress.replace("-", "");

            if (searchedCep.equalsIgnoreCase("sair")){
                break;
            }

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiRequestAddress))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                Viacep cepVia = gson.fromJson(response.body(), Viacep.class);

                Cep cep = new Cep(cepVia);
                System.out.println(cep);
                cepList.add(cep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter writer = new FileWriter("lista_de_ceps.json");
        writer.write(gson.toJson(cepList));
        writer.close();
    }
}
